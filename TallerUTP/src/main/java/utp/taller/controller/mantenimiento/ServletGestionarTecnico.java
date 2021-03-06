package utp.taller.controller.mantenimiento;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoDistrito;
import utp.taller.dao.DaoEspecialidad;
import utp.taller.dao.DaoTecnico;
import utp.taller.dto.DtoEspecialidad;
import utp.taller.dto.DtoTecnicoConsulta;
import utp.taller.entidades.Distrito;
import utp.taller.entidades.Tecnico;

/**
 * Servlet implementation class ServletGestionarTecnico
 */
@WebServlet("/ServletGestionarTecnico")
public class ServletGestionarTecnico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DaoTecnico daoTec = new DaoTecnico();
	private DaoEspecialidad daoEsp = new DaoEspecialidad();
	private Tecnico tecnico = new Tecnico();
	private int idTecnico;
	private static String tipoLista;

    public ServletGestionarTecnico() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String accion = request.getParameter("accion");
    	
		if (tipoLista == null && request.getParameter("lista")==null) {
			tipoLista = "todos";
		}else if(request.getParameter("lista")!=null) {
			tipoLista = request.getParameter("lista");
		}

		
    	switch (accion) {
			case "listar": 
					listar(request, tipoLista);
				 	break;
			
			case "insertar":
					recuperarDatos(request);
					// solo cuando inserta puede darle una contraseņa
					tecnico.setContrasena(request.getParameter("txt_pass"));
					daoTec.insertar(tecnico);
					int maxId = daoEsp.maxId();
					if(tecnico.getIdsEspecialidad()!=null) {
						daoEsp.actualizar(maxId, tecnico.getIdsEspecialidad());
					}
    				listar(request, tipoLista);
				break;
				 	
			case "editar":
				    idTecnico = Integer.parseInt(request.getParameter("id"));
					tecnico = daoTec.consultarId(idTecnico);
					request.setAttribute("tec", tecnico);
					request.getSession().setAttribute("fila", idTecnico);
    				listar(request, tipoLista);
    				listarEspecialidadesTecnico(request, idTecnico);
					break;
			
			case "actualizar":
					recuperarDatos(request);
					daoTec.modificar(tecnico);
					if(tecnico.getIdsEspecialidad()!=null) {
						daoEsp.actualizar(idTecnico, tecnico.getIdsEspecialidad());
					}
					request.getSession().removeAttribute("fila");
					listar(request, tipoLista);
					break;
					
			case "activar":
					idTecnico = Integer.parseInt(request.getParameter("id"));
					daoTec.cambiarEstado(idTecnico, true);
					listar(request, tipoLista);
					break;
			
			case "desactivar":
					idTecnico = Integer.parseInt(request.getParameter("id"));
					daoTec.cambiarEstado(idTecnico, false);
					listar(request, tipoLista);
					break;
		}

    	listarEspecialidades(request);
		listarDistritos(request);
    	request.getRequestDispatcher("vista/encargado/gestionTecnicos.jsp").forward(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void listarEspecialidades(HttpServletRequest request) {
		if(request.getSession().getAttribute("lstEspecialidades")==null) {
			
			List<DtoEspecialidad> lstEspecialidades = daoEsp.listar();
			request.getSession().setAttribute("lstEspecialidades", lstEspecialidades);
		}
	}
	
	private void listarEspecialidadesTecnico(HttpServletRequest request, int idTecnico) {
		List<DtoEspecialidad> lstEspecialidades = daoEsp.listar(idTecnico);
		request.setAttribute("lstEspecialidadesTecnico", lstEspecialidades);
	}
	
	private void listarDistritos(HttpServletRequest request) {
		if(request.getSession().getAttribute("lstDistritos")==null) {
			DaoDistrito daoDistr = new DaoDistrito();
			List<Distrito> lst = daoDistr.listar();
			request.getSession().setAttribute("lstDistritos", lst);
		}
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
		tecnico.setAniosExperiencia(Integer.parseInt(request.getParameter("experiencia")));
		tecnico.setDireccion(request.getParameter("txt_direcc"));
		tecnico.setEmail(request.getParameter("txt_correo"));
		tecnico.setEstadoActivo(Boolean.parseBoolean(request.getParameter("estado")));
		
		String[] idEspStrings = request.getParameterValues("ids_especialidad");
		if(idEspStrings!=null) {
			tecnico.setIdsEspecialidad(Arrays.stream(idEspStrings).mapToInt(Integer::parseInt).toArray()); 
			System.out.println("IDs seleccionados:"+Arrays.toString(idEspStrings));
		}else{
			tecnico.setIdsEspecialidad(null);
			System.out.println("array de ids nulo");
		}
	}
	
	private void listar(HttpServletRequest request, String tipoLista) {

		List<DtoTecnicoConsulta> lst;

	 	switch (tipoLista) {
		case "activos":
			lst = daoTec.listarDtoTecnicos(true);
			break;
		case "inactivos":
			lst = daoTec.listarDtoTecnicos(false);
			break;	
		default:
			lst = daoTec.listarDtoTecnicos();
			break;
		}
	 	request.setAttribute("lstConsultaTecnicos", lst);
	}
	
}