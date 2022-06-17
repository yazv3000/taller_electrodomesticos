package utp.taller.controller.mantenimiento;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoAtencion;
import utp.taller.dao.DaoCliente;
import utp.taller.dao.DaoTecnico;
import utp.taller.dto.DtoClienteConsulta;
import utp.taller.dto.DtoReporteConsulta;
import utp.taller.dto.DtoTecnicoConsulta;

/**
 * Servlet implementation class ServletReportes
 */
@WebServlet("/ServletReportes")
public class ServletReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoAtencion dao = new DaoAtencion();
	private DaoTecnico daoTec = new DaoTecnico();
	private DaoCliente daoCli = new DaoCliente();
	private static String tipoLista;
	SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
	
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
    				request.getSession().setAttribute("por_persona", persona);
					request.getSession().setAttribute("lstReportes", new ArrayList<DtoReporteConsulta>());
    			}else if(persona.equals("cliente")) {
    				request.getSession().setAttribute("por_persona", persona);
					request.getSession().setAttribute("lstReportes", new ArrayList<DtoReporteConsulta>());
    			}else {
    				request.getSession().removeAttribute("por_persona");;
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

		List<DtoReporteConsulta> lst = new ArrayList<DtoReporteConsulta>();

		
	 	switch (tipoLista) {
		case "tecnico":
			String tecBuscado = request.getParameter("nombre_tec");
			String fecha1 =  request.getParameter("fecha1");
			String fecha2 =  request.getParameter("fecha2");
			Date date1, date2;
			
			try {
				date1 = sdt.parse(fecha1);
				date2 = sdt.parse(fecha2);
				DtoTecnicoConsulta tecnicoReporte = daoTec.consultarDtoNombres(tecBuscado);
				request.getSession().setAttribute("tecnicoReporte", tecnicoReporte);
				request.getSession().setAttribute("filtros", new String[]{fecha1, fecha2});
				System.out.println("Buscado servicios prestados por el técnico:"+tecnicoReporte.getNombreCompleto()+" del "+date1+" al "+date2);
				
				lst = dao.listarReportesTecnico(tecnicoReporte.getIdPersonaTecnico(), date1 , date2);

				if(lst.size()>0) {
					request.setAttribute("estado_reporte", "listo");
					System.out.println("entra");
				} else {
					request.setAttribute("estado_reporte", "noListo");
				}
				
				
			} catch (ParseException| NumberFormatException e) {
				e.printStackTrace();
			}
			break;
			
			
		case "cliente":
			String cliBuscado = request.getParameter("nombre_cli");
			fecha1 =  request.getParameter("fecha1");
			fecha2 =  request.getParameter("fecha2");
			String mt1 = request.getParameter("monto1");
			String mt2 = request.getParameter("monto2");

			try {
				date1 = sdt.parse(fecha1);
				date2 = sdt.parse(fecha2);
				double monto1 = Double.parseDouble(mt1);
				double monto2 = Double.parseDouble(mt2);
				DtoClienteConsulta clienteReporte = daoCli.consultarDtoNombres(cliBuscado);
				request.getSession().setAttribute("clienteReporte", clienteReporte);
				request.getSession().setAttribute("filtros", new String[]{fecha1, fecha2, mt1, mt2});
				System.out.println("Buscado servicios prestados al cliente:"+clienteReporte.getNombreCompleto()+" del "+date1+" al "+date2+" entre "+monto1+" y "+monto2);
				
				lst = dao.listarReportesCliente(clienteReporte.getIdPersonaCliente(), date1, date2, monto1, monto2);
				
				if(lst.size()>0) {
					request.setAttribute("estado_reporte", "listo");
					System.out.println("entra");
				} else {
					request.setAttribute("estado_reporte", "noListo");
				}
				
			} catch (ParseException| NumberFormatException e) {
				e.printStackTrace();
			}

			break;	
		default:
			lst = dao.listarReportes();
			break;
		}

	 	request.getSession().setAttribute("lstReportes", lst);
	}
}
