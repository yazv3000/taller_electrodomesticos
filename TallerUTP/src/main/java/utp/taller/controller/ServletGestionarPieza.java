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
       
	DaoPieza dao = new DaoPieza();
	Pieza pieza;
 
    public ServletGestionarPieza() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String accion = request.getParameter("accion");
    	
    	switch (accion) {
		case "listar": 
			 	List<Pieza> lst = dao.listar();
			 	request.setAttribute("lstConsultaPiezas", lst);
			break;
		case "editar":
		    int id= Integer.parseInt(request.getParameter("id"));
			pieza = dao.consultarId(id);
			request.setAttribute("pi", pieza);
			request.getRequestDispatcher("ServletGestionarPieza?accion=listar").forward(request, response);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + accion);
		}
    	listarCategorias(request);
    	request.getRequestDispatcher("vista/encargado/gestionPiezas.jsp").forward(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	private void listarCategorias(HttpServletRequest request) {
		DaoPieza daoPi = new DaoPieza();
		List<CategoriaPieza> lst = daoPi.listarCategorias();
		request.getSession().getServletContext().setAttribute("lstCategorias", lst);
	}
	

}
