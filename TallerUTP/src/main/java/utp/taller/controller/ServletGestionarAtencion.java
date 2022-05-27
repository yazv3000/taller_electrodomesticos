package utp.taller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoCliente;
import utp.taller.dao.DaoElectrodomestico;
import utp.taller.dao.DaoHorario;
import utp.taller.dto.DtoClienteConsulta;
import utp.taller.dto.DtoHoraConsulta;
import utp.taller.entidades.ElectrodomesticoMarca;
import utp.taller.entidades.ElectrodomesticoTipo;

/**
 * Servlet implementation class ServletGestionarAtencion
 */
@WebServlet("/ServletGestionarAtencion")
public class ServletGestionarAtencion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DtoClienteConsulta dtoCliente = null;
	DtoHoraConsulta dtoHora = null;
	DaoCliente daoCliente = new DaoCliente();
	DaoHorario daoHorario = new DaoHorario();
	

	
    public ServletGestionarAtencion() {
        super();
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	
		String servicio = request.getParameter("servicio");
		String idPersona = request.getParameter("idPersona");
		String idHorario = request.getParameter("idHorario");
		
		
		System.out.println(" idHorario: "+idHorario + " Servicio: " + servicio + " idPersona" + idPersona + "*".repeat(20));
		request.setAttribute("servicio", servicio);
		dtoHora = daoHorario.seleccionarHora(Integer.parseInt(idHorario));
		dtoCliente = daoCliente.consultarDtoCliente(Integer.parseInt(idPersona));
		
		
		//zdtoCliente = daoCliente.consultarDtoCliente(Integer.parseInt(idPersona));
		
		
		listarMarcas(request);
		listarTipos(request);
		request.setAttribute("cliente", dtoCliente);
		request.setAttribute("hora", dtoHora);
		request.getRequestDispatcher("/vista/cliente/cita.jsp").forward(request, response);
		
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void listarMarcas(HttpServletRequest request) {
		DaoElectrodomestico daoElectro = new DaoElectrodomestico();
		List<ElectrodomesticoMarca> lst = daoElectro.listarMarcas();
		request.setAttribute("lstMarcas", lst);
	}
	
	private void listarTipos(HttpServletRequest request) {
		DaoElectrodomestico daoElectro = new DaoElectrodomestico();
		List<ElectrodomesticoTipo> lst = daoElectro.listarTiposE();
		request.setAttribute("lstTipos", lst);
	}
	
}
