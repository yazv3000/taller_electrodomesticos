package utp.taller.controller.atencion;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoAtencion;
import utp.taller.dao.DaoCliente;
import utp.taller.dao.DaoDistrito;
import utp.taller.dao.DaoElectrodomestico;
import utp.taller.dao.DaoHorario;
import utp.taller.dao.DaoServicio;
import utp.taller.dto.DtoHoraConsulta;
import utp.taller.dto.DtoNuevoAtencionTaller;
import utp.taller.dto.DtoUsuario;
import utp.taller.entidades.Atencion;
import utp.taller.entidades.Cliente;
import utp.taller.entidades.Distrito;
import utp.taller.entidades.Electrodomestico;
import utp.taller.entidades.ElectrodomesticoMarca;
import utp.taller.entidades.ElectrodomesticoTipo;
import utp.taller.entidades.Horario;
import utp.taller.entidades.Servicio;

/**
 * Servlet implementation class ServletAtencionTaller
 */
@WebServlet("/ServletAtencionTaller")
public class ServletAtencionTaller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//DAOS
	private DaoAtencion dao = new DaoAtencion();
	private DaoServicio daoServi = new DaoServicio();
	private DaoCliente daoCli = new DaoCliente();
	private DaoHorario daoHor = new DaoHorario();
	//ENTIDAES
	private Horario horario = new Horario();
	private Cliente cliente = new Cliente();
	private Electrodomestico electrodomestico = new Electrodomestico();
	private DaoElectrodomestico daoElectro = new DaoElectrodomestico();
	private Servicio servicio = new Servicio();
	private DtoNuevoAtencionTaller atencion = new DtoNuevoAtencionTaller();
	private DtoHoraConsulta dtoHorario = new DtoHoraConsulta();
    public ServletAtencionTaller() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String accion = request.getParameter("accion");
    	
    	switch (accion) {
		case "insertar":
			recuperarDatos(request);
			//INSERTAR CLIENTE
			daoCli.insertar(cliente);
			//INSERTAR ELEC
			electrodomestico.setIdpropietario(dao.idMaxCliente());
			daoElectro.insertar(electrodomestico);
			//INSERTAR ATENCION
			atencion.getElectrodomestico().setIdElectrod(dao.getidElectrodomestico());
			
			dao.insertaratencionTaller(atencion);
			break;
		default:
				int id = Integer.parseInt(request.getParameter("id"));
				horario.setIdTecnico(id);
				//INSERTA HORARIO
				daoHor.insertarHorarioTaller(horario);
				listarTipos(request);
				listarMarcas(request);
				listarDistritos(request);
				listarServicios(request);
				request.getRequestDispatcher("vista/tecnico/atencionTaller.jsp").forward(request, response);
			break;
    	}
    	request.getRequestDispatcher("vista/tecnico/atencionTaller.jsp").forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void listarDistritos(HttpServletRequest request) {
		DaoDistrito daoDistr = new DaoDistrito();
		List<Distrito> lst = daoDistr.listar();
		request.getSession().setAttribute("lstDistritos", lst);
	}
	private void listarTipos(HttpServletRequest request) {
		List<ElectrodomesticoTipo> lst = daoElectro.listarTiposE();
		request.getSession().setAttribute("lstTipos", lst);
	}
	private void listarMarcas(HttpServletRequest request) {
		List<ElectrodomesticoMarca> lst = daoElectro.listarMarcas();
		request.getSession().setAttribute("lstMarcas", lst);
	}
	private void listarServicios(HttpServletRequest request) {
		List<Servicio> lst = daoServi.listar();
		request.getSession().setAttribute("lstServicios", lst);
	}
	private void recuperarDatos(HttpServletRequest request) {
		//RECUPARANDO DATOS DEL CLIENTE
		
		cliente.setNombrePrin(request.getParameter("txt_nom1"));
		cliente.setNombreSec(request.getParameter("txt_nom2"));
		cliente.setApePrin(request.getParameter("txt_ape1"));
		cliente.setApeSec(request.getParameter("txt_ape2"));
		cliente.setTipoDocumento(Integer.parseInt(request.getParameter("cbx_tipodoc")));
		cliente.setNroDocumento(request.getParameter("num_doc"));
		cliente.setTelefono(request.getParameter("num_telef"));
		cliente.setIdDistrito(Integer.parseInt(request.getParameter("cbx_distritos")));
		cliente.setDireccion(request.getParameter("txt_direcc"));
		cliente.setEmail(request.getParameter("txt_correo"));
		cliente.setContrasena(request.getParameter("txt_pass"));
		//RECUPERANDO DATOS DEL ELECTRODOMESTICO
		electrodomestico.setNroSerie(request.getParameter("txt_numSer"));
		
		electrodomestico.setIdtipoElectrod(Integer.parseInt(request.getParameter("cbx_tipos")));
		electrodomestico.setModelo(request.getParameter("txt_modelo"));
		electrodomestico.setIdmarca(Integer.parseInt(request.getParameter("cbx_marcas")));
		electrodomestico.setIdpropietario(0);
		//RECUPERANDO FALLAS Y SERVICIO
		servicio.setIdServicio(Integer.parseInt(request.getParameter("cbx_tipos_Serv")));
		atencion.setServicio(servicio);
		atencion.setElectrodomestico(electrodomestico);
		atencion.setTipoAtencion("En el taller");
		atencion.setDiagnostico(request.getParameter("txt_falla"));
		
	}
}
