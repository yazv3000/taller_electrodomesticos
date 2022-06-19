package utp.taller.controller.mantenimiento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoHorario;
import utp.taller.dao.DaoTecnico;
import utp.taller.dto.DtoTecnicoNombre;
import utp.taller.entidades.Horario;

/**
 * Servlet implementation class ServletProgramacionHorario
 */
@WebServlet("/ServletGestionarHorario")
public class ServletGestionarHorario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	
	public ServletGestionarHorario() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		switch (accion) {
		case "listar":
			listar(request);
			break;
		case "generar":
			int horaInicio = Integer.parseInt(request.getParameter("hInicio").substring(0, 2));
			int horaFinal = Integer.parseInt(request.getParameter("hFinal").substring(0, 2));
			int mes = Integer.parseInt(request.getParameter("mes"));

			if (horaFinal > horaInicio) {

				int intervalo = horaFinal - horaInicio;

				List<DtoTecnicoNombre> lst = (List<DtoTecnicoNombre>) request.getSession().getAttribute("lstSH");
				List<DtoTecnicoNombre> lstInsertar = new ArrayList<DtoTecnicoNombre>(); // TECNICOS A INSERTAR

				// OBTENER LOS TECNICOS SELECCIONADOS
				String[] idTecStrings = request.getParameterValues("tecnico");
				if (idTecStrings != null) {
//					for (int i = 0; i < idTecStrings.length; i++) {
//						System.out.println("Id del tecnico: " + idTecStrings[i] + " : index: " + (i));
//					}
					
					for (int i = 0; i < idTecStrings.length; i++) {
						for (int j = 0; j < lst.size(); j++) {
							if (Integer.parseInt(idTecStrings[i]) == lst.get(j).getId()) {
								lstInsertar.add(lst.get(j));
							}
						}
					}
//					for (DtoTecnicoNombre dtoTec : lstInsertar) {
//						System.out.println(dtoTec.getId() + " " + dtoTec.getNombre());
//					}
				}

				// SimpleDateFormat format = new SimpleDateFormat(); //No se utiliza
				Calendar calendar = Calendar.getInstance();
				calendar.set(2022, mes - 1, 1);
				System.out.println(horaInicio + "  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				DaoHorario daoHorario = new DaoHorario();
				for (DtoTecnicoNombre dtoTecnico : lstInsertar) {
					for (int i = 0; i < diasDelMes(mes, 2022); i++) {
						for (int j = 0; j <= intervalo; j++) {
							if(calendar.get(Calendar.DAY_OF_WEEK)!=1) {
								Horario horario = new Horario();
								horario.setIdTecnico(dtoTecnico.getId());
								horario.setFechaAtencion(calendar.getTime());
								horario.setHoraInicio(((intervalo < 10) ? ("0" + (horaInicio + j)) : horaInicio + j) + ":00:00"); //ARREGLAR
								daoHorario.insertarHorario(horario);
							}
						}
						calendar.add(Calendar.DATE, 1);
					}
					calendar.set(2022, mes - 1, 1);
				}
			}
			request.getSession().setAttribute("mes", mes);
			listar(request);
			break;
		case "show":
			
			break;
		}

		request.getRequestDispatcher("vista/encargado/gestionHorarios.jsp").forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

	}

	private void listar(HttpServletRequest request) {
		int m = Integer.parseInt(request.getParameter("mes"));

		DaoTecnico dao = new DaoTecnico();
		List<DtoTecnicoNombre> lstSH = dao.listarTecnicos();
		List<DtoTecnicoNombre> lstCH = dao.listarTecnicoConHorario(m, 2022);

		for (int i = 0; i < lstCH.size(); i++) {
			for (int j = 0; j < lstSH.size(); j++) {
				if (lstCH.get(i).getId() == lstSH.get(j).getId()) {
					lstSH.remove(j);
				}
			}
		}
		request.getSession().setAttribute("mes", m);
		request.getSession().setAttribute("lstSH", lstSH);
		request.setAttribute("lstCH", lstCH);
	}

	protected int diasDelMes(int mes, int anyo) {
		int numDias = 0;

		switch (mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			numDias = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDias = 30;
			break;
		case 2:
			if ((anyo % 4 == 0 && anyo % 100 != 0) || anyo % 400 == 0) {
				numDias = 29;
			} else {
				numDias = 28;
			}
			break;
		default:

			break;
		}

		return numDias;
	}

}
