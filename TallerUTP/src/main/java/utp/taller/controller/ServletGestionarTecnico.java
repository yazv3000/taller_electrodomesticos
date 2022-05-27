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
       
	private DaoTecnico dao = new DaoTecnico();
	private Tecnico tecnico = new Tecnico();
	private int idTecnico;
	private byte[] foto;
	

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
			
			case "insertar":
					recuperarDatos(request);
					dao.insertar(tecnico);
					
					request.getRequestDispatcher("ServletGestionarTecnico?accion=listar").forward(request, response);
				break;
				 	
			case "editar":
				    idTecnico = Integer.parseInt(request.getParameter("id"));
					tecnico = dao.consultarId(idTecnico);
					request.setAttribute("tec", tecnico);
					
					request.getRequestDispatcher("ServletGestionarTecnico?accion=listar").include(request, response);
					break;
			
			case "desactivar":
					idTecnico = Integer.parseInt(request.getParameter("id"));
					dao.cambiarEstado(idTecnico);
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
		processRequest(request, response);
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
	
	private void recuperarDatos(HttpServletRequest request) {
		//foto = 
		
		tecnico.setNombrePrin(request.getParameter("txt_nom1"));
		tecnico.setNombreSec(request.getParameter("txt_nom2"));
		tecnico.setApePrin(request.getParameter("txt_ape1"));
		tecnico.setApeSec(request.getParameter("txt_ape2"));
		tecnico.setTipoDocumento(Integer.parseInt(request.getParameter("cbx_tipodoc")));
		tecnico.setNroDocumento(request.getParameter("num_doc"));
		tecnico.setTelefono(request.getParameter("num_telef"));
		tecnico.setIdDistrito(Integer.parseInt(request.getParameter("cbx_distritos")));
		tecnico.setDireccion(request.getParameter("txt_direcc"));
		tecnico.setEmail(request.getParameter("txt_correo"));
		tecnico.setEstadoActivo(Boolean.parseBoolean(request.getParameter("estado")));
	}
	
}
