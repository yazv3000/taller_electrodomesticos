package utp.taller.controller.mantenimiento;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.READER;
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
import utp.taller.dao.DaoAtencion;
import utp.taller.dto.DtoAtencion;
import utp.taller.dto.DtoClienteConsulta;
import utp.taller.dto.DtoNuevaCita;
import utp.taller.dto.DtoPresupuesto;
import utp.taller.dto.DtoReporteConsulta;
import utp.taller.dto.DtoTecnicoConsulta;
import utp.taller.dto.DtoUsuario;
import utp.tools.EnvioCorreo;

/**
 * Servlet implementation class ServletGenerarPDF
 */
@WebServlet("/ServletGenerarPDF")
public class ServletGenerarPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EnvioCorreo correo = new EnvioCorreo();
	public ServletGenerarPDF() {
		super();

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String generarPDF = request.getParameter("generarPDF");

		switch (generarPDF) {
			case "reporteTecnico":
				this.reporteTecnico(request, response);
				request.getRequestDispatcher("vista/encargado/reportes.jsp").forward(request, response);
				break;
			case "reporteCliente":
				this.reporteCliente(request, response);
				request.getRequestDispatcher("vista/encargado/reportes.jsp").forward(request, response);
				break;
			case "citaTecnica":
				this.reporteCitaTecnica(request,response);
//				request.getRequestDispatcher("/ServletCitasCliente").forward(request, response);
				break;
			case "hojaServicio":
				this.reporteHojaServicio(request,response);
				break;
		}
	}

	

	private void reporteTecnico(HttpServletRequest request, HttpServletResponse response) {
		
		String filtros[] = (String[]) request.getSession().getAttribute("filtros");
		String fechaInicial = filtros[0];
		String fechaFinal = filtros[1];

		List<DtoReporteConsulta> lstReporteTecnico = (List<DtoReporteConsulta>)request.getSession().getAttribute("lstReportes");
		lstReporteTecnico.add(0, new DtoReporteConsulta());
		DtoTecnicoConsulta dtoTec = (DtoTecnicoConsulta) request.getSession().getAttribute("tecnicoReporte");
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(lstReporteTecnico.toArray());
		
		try {
			ServletOutputStream out = response.getOutputStream();
			InputStream reporte = this.getServletConfig()
                            .getServletContext()
                            .getResourceAsStream("reportesJasper/ReporteTecnico.jasper"); // ruta y nombre del archivo Jasper
			 JasperReport report = (JasperReport) JRLoader.loadObject(reporte);
			 Map<String, Object> parameters = new HashMap();
             parameters.put("ds", ds);
             parameters.put("nombresCompletos", dtoTec.getNombreCompleto());
             parameters.put("telefono", dtoTec.getTelefono());
             parameters.put("especialidad", dtoTec.getEspecialidad());
             parameters.put("direccion", dtoTec.getDireccion());
             parameters.put("email", dtoTec.getEmail());
             parameters.put("estado", dtoTec.getEstado());
             parameters.put("fechaInicial", fechaInicial);
             parameters.put("fechaFinal", fechaFinal);
             response.setContentType("application/pdf");
             response.addHeader("Content-disposition", "inline; filename=ReporteTecnico.pdf"); // Nombre con el que se descarga el archivo pdf         
             JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, ds);
             JasperExportManager.exportReportToPdfStream(jasperPrint, out);
             out.flush();
             out.close();
             
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	}

	private void reporteCliente(HttpServletRequest request, HttpServletResponse response) {
		
		String filtros[] = (String[]) request.getSession().getAttribute("filtros");
		String fechaInicial = filtros[0];
		String fechaFinal = filtros[1];
		String montoInicial = filtros[2];
		String montoFinal = filtros[3];

		List<DtoReporteConsulta> lstReporteCliente = (List<DtoReporteConsulta>)request.getSession().getAttribute("lstReportes");// ("lstRerpoteConsulta");
		lstReporteCliente.add(0, new DtoReporteConsulta());
		DtoClienteConsulta dtoClie = (DtoClienteConsulta) request.getSession().getAttribute("clienteReporte");//("dtoClie");
		
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(lstReporteCliente.toArray());
		
		try {
			ServletOutputStream out = response.getOutputStream();
			InputStream reporte = this.getServletConfig()
                            .getServletContext()
                            .getResourceAsStream("reportesJasper/ReporteCliente.jasper"); // ruta y nombre del archivo Jasper
			 JasperReport report = (JasperReport) JRLoader.loadObject(reporte);
			 Map<String, Object> parameters = new HashMap();
             parameters.put("ds", ds);
             parameters.put("nombresCompletos", dtoClie.getNombreCompleto());
             parameters.put("telefono", dtoClie.getTelefono());
             parameters.put("direccion", dtoClie.getDireccion());
             parameters.put("email", dtoClie.getEmail());
             parameters.put("estado", dtoClie.getEstado());
             parameters.put("fechaInicial", fechaInicial);
             parameters.put("fechaFinal", fechaFinal);
             parameters.put("montoInicial", "S/."+montoInicial);
             parameters.put("montoFinal", "S/."+montoFinal);
             response.setContentType("application/pdf");
             response.addHeader("Content-disposition", "inline; filename=ReporteCliente.pdf"); // Nombre con el que se descarga el archivo pdf
             JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, ds);
             JasperExportManager.exportReportToPdfStream(jasperPrint, out);

             out.flush();
             out.close();
             
             
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	}

	private void reporteHojaServicio(HttpServletRequest request, HttpServletResponse response) {
		
		DtoAtencion dtoAte = (DtoAtencion) request.getSession().getAttribute("dtoAtencion");
		System.out.println(dtoAte);
		DtoUsuario dtoTecnico = (DtoUsuario) request.getSession().getAttribute("dtoUsuario");
		double montoTotal = (double) request.getSession().getAttribute("montoTotal");
		List<DtoPresupuesto> lstPresupuesto = (List<DtoPresupuesto>) request.getSession().getAttribute("lstPresupuesto");
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(lstPresupuesto.toArray());
		try {
			ServletOutputStream out = response.getOutputStream();
			InputStream reporte = this.getServletConfig()
                            .getServletContext()
                            .getResourceAsStream("reportesJasper/HojaServicio.jasper"); // ruta y nombre del archivo Jasper
			System.out.println(reporte);
			 JasperReport report = (JasperReport) JRLoader.loadObject(reporte);
			 System.out.println("ENTRE AL DRIVER");
			 Map<String, Object> parameters = new HashMap();
			 parameters.put("ds", ds);
             parameters.put("nombresTecnico", dtoTecnico.getUsername());
             parameters.put("nombresCli",dtoAte.getCliente().getNombreCompleto());
             parameters.put("telefonoCli",dtoAte.getCliente().getTelefono());
             parameters.put("direccionCli",dtoAte.getCliente().getDireccion());
             parameters.put("tipo",dtoAte.getElectrodomesticoTipo().getNombre());
             parameters.put("numeroSerie",dtoAte.getElectrodomestico().getNroSerie());
             parameters.put("marca", dtoAte.getElectrodomesticoMarca().getNombre());
             parameters.put("modelo",dtoAte.getElectrodomestico().getModelo());
             parameters.put("falla", dtoAte.getFallaDescrita());
             parameters.put("fechaReserva", dtoAte.getFechaReservaCita().toString());
             parameters.put("fechaCita", dtoAte.getFechaCita().toString());
             parameters.put("hora", dtoAte.getHoraCita());
             parameters.put("servicio",dtoAte.getServicio().getNomServicio());
             parameters.put("precioTotal", "S/."+montoTotal);
             response.setContentType("application/pdf");
             response.addHeader("Content-disposition", "inline; filename=hojaServicio2.pdf"); // Nombre con el que se descarga el archivo pdf
             JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, ds);
             JasperExportManager.exportReportToPdfStream(jasperPrint, out);
             JasperExportManager.exportReportToPdfFile( jasperPrint, "reporte.pdf"); // guardar el pdf (hoja de servicio)
             out.flush();
             out.close();
		} catch (Exception e) {	
			throw new RuntimeException(e);
		}
		correo.enviarCorreo(dtoAte.getCliente().getEmail());
	}
	
	private void reporteCitaTecnica(HttpServletRequest request, HttpServletResponse response) {
		DtoAtencion dtoAte = (DtoAtencion) request.getSession().getAttribute("dtoAtencion");
		DtoNuevaCita dtoCita = (DtoNuevaCita) request.getSession().getAttribute("dtoCita");
		DtoUsuario dtoCliente = (DtoUsuario) request.getSession().getAttribute("dtoUsuario");
		Integer [] numeros = {1};
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(numeros);
		try {
			ServletOutputStream out = response.getOutputStream();
			InputStream reporte = this.getServletConfig()
                            .getServletContext()
                            .getResourceAsStream("reportesJasper/CitaTecnica.jasper"); // ruta y nombre del archivo Jasper
			 JasperReport report = (JasperReport) JRLoader.loadObject(reporte);
			 System.out.println("ENTRE AL DRIVER");
			 Map<String, Object> parameters = new HashMap();
             parameters.put("nombresTecnico", dtoCita.getDtoHora().getNombreTecnico());
             parameters.put("telefonoTec", dtoCita.getDtoHora().getTelefonoTecnico());
             parameters.put("especialidad",dtoCita.getDtoHora().getEspecialidad());
             parameters.put("nombresCli",dtoAte.getCliente().getNombreCompleto());
             parameters.put("telefonoCli",dtoAte.getCliente().getTelefono());
             parameters.put("direccionCli",dtoAte.getCliente().getDireccion());
             parameters.put("tipo",dtoAte.getElectrodomesticoTipo().getNombre());
             parameters.put("numeroSerie",dtoAte.getElectrodomestico().getNroSerie());
             parameters.put("marca", dtoAte.getElectrodomesticoMarca().getNombre());
             parameters.put("modelo",dtoAte.getElectrodomestico().getModelo());
             parameters.put("falla", dtoAte.getFallaDescrita());
             parameters.put("fechaReserva", dtoAte.getFechaReservaCita().toString());
             parameters.put("fechaCita", dtoAte.getFechaCita().toString());
             parameters.put("hora", dtoAte.getHoraCita());
             parameters.put("servicio",dtoAte.getServicio().getNomServicio());
             
             response.setContentType("application/pdf");
             response.addHeader("Content-disposition", "inline; filename=ReporteCitaTecnica.pdf"); // Nombre con el que se descarga el archivo pdf
             JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, ds);
             JasperExportManager.exportReportToPdfStream(jasperPrint, out);
             JasperExportManager.exportReportToPdfFile( jasperPrint, "reporte.pdf"); // guardar el pdf (hoja de servicio)
             out.flush();
             out.close();
             
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		correo.enviarCorreo(dtoCliente.getEmail());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
}
