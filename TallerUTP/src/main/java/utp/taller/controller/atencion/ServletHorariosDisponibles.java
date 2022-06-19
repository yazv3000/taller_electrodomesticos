package utp.taller.controller.atencion;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoHorario;
import utp.taller.dao.DaoTecnico;
import utp.taller.dto.DtoTecnicoConsulta;
import utp.taller.dto.DtoUsuario;
import utp.taller.entidades.Horario;

/**
 * Servlet implementation class ServletHorariosDisponibles
*/
@WebServlet("/ServletHorariosDisponibles")
public class ServletHorariosDisponibles extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public ServletHorariosDisponibles() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Precondición cliente ha iniciado sesión
		if(request.getSession().getAttribute("dtoUsuario")==null) {
			System.out.println("*".repeat(20)+ "No ha iniciado sesión"+"*".repeat(20));
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else {
			String idServicio = request.getParameter("id_servicio");
			request.getSession().setAttribute("id_servicio", idServicio);	
			System.out.println("El cliente ha seleccionado el servicio: "+idServicio);
			listarHorarios(request, response);
		}	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listarHorarios(request, response);
	}
	
	protected void listarHorarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter("accion");
		
		switch (accion) {
			case "listar":
				Map<DtoTecnicoConsulta,List<Map<String, List<Horario>>>> lstHorarios = todosLosHorarios();
				
				request.setAttribute("lsthorario", lstHorarios);
				request.getRequestDispatcher("/vista/cliente/horarios.jsp").forward(request, response);
			break;
			
			case "listarTecnico":
				DtoUsuario dtoUsuario = (DtoUsuario) request.getSession().getAttribute("dtoUsuario");
				
				request.setAttribute("idTecnico", dtoUsuario.getIdPersona());
			
				List<Map<String, List<Horario>>> horarios = obtenerHorario(dtoUsuario.getIdPersona(),7);
				request.setAttribute("horarios", horarios);
				request.getRequestDispatcher("/vista/tecnico/tecnico-horario.jsp").forward(request, response);
			break;
			default:
				request.getRequestDispatcher("ServletGestionarCliente?accion=listar").forward(request, response);
			break;
		}
	}
	
	
	private Map<DtoTecnicoConsulta,List<Map<String, List<Horario>>>> todosLosHorarios() {

		DaoTecnico dao = new DaoTecnico();
		
		// Lista de técnicos
		List<DtoTecnicoConsulta> lstTecnicos = dao.listarDtoTecnicos();
		
		Map<DtoTecnicoConsulta, List<Map<String, List<Horario>>>> lstHorarios = new LinkedHashMap<>();
		
		for (int i = 0; i < lstTecnicos.size(); i++) {
			lstHorarios.put(lstTecnicos.get(i), obtenerHorario(lstTecnicos.get(i).getIdPersona(), 7));
		}
		
		return lstHorarios;
	}
	

	private List<Map<String, List<Horario>>> obtenerHorario(int idTecnico, int dias) {
		
		DaoHorario dao = new DaoHorario();
		List<Horario> listahorarios = dao.listar();

		// Fecha de actual
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Date fecha = c.getTime();
		
		// Lista de horarios (de cada técnico) agrupados en weeks
		List<Map<String, List<Horario>>> lstHorarioSemana = new ArrayList<>();
		Map<String, List<Horario>> listaFechaHoras; 
		List<Horario> listaHoras = null;
		
		LocalDate diaMes = null; 
		ZoneId timeZone = ZoneId.systemDefault();	// zona horaria por defecto del sistema 
		
		for (int week = 0; week < 8; week++) {

			listaFechaHoras = new LinkedHashMap<>();
			for (int day = 0; day < dias; day++) {
				
				fecha = c.getTime();
				final Date fecha2 = fecha;
				diaMes = fecha.toInstant().atZone(timeZone).toLocalDate();

				// Filtrar horarios según idTecnico, fecha y ordenarlos
				listaHoras = listahorarios.stream().filter(h -> h.getIdTecnico() == idTecnico)
						.filter(h -> h.getFechaAtencion().equals(fecha2))
						.sorted((x, y) -> x.getHoraInicio().compareTo(y.getHoraInicio())).collect(Collectors.toList());
	
				
				// Map: 	key: dd mes
				// 				value: lstHoras
				listaFechaHoras.put(diaMes.getDayOfMonth()+" " + diaMes.getMonth(), listaHoras);
				
				c.add(Calendar.DATE, 1);
			}
			lstHorarioSemana.add(listaFechaHoras);
		}
		return lstHorarioSemana;
	}

}
