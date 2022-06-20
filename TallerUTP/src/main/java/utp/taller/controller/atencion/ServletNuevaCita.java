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
import utp.taller.dto.DtoAtencion;
import utp.taller.dto.DtoElectrodomesticoConsulta;
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
    private DaoAtencion daoAte = new DaoAtencion();
    private DaoElectrodomestico daoElect = new DaoElectrodomestico();
    private Electrodomestico electro = new Electrodomestico();
    
    public ServletNuevaCita() {
        super();   
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String accion = request.getParameter("accion");
    	String generarPDF = request.getParameter("generarPDF");
    	
    	switch (accion) {
    	
    	case "cita_domicilio":
    		dtoCita.setLugar("A domicilio");
    		dtoCita.setFechaReserva(new Date());
    		
    		resumen(request);
    		
    		listarMarcas(request);
    		listarTipos(request);
    		listarElectrodomesticos(request);
    		
    		request.setAttribute("dtoCita", dtoCita);
    		request.getRequestDispatcher("/vista/cliente/reservaCita.jsp").forward(request, response);
    		break;
    		
    	case "confirmar":

    		int idElectro = registrarElectrodomestico(request);
    		
    		if (idElectro != 0){
    			DaoAtencion daoAte = new DaoAtencion();
    			dtoCita.getElectrodomestico().setIdElectrod(idElectro);
    			
    			// Guardar la cita
    			daoAte.insertarCita(dtoCita);
    			
    			int idMaximo = daoAte.idMaxAtencion();
    			DtoAtencion dtoAte = daoAte.obtenerAtencion(idMaximo);
    			request.setAttribute("generarPDF", generarPDF);
    			request.getSession().setAttribute("dtoAtencion", dtoAte);
    			request.getSession().setAttribute("dtoCita", dtoCita);
    			request.getRequestDispatcher("/ServletGenerarPDF").forward(request, response);
    		}
//    		else {
//    			System.out.println("No se pudo registrar el electrodoméstico");
//    			request.getRequestDispatcher("/vista/cliente/reservaCita.jsp").forward(request, response);
//    		}
    		break;
    	case "obtenerDatos":
    		int idElectrodomestico = Integer.parseInt(request.getParameter("id"));
    		electro = daoElect.consultarId(idElectrodomestico);
    		request.setAttribute("el", electro);
    		break;
    	}
    	
    	
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void resumen(HttpServletRequest request) {
		// Resumen horario (incluye técnico) y servicio seleccionados
		DaoHorario daoHora = new DaoHorario();
		DaoServicio daoServ = new DaoServicio();
		
		int idHor = Integer.parseInt(request.getParameter("horario"));
		int idServ = Integer.parseInt((String) request.getSession().getAttribute("id_servicio"));
		
		DtoHoraConsulta dtoHora =  daoHora.consultarDtoHora(idHor);
		dtoCita.setDtoHora(dtoHora);
		
		
		Servicio  servicio = daoServ.consultarId(idServ);
		dtoCita.setServicio(servicio);
		
		
		System.out.println("La fecha seleccionada es:  "+dtoHora.getFormatoFecha()+", "+dtoHora.getHora());
		System.out.println("El servicio es:  "+servicio.getNomServicio());
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
	private void listarElectrodomesticos(HttpServletRequest request) {
		DtoUsuario dtoUsuario = (DtoUsuario) request.getSession().getAttribute("dtoUsuario");
		DaoElectrodomestico daoElectro = new DaoElectrodomestico();
		List<DtoElectrodomesticoConsulta> lst = daoElectro.listarDtoElectrodomesticosporCliente(dtoUsuario.getIdPersona());
		request.getSession().setAttribute("lstElectro", lst);
	}
	private int registrarElectrodomestico(HttpServletRequest request) {
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
		
		// Recuperar el id con que fue insertado
		electro.setIdElectrod(daoElectro.maxId(propietario.getIdPersona()));
		
		return electro.getIdElectrod();
	}
	
}
