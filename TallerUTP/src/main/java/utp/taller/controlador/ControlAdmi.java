package utp.taller.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControAdmi
 */
@WebServlet("/ControlAdmi")
public class ControlAdmi extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		switch(accion) {
		case "Cliente":
			request.getRequestDispatcher("Vista/tblCliente.jsp").forward(request, response);
			break;
		case "Tecnico":
			request.getRequestDispatcher("Vista/tblTecnico.jsp").forward(request, response);
		default:
			throw new AssertionError();
		}
		
		
	}

}
