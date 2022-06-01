package utp.taller.controller.atencion;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoAtencion;
import utp.taller.dao.DaoElectrodomestico;
import utp.taller.dao.DaoHorario;
import utp.taller.dao.DaoServicio;
import utp.taller.dto.DtoHoraConsulta;
import utp.taller.dto.DtoNuevaCita;
import utp.taller.dto.DtoUsuario;
import utp.taller.entidades.Electrodomestico;
import utp.taller.entidades.ElectrodomesticoMarca;
import utp.taller.entidades.ElectrodomesticoTipo;
import utp.taller.entidades.Servicio;

/**
 * Servlet implementation class ServletNuevaCita
 */
@WebServlet("/ServletNuevaCita")
public class ServletNuevaCita extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private DtoNuevaCita dtoCita = new DtoNuevaCita();
	
    public ServletNuevaCita() {
        super();   
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String accion = request.getParameter("accion");
    	
    	switch (accion) {
    	
    	case "resumen":
    		DaoHorario daoHora = new DaoHorario();
    		DaoServicio daoServ = new DaoServicio();
    		int idHor = Integer.parseInt(request.getParameter("horario"));
    		int idServ = Integer.parseInt((String) request.getSession().getAttribute("id_servicio"));
    		
    		DtoHoraConsulta dtoHora =  daoHora.consultarDtoHora(idHor);
    		Servicio  servicio = daoServ.consultarId(idServ);
    		
    		System.out.println(servicio.getNomServicio());
    		
    		dtoCita.setServicio(servicio);
    		dtoCita.setDtoHora(dtoHora);
    		dtoCita.setLugar("A domicilio");
    		dtoCita.setFechaReserva(new Date());
    		
    		listarMarcas(request);
    		listarTipos(request);
    		request.setAttribute("dtoCita", dtoCita);
    		

    		request.getRequestDispatcher("/vista/cliente/reservaCita.jsp").forward(request, response);
    		break;
    		
    	case "confirmar":
		
    		Electrodomestico electro = new Electrodomestico();
    		DtoUsuario propietario = (DtoUsuario) request.getSession().getAttribute("dtoUsuario");
    		
    		electro.setNroSerie(request.getParameter("serie"));
    		electro.setModelo(request.getParameter("modelo"));
    		electro.setIdtipoElectrod(Integer.parseInt(request.getParameter("tipo")));
    		electro.setIdmarca(Integer.parseInt(request.getParameter("marca")));
    		electro.setIdpropietario(propietario.getIdPersona());
    		electro.setEstadoActivo(true);
    		dtoCita.setElectrodomestico(electro);
    		dtoCita.setFallaElectrodomestico(request.getParameter("txt_falla"));
    		
    		// Agregar el electrodoméstico a la bd
    		DaoElectrodomestico daoElectro = new DaoElectrodomestico();
    		daoElectro.insertar(electro);
    		
    		int idElectro = daoElectro.maxId(propietario.getIdPersona());
    		
    		if (idElectro != 0){
    			DaoAtencion daoAte = new DaoAtencion();
    			dtoCita.getElectrodomestico().setIdElectrod(idElectro);
    			daoAte.insertarCita(dtoCita);
    		}
    		
    		//request.getRequestDispatcher("/ServletServicios").forward(request, response);
    		request.getRequestDispatcher("/vista/cliente/servicios.jsp").forward(request, response);
    		break;
    	}
    	
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
