package utp.taller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoElectrodomestico;
import utp.taller.dto.DtoClienteConsulta;
import utp.taller.dto.DtoElectrodomesticoConsulta;
import utp.taller.entidades.Electrodomestico;

/**
 * Servlet implementation class ServletGestionarElectrodomestico
 */
@WebServlet("/ServletGestionarElectrodomestico")
public class ServletGestionarElectrodomestico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private DaoElectrodomestico dao = new DaoElectrodomestico();
    private Electrodomestico electrodom = new Electrodomestico();
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
					cliente.setContrasena(request.getParameter("txt_pass"));
					dao.insertar(cliente);
					listar(request, tipoLista);
				break;
				
			case "editar":
					idPCliente = Integer.parseInt(request.getParameter("id"));
					cliente = dao.consultarId(idPCliente);
					request.setAttribute("cli", cliente);
					listar(request, tipoLista);
				break;
			
			case "actualizar":
					System.out.println("actualizando");
					System.out.println(cliente);	
					recuperarDatos(request);
					System.out.println(cliente);	
					dao.modificar(cliente);	
					listar(request, tipoLista);
					break;

			case "activar":				
					idPCliente = Integer.parseInt(request.getParameter("id"));
					dao.cambiarEstado(idPCliente, true);
					listar(request, tipoLista);
			break;
			
			case "desactivar":
					idPCliente = Integer.parseInt(request.getParameter("id"));
					dao.cambiarEstado(idPCliente, false);
					listar(request, tipoLista);
				break;
		}
    	
    	listarDistritos(request);
    	request.getRequestDispatcher("vista/encargado/gestionClientes.jsp").forward(request, response);
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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

}
