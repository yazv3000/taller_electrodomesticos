package utp.taller.controller.mantenimiento;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoAtencion;
import utp.taller.dto.DtoReporteConsulta;

/**
 * Servlet implementation class ServletReportes
 */
@WebServlet("/ServletReportes")
public class ServletReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoAtencion dao = new DaoAtencion();
	private DtoReporteConsulta rep = new DtoReporteConsulta();
	private static String tipoLista;
	SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-YYYY");
	
    public ServletReportes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			
    		case "seleccionar":
    			String persona = request.getParameter("persona"); 
    			if(persona.equals("tecnico")) {
    				request.setAttribute("por_persona", persona);
    			}else if(persona.equals("cliente")) {
    				request.setAttribute("por_persona", persona);
    			}else {
    				System.out.println("ninguno");
    			}
    		break;
    		case "buscar_tecnico":
    			listar(request, "tecnico");
    		break;
    		
    		case "buscar_cliente":
    			listar(request, "cliente");
        		break;
		}
    	
		request.getRequestDispatcher("vista/encargado/reportes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
		
	}

	
	private void listar(HttpServletRequest request, String tipoLista) {

		List<DtoReporteConsulta> lst;

		
	 	switch (tipoLista) {
		case "tecnico":
			String tecBuscado = request.getParameter("nombre_tec");
			String fecha1 =  request.getParameter("fecha1");
			String fecha2 =  request.getParameter("fecha2");
			Date date1, date2;
			
			try {
				date1 = sdt.parse(fecha1);
				date2 = sdt.parse(fecha2);
			} catch (ParseException e) {
				Calendar myCalendar = new GregorianCalendar(2010, 2, 11);
				date1 = myCalendar.getTime();
				myCalendar.set(2024, 2, 11);
				date2 = myCalendar.getTime();
				e.printStackTrace();
			}
			
			System.out.println("Buscado servicios prestados por el técnico:"+tecBuscado+" del "+date1+" al "+date2);
			lst = dao.listarReportesTecnico(tecBuscado, date1 , date2);
			break;
		case "cliente":
			String cliBuscado = request.getParameter("nombre_cli");
			fecha1 =  request.getParameter("fecha1");
			fecha2 =  request.getParameter("fecha2");
			
			try {
				date1 = sdt.parse(fecha1);
				date2 = sdt.parse(fecha2);
			} catch (ParseException e) {
				Calendar myCalendar = new GregorianCalendar(2010, 2, 11);
				date1 = myCalendar.getTime();
				myCalendar.set(2024, 2, 11);
				date2 = myCalendar.getTime();
				e.printStackTrace();
			}
			
			System.out.println("Buscado servicios prestados al cliente:"+cliBuscado+" del "+date1+" al "+date2);
			lst = dao.listarReportesCliente(cliBuscado, date1, date2);
			break;	
		default:
			lst = dao.listarReportes();
			break;
		}
	 	System.out.println(lst.size());
	 	request.setAttribute("lstReportes", lst);
	}
}
