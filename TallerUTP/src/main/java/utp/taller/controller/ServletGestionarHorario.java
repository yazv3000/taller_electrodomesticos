package utp.taller.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
import utp.taller.dto.DtoHorario;
import utp.taller.dto.DtoTecnicoConsulta;
import utp.taller.dto.DtoUsuario;

/**
 * Servlet implementation class ServletGestionarTecnico
 */
@WebServlet("/ServletGestionarHorario")
public class ServletGestionarHorario extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ServletGestionarHorario() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");
		
		
		
		
		switch (accion) {
		case "listar":
			Map<DtoTecnicoConsulta,List<Map<String, List<DtoHorario>>>> lstHorarios = todosLosHorarios();
			String servicio = request.getParameter("servicio");
			request.setAttribute("servicio",servicio);
			request.setAttribute("lsthorario", lstHorarios);
			request.getRequestDispatcher("/vista/cliente/horarios.jsp").forward(request, response);
			break;
		case "listarTecnico":
			System.out.println("entre we");
			DtoUsuario dtoUsuario = (DtoUsuario) request.getSession().getAttribute("dtoUsuario");
			request.setAttribute("idTecnico", dtoUsuario.getIdPersona());
			obtenerHorario(dtoUsuario.getIdPersona(), 7);
			System.out.println(dtoUsuario.getIdPersona());
			List<Map<String, List<DtoHorario>>> horarios =obtenerHorario(dtoUsuario.getIdPersona(),7);
			request.setAttribute("horarios", horarios);
			request.getRequestDispatcher("/vista/tecnico/tecnico-horario.jsp").forward(request, response);
			break;
		default:
			request.getRequestDispatcher("ServletGestionarCliente?accion=listar").forward(request, response);
		}

		
	}
	
	
	private Map<DtoTecnicoConsulta,List<Map<String, List<DtoHorario>>>> todosLosHorarios() {

		
		DaoTecnico dao = new DaoTecnico();
		List<DtoTecnicoConsulta> lstTecnicos = dao.listarDtoTecnicos();
		
		Map<DtoTecnicoConsulta,List<Map<String, List<DtoHorario>>>> lstHorarios = new LinkedHashMap<>();
		
		for (int i = 0; i < lstTecnicos.size(); i++) {
			lstHorarios.put(lstTecnicos.get(i),obtenerHorario(lstTecnicos.get(i).getIdPersona(), 4));
			
		}
		
		return lstHorarios;
	}
	

	private List<Map<String, List<DtoHorario>>> obtenerHorario(int idTecnico, int dias) {
		

		DaoHorario dao = new DaoHorario();
		List<DtoHorario> listahorarios = dao.listar();

		Date fecha = new Date(); // 20/05/22
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		fecha = c.getTime();
		System.out.println(fecha+ "  //ZZZZZZZ fecha");
		// map.get(map.keySet().toArray()[0]);
		List<Map<String, List<DtoHorario>>> lstHorarioSemana = new ArrayList<>();
		Map<String, List<DtoHorario>> listaFechaHoras; 
		List<DtoHorario> listaHoras = null;
		
		LocalDate diaMes =null; 
		ZoneId timeZone = ZoneId.systemDefault();
		
		for (int week = 0; week < 4; week++) {

			listaFechaHoras = new LinkedHashMap<>();
			for (int day = 0; day < dias; day++) {
				
				fecha = c.getTime();
				final Date fecha2 = fecha;
				diaMes = fecha.toInstant().atZone(timeZone).toLocalDate();

				listaHoras = listahorarios.stream().filter(h -> h.getIdTecnico() == idTecnico)
						.filter(h -> h.getFechaAtencion().equals(fecha2))
						.sorted((x, y) -> x.getHoraInicio().compareTo(y.getHoraInicio())).collect(Collectors.toList());
	
				//listaFechaHoras.put(formato.format(fecha), listaHoras);
				listaFechaHoras.put(diaMes.getDayOfMonth()+" " + diaMes.getMonth(), listaHoras);
				
				c.add(Calendar.DATE, 1);
			}
			lstHorarioSemana.add(listaFechaHoras);
			
		}
		return lstHorarioSemana;
	}

}
