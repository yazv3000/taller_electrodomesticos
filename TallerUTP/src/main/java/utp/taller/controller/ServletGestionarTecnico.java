package utp.taller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoDistrito;
import utp.taller.dao.DaoEspecialidad;
import utp.taller.dao.DaoTecnico;
import utp.taller.dto.DtoTecnicoConsulta;
import utp.taller.entidades.Distrito;
import utp.taller.entidades.Especialidad;
import utp.taller.entidades.Tecnico;

/**
 * Servlet implementation class ServletGestionarTecnico
 */
@WebServlet("/ServletGestionarTecnico")
public class ServletGestionarTecnico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DaoTecnico dao = new DaoTecnico();
	
 
    public ServletGestionarTecnico() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String accion = request.getParameter("accion");
    	
    	switch (accion) {
			case "listar": 
				 	List<DtoTecnicoConsulta> lst = dao.listarDtoTecnicos();
				 	request.setAttribute("lstConsultaTecnicos", lst);
				 	break;
			
			case "editar":
				    int id= Integer.parseInt(request.getParameter("id"));
					Tecnico tecnico = dao.consultarId(id);
					request.setAttribute("tec", tecnico);
					
					//request.getRequestDispatcher("ServletGestionarTecnico?accion=listar").include(request, response);
					break;
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + accion);
		}
    	
    	listarEpescialidades(request);
		listarDistritos(request);
    	request.getRequestDispatcher("vista/encargado/gestionTecnicos.jsp").forward(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	private void listarEpescialidades(HttpServletRequest request) {
		DaoEspecialidad daoDistr = new DaoEspecialidad();
		List<Especialidad> lstEspecialidades = daoDistr.listar();
		request.getSession().getServletContext().setAttribute("lstEspecialidades", lstEspecialidades);
	}
	private void listarDistritos(HttpServletRequest request) {
		DaoDistrito daoDistr = new DaoDistrito();
		List<Distrito> lst = daoDistr.listar();
		request.getSession().getServletContext().setAttribute("lstDistritos", lst);
	}
}
