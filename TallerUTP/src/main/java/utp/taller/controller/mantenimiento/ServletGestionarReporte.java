package utp.taller.controller.mantenimiento;

import java.io.IOException;
import java.io.InputStream;
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
import utp.taller.dto.DtoReporteTecnico;

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

	}

	private void reporteTecnico(HttpServletRequest request, HttpServletResponse response) {
		List<DtoReporteTecnico> reporteTecnico = new ArrayList<DtoReporteTecnico>();
		
		DtoReporteTecnico dto = new DtoReporteTecnico();
		dto.setId(1);
		dto.setNomTecnico("Juan Alvarado");
		dto.setElectrodomestico("Refrigeradora");
		dto.setServicio("Reparacion");
		dto.setMonto(120.30);
		reporteTecnico.add(dto);
		
		DtoReporteTecnico dto1 = new DtoReporteTecnico();
		dto1.setId(2);
		dto1.setNomTecnico("Juan Alvarado");
		dto1.setElectrodomestico("Cocina");
		dto1.setServicio("Reparacion");
		dto1.setMonto(200.30);
		reporteTecnico.add(dto1);
		
		DtoReporteTecnico dto2 = new DtoReporteTecnico();
		dto2.setId(3);
		dto2.setNomTecnico("Juan Alvarado");
		dto2.setElectrodomestico("Licuadora");
		dto2.setServicio("Mantenimiento");
		dto2.setMonto(130.30);
		reporteTecnico.add(dto2);
		
		Integer [] numeros = {1,2,3,4,5};
		
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(numeros); 
//		String jasper = "reportesJasper/ReporteTecnico.jasper";
//		String fileName = "ReporteTecnico.pdf";
//		
//		exportarReporte(ds,dto,jasper,fileName,response);
	}

	private void reporteCliente(HttpServletRequest request, HttpServletResponse response) {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
//	private void exportarReporte( JRBeanArrayDataSource ds, DtoReporteTecnico dtoTec, String jasper, String pdf, HttpServletResponse response) {
//		try {
//			ServletOutputStream out = response.getOutputStream();
//			InputStream reporte = this.getServletConfig()
//                            .getServletContext()
//                            .getResourceAsStream(jasper);
//			 JasperReport report = (JasperReport) JRLoader.loadObject(reporte);
//			 Map<String, Object> parameters = new HashMap();
//             parameters.put("ds", ds);
//             //parameters.put("tecnico", dtoTec.getNomTecnico());
//             //parameters.put("logoEmpresa", logoEmpresa);
//             //parameters.put("imagenAlternativa", logoFooter);
//             response.setContentType("application/pdf");
//             response.addHeader("Content-disposition", "inline; filename="+pdf); // nombre del pdf diferente 3
//             JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, ds);
//             JasperExportManager.exportReportToPdfStream(jasperPrint, out);
//             out.flush();
//             out.close();
//             
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//
//	}

}
