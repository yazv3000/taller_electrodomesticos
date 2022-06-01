package utp.taller.controller.mantenimiento;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoDistrito;
import utp.taller.dao.DaoEncargado;
import utp.taller.entidades.Distrito;


/**
 * Servlet implementation class ServletGestionarEncargado
 */
@WebServlet("/ServletGestionarEncargado")
public class ServletGestionarEncargado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DaoEncargado dao = new DaoEncargado();
	
	
    public ServletGestionarEncargado() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String accion = request.getParameter("accion");
    	
    	switch (accion) {
			case "listar": 
				 	
				break;
			
			case "editar":
			    
				break;
			
			default:
				request.getRequestDispatcher("ServletGestionarEncargado?accion=listar").forward(request, response);
		}
    	
    	listarDistritos(request);
    	request.getRequestDispatcher("vista/encargado/gestionEncargados.jsp").forward(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	private void listarDistritos(HttpServletRequest request) {
		DaoDistrito daoDistr = new DaoDistrito();
		List<Distrito> lst = daoDistr.listar();
		request.getSession().getServletContext().setAttribute("lstDistritos", lst);
	}

}
