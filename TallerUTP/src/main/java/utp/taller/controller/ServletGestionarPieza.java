package utp.taller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoPieza;
import utp.taller.entidades.CategoriaPieza;
import utp.taller.entidades.Cliente;
import utp.taller.entidades.Pieza;


/**
 * Servlet implementation class ServletGestionarTecnico
 */
@WebServlet("/ServletGestionarPieza")
public class ServletGestionarPieza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DaoPieza dao = new DaoPieza();
	private Pieza pieza = new Pieza();
	private int idPieza;
 
    public ServletGestionarPieza() {
        super();
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
				dao.insertar(pieza);
				listar(request, tipoLista);
				break;
		case "editar":
			    idPieza = Integer.parseInt(request.getParameter("id"));
				pieza = dao.consultarId(idPieza);
				request.setAttribute("pi", pieza);
				listar(request, tipoLista);
				break;
				
		case "actualizar":
				recuperarDatos(request);
				System.out.println(pieza.toString());
				dao.modificar(pieza);
				listar(request, tipoLista);
				break;
				
		case "activar":
				idPieza = Integer.parseInt(request.getParameter("id"));
				dao.cambiarEstado(idPieza, true);
		break;
		
		case "desactivar":
				idPieza = Integer.parseInt(request.getParameter("id"));
				dao.cambiarEstado(idPieza, false);
			break;
    	}
    	
    	listarCategorias(request);
    	request.getRequestDispatcher("vista/encargado/gestionPiezas.jsp").forward(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void listarCategorias(HttpServletRequest request) {
		DaoPieza daoPi = new DaoPieza();
		List<CategoriaPieza> lst = daoPi.listarCategorias();
		request.getSession().setAttribute("lstCategorias", lst);
	}
	
	private void recuperarDatos(HttpServletRequest request) {
		
		pieza.setNomPieza(request.getParameter("txt_nombrePieza"));
		pieza.getCategoria().setIdCategoria(Integer.parseInt(request.getParameter("cbx_categoriaPieza")));
		pieza.setPrecio(Double.parseDouble(request.getParameter("precio")));
		pieza.setStock(Long.parseLong(request.getParameter("stock")));
		pieza.setEstadoActivo(Boolean.parseBoolean(request.getParameter("estado")));
	}
	private void listar(HttpServletRequest request, String tipoLista) {

		List<Pieza> lst;

	 	switch (tipoLista) {
		case "activos":
			lst = dao.listar(true);
			break;
		case "inactivos":
			lst = dao.listar(false);
			break;	
		default:
			lst = dao.listar();
		}
	 	request.setAttribute("lstConsultaPiezas", lst);
	}
}
