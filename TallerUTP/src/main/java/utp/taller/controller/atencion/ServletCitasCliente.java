package utp.taller.controller.atencion;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoAtencion;
import utp.taller.dto.DtoCitaConsulta;
import utp.taller.dto.DtoUsuario;

/**
 * Servlet implementation class ServletCitasCliente
 */
@WebServlet("/ServletCitasCliente")
public class ServletCitasCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DaoAtencion dao = new DaoAtencion();
	
    public ServletCitasCliente() {
        super();
    }

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Precondición cliente ha iniciado sesión
		DtoUsuario user_cliente = (DtoUsuario) request.getSession().getAttribute("dtoUsuario");
		
		if(user_cliente==null) {
			System.out.println("*".repeat(20)+ "No ha iniciado sesión"+"*".repeat(20));
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else {
			List<DtoCitaConsulta> lst = dao.listarCitasCliente(user_cliente.getIdPersona());

			request.getSession().setAttribute("lstCitasCliente", lst);
			request.getRequestDispatcher("/vista/cliente/citasReservadas.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
