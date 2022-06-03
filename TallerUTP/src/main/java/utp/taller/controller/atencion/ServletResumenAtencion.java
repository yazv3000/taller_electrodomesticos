package utp.taller.controller.atencion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoAtencion;
import utp.taller.dto.DtoAtencion;

/**
 * Servlet implementation class ServletResumenAtencion
 */
@WebServlet("/ServletResumenAtencion")
public class ServletResumenAtencion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DaoAtencion dao = new DaoAtencion();
    
    public ServletResumenAtencion() {
        super();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int idAtencion = Integer.parseInt(request.getParameter("id"));
    	DtoAtencion ate = dao.listarAtencion(idAtencion);
    	request.setAttribute("ate", ate);
    	request.getRequestDispatcher("vista/tecnico/ResumenAtencion.jsp").forward(request, response);
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
