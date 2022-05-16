package utp.taller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoCliente;
import utp.taller.dto.DtoClienteConsulta;


/**
 * Servlet implementation class ServletGestionarTecnico
 */
@WebServlet("/ServletGestionarCliente")
public class ServletGestionarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DaoCliente dao = new DaoCliente();
	
 
    public ServletGestionarCliente() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String accion = request.getParameter("accion");
    	
    	switch (accion) {
		case "listar": {
			 	List<DtoClienteConsulta> lst = dao.listarDtoClientes();
			 	request.setAttribute("lstConsultaClientes", lst);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + accion);
		}
    	
    	request.getRequestDispatcher("Vista/mantenimiento/gestionCliente.jsp").forward(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
