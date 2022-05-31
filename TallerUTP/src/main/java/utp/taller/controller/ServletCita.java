package utp.taller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoAtencion;
import utp.taller.dao.DaoElectrodomestico;
import utp.taller.dao.DaoHorario;
import utp.taller.dto.DtoConsultaCita;
import utp.taller.entidades.Atencion;
import utp.taller.entidades.Electrodomestico;
import utp.taller.entidades.ElectrodomesticoMarca;
import utp.taller.entidades.ElectrodomesticoTipo;

/**
 * Servlet implementation class ServletCita
 */
@WebServlet("/ServletCita")
public class ServletCita extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletCita() {
        super();
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String accion = request.getParameter("accion");
    	
  
    	switch (accion) {
    	
    	case "resumen":
    		int idHorario = Integer.parseInt(request.getParameter("idHorario"));
        	String idServicio = request.getParameter("servicio");
        	//System.out.println(idHorario + " " + idServicio + "<<<------------"); 
    		listarMarcas(request);
    		listarTipos(request);
    		DaoHorario daoHora = new DaoHorario();
    		DtoConsultaCita dtoCita = daoHora.seleccionarHora(idHorario,idServicio);
    		request.setAttribute("dtoCita", dtoCita);
    		request.getRequestDispatcher("/vista/cliente/cita.jsp").forward(request, response);
    		break;
    		
    	case "confirmar":
		
    		Electrodomestico electro = new Electrodomestico();
    		
    		electro.setNroSerie(request.getParameter("serie"));
    		electro.setModelo(request.getParameter("modelo"));
    		electro.setIdtipoElectrod(Integer.parseInt(request.getParameter("tipo")));
    		electro.setIdmarca(Integer.parseInt(request.getParameter("marca")));
    		electro.setIdpropietario(Integer.parseInt(request.getParameter("idPersona")));
    		DaoElectrodomestico daoElectro = new DaoElectrodomestico();
    		daoElectro.insertar(electro);
    		
    		if (daoElectro.maxId() != 0){
    			DaoAtencion daoAte = new DaoAtencion();
    			Atencion ate = new Atencion();
    			ate.setIdHorario(Integer.parseInt(request.getParameter("idHorario")));
    			ate.setIdElectro(daoElectro.maxId());
    			ate.setLugar("A domicilio");
    			daoAte.insertarCita(ate);
    		}
    		
    		request.getRequestDispatcher("/vista/cliente/detalleCita.jsp").forward(request, response);
    		break;
    	}
    	
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
