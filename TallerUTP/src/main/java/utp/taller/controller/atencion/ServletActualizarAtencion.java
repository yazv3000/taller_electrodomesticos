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
 * Servlet implementation class ServletActualizarAtencion
 */
@WebServlet("/ServletActualizarAtencion")
public class ServletActualizarAtencion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoAtencion dao = new DaoAtencion();
	
    public ServletActualizarAtencion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Precondición técnico ha iniciado sesión
		DtoUsuario user_tecnico = (DtoUsuario) request.getSession().getAttribute("dtoUsuario");
		
		if(user_tecnico==null) {
			
			System.out.println("*".repeat(20)+ "No ha iniciado sesión"+"*".repeat(20));
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else {
			List<DtoCitaConsulta> lst = dao.listarCitasDomicilio(user_tecnico.getIdPersona());
			request.getSession().setAttribute("lstConsultaCitas", lst);
			request.getRequestDispatcher("vista/tecnico/atencionDomicilio.jsp").forward(request, response);
		}
	}
	
}
