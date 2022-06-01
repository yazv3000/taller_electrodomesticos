package utp.taller.controller.atencion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCitasCliente
 */
@WebServlet("/ServletCitasCliente")
public class ServletCitasCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCitasCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/vista/cliente/citasReservadas.jsp").forward(request, response);
	}

}
