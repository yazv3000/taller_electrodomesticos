package utp.taller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoTecnico;
import utp.taller.dto.DtoTecnicoConsulta;
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
					request.getRequestDispatcher("ServletGestionarTecnico?accion=listar").forward(request, response);
					break;
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + accion);
		}
    	
    	request.getRequestDispatcher("Vista/mantenimiento/gestionTecnico.jsp").forward(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
