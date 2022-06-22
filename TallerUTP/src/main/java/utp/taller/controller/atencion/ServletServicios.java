package utp.taller.controller.atencion;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoAtencion;
import utp.taller.dao.DaoServicio;
import utp.taller.entidades.Servicio;

/**
 * Servlet implementation class ServletServicios
 */
@WebServlet("/ServletServicios")
public class ServletServicios extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private DaoServicio dao = new DaoServicio();
	private DaoAtencion daoAte = new DaoAtencion();
    public ServletServicios() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		daoAte.bloquearHorarioDiaActual();
		if(request.getAttribute("lstServicios")==null) {
			List<Servicio> lst = dao.listar(true);
			
			request.getSession().setAttribute("lstServicios", lst);
		}
		request.getRequestDispatcher("vista/cliente/servicios.jsp").forward(request, response);
		
	}
}
