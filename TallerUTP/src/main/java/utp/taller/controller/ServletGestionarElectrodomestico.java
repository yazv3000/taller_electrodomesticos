package utp.taller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoCliente;
import utp.taller.dao.DaoElectrodomestico;
import utp.taller.dto.DtoClienteConsulta;
import utp.taller.dto.DtoElectrodomesticoConsulta;
import utp.taller.entidades.Electrodomestico;
import utp.taller.entidades.ElectrodomesticoMarca;
import utp.taller.entidades.ElectrodomesticoTipo;

/**
 * Servlet implementation class ServletGestionarElectrodomestico
 */
@WebServlet("/ServletGestionarElectrodomestico")
public class ServletGestionarElectrodomestico extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
    private DaoElectrodomestico dao = new DaoElectrodomestico();
    private Electrodomestico electrodomestico = new Electrodomestico();
    
    
    private int idElectrodomestico;
	
    public ServletGestionarElectrodomestico() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String accion = request.getParameter("accion");
    	String tipoLista = request.getParameter("lista");
    	
    	if (tipoLista == null) {
			tipoLista = "todos";
		}
    	
    	switch (accion) {

    		case "listar":
    				listar(request, tipoLista);
    			break;
    	
			case "insertar":
					recuperarDatos(request);
					dao.insertar(electrodomestico);
					listar(request, tipoLista);
				break;
				
			case "editar":
					idElectrodomestico = Integer.parseInt(request.getParameter("id"));
					electrodomestico = dao.consultarId(idElectrodomestico);
					request.setAttribute("el", electrodomestico);
					listar(request, tipoLista);
				break;
			
			case "actualizar":
					System.out.println("actualizando");	
					recuperarDatos(request);
					dao.modificar(electrodomestico);	
					listar(request, tipoLista);
					break;

			case "activar":				
					idElectrodomestico = Integer.parseInt(request.getParameter("id"));
					dao.cambiarEstado(idElectrodomestico, true);
					listar(request, tipoLista);
			break;
			
			case "desactivar":
					idElectrodomestico = Integer.parseInt(request.getParameter("id"));
					dao.cambiarEstado(idElectrodomestico, false);
					listar(request, tipoLista);
				break;
		}
    	listarTipos(request);
    	listarMarcas(request);
    	listarPropietarios(request);
    	request.getRequestDispatcher("vista/encargado/gestionElectrodomesticos.jsp").forward(request, response);
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void listar(HttpServletRequest request, String tipoLista) {

		List<DtoElectrodomesticoConsulta> lst;

	 	switch (tipoLista) {
		case "activos":
			lst = dao.listarDtoElectrodomesticos(true);
			break;
		case "inactivos":
			lst = dao.listarDtoElectrodomesticos(false);
			break;	
		default:
			lst = dao.listarDtoElectrodomesticos();
		}
	 	request.setAttribute("lstConsultaElectrodomesticos", lst);
	}
	private void listarPropietarios(HttpServletRequest request) {
		DaoCliente daoCli = new DaoCliente();
		List<DtoClienteConsulta> lst = daoCli.listarDtoClientes();
		request.getSession().setAttribute("lstPropietarios", lst);
	}
	private void listarTipos(HttpServletRequest request) {
		List<ElectrodomesticoTipo> lst = dao.listarTiposE();
		request.getSession().setAttribute("lstTipos", lst);
	}
	private void listarMarcas(HttpServletRequest request) {
		List<ElectrodomesticoMarca> lst = dao.listarMarcas();
		request.getSession().setAttribute("lstMarcas", lst);
	}
	
	private void recuperarDatos(HttpServletRequest request) {
		electrodomestico.setNroSerie(request.getParameter("txt_numSer"));
		electrodomestico.setIdtipoElectrod(Integer.parseInt(request.getParameter("cbx_tipos")));
		electrodomestico.setModelo(request.getParameter("txt_modelo"));
		electrodomestico.setIdmarca(Integer.parseInt(request.getParameter("cbx_marcas")));
		electrodomestico.setIdpropietario(Integer.parseInt(request.getParameter("cbx_propietario")));
		electrodomestico.setEstadoActivo(Boolean.parseBoolean(request.getParameter("cbx_estado")));
	}

}
