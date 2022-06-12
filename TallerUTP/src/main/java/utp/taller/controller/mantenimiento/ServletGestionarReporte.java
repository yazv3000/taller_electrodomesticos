package utp.taller.controller.mantenimiento;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import utp.taller.dto.DtoReporteConsulta;
import utp.taller.dto.DtoReporteTecnico;
import utp.taller.dto.DtoTecnicoConsulta;

/**
 * Servlet implementation class ServletGestionarReporte
 */
@WebServlet("/ServletGestionarReporte")
public class ServletGestionarReporte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public ServletGestionarReporte() {
		super();

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");

		switch (accion) {
			case "reporteTecnico":
				this.reporteTecnico(request, response);
				break;
			case "reporteCliente":
				this.reporteCliente(request, response);
				break;
		}
		request.getRequestDispatcher("reporte.jsp").forward(request, response);;
	}

	private void reporteTecnico(HttpServletRequest request, HttpServletResponse response) {
		List<DtoReporteConsulta> reporteTecnico = new ArrayList<DtoReporteConsulta>();
		
		
		
		DtoReporteConsulta dto = new DtoReporteConsulta();
		dto.setIdAtencion(1);
		dto.setFecha(new Date());

		dto.setNombreCliente("Juan Peres");
		dto.setElectrodomestico("Refrigeradora");
		dto.setMarca("Samnsung");
		dto.setServicio("Mantenimiento");
		dto.setMonto(150.33);
		reporteTecnico.add(dto);
		
		DtoReporteConsulta dto1 = new DtoReporteConsulta();
		dto1.setIdAtencion(2);
		dto1.setFecha(new Date());

		dto1.setNombreCliente("Juan Peres");
		dto1.setElectrodomestico("Lavadora");
		dto1.setMarca("Samnsung");
		dto1.setServicio("Mantenimiento");
		dto1.setMonto(150.33);
		reporteTecnico.add(dto1);
		
		DtoReporteConsulta dto2 = new DtoReporteConsulta();
		dto2.setIdAtencion(3);
		dto2.setFecha(new Date());

		dto2.setNombreCliente("Juan Peres");
		dto2.setElectrodomestico("Licuadora");
		dto2.setMarca("Samnsung");
		dto2.setServicio("Mantenimiento");
		dto2.setMonto(150.33);
		reporteTecnico.add(dto2);
		
		DtoTecnicoConsulta dtoTec = new DtoTecnicoConsulta();
		dtoTec.setNombreCompleto("Gil Mendez");
		dtoTec.setTelefono("999999999");
		dtoTec.setEspecialidad("Electronico");
		dtoTec.setDireccion("Av. Peru Cerro Colorado");
		dtoTec.setEmail("gil.mendez@gmail.com");
		dtoTec.setEstado("Activo");
		
		
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(reporteTecnico.toArray());
		System.out.println("FUNCIONO CHOCHE");
		String jasper = "reportesJasper/ReporteTecnico.jasper";
		String fileName = "ReporteTecnico.pdf";
		
		exportarReporte(ds,dtoTec,jasper,fileName,response);
	}

	private void reporteCliente(HttpServletRequest request, HttpServletResponse response) {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void exportarReporte( JRBeanArrayDataSource ds, DtoTecnicoConsulta dtoTec, String jasper, String pdf, HttpServletResponse response) {
		
		try {
			ServletOutputStream out = response.getOutputStream();
			InputStream reporte = this.getServletConfig()
                            .getServletContext()
                            .getResourceAsStream(jasper);
			 JasperReport report = (JasperReport) JRLoader.loadObject(reporte);
			 Map<String, Object> parameters = new HashMap();
             parameters.put("ds", ds);
             parameters.put("nombresCompletos", dtoTec.getNombreCompleto());
//             parameters.put("telefono", dtoTec.getTelefono());
//             parameters.put("especialidad", dtoTec.getEspecialidad());
//             parameters.put("direccion", dtoTec.getDireccion());
//             parameters.put("email", dtoTec.getEmail());
//             parameters.put("estado", dtoTec.getEstado());
//             
             response.setContentType("application/pdf");
             response.addHeader("Content-disposition", "inline; filename="+pdf); // nombre del pdf diferente 3
             JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, ds);
             JasperExportManager.exportReportToPdfStream(jasperPrint, out);
             out.flush();
             out.close();
             
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		System.out.println("ME PASE DEL METODO CHOCHE");

	}

}
