package utp.taller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoCliente;
import utp.taller.dao.DaoDistrito;
import utp.taller.dto.DtoClienteConsulta;
import utp.taller.entidades.Cliente;
import utp.taller.entidades.Distrito;


/**
 * Servlet implementation class ServletGestionarTecnico
 */
@WebServlet("/ServletGestionarCliente")
public class ServletGestionarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DaoCliente dao = new DaoCliente();
	private Cliente cliente = new Cliente();
	private byte[] foto;
	
    public ServletGestionarCliente() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String accion = request.getParameter("accion");
    	
    	switch (accion) {
			case "listar": 
				 	List<DtoClienteConsulta> lst = dao.listarDtoClientes();
				 	request.setAttribute("lstConsultaClientes", lst);
				break;
			
			case "editar":
			    int id= Integer.parseInt(request.getParameter("id"));
				cliente = dao.consultarId(id);
				request.setAttribute("cli", cliente);
				// request.getRequestDispatcher("ServletGestionarCliente?accion=listar").include(request, response);
				
				break;
			
			case "actualizar":
				
				System.out.println(cliente);
				System.out.println("-".repeat(100));
				System.out.println(request.getParameter("txt_nom1"));
				//foto = 
				System.out.println(request.getParameter("cbx_tipodoc"));
//				System.out.println(Integer.parseInt(request.getParameter("cbx_tipodoc")));
//				System.out.println(Integer.parseInt(request.getParameter("cbx_distritos")));
				System.out.println("-".repeat(100));
				
				cliente.setNombrePrin(request.getParameter("txt_nom1"));
				cliente.setNombreSec(request.getParameter("txt_nom2"));
				cliente.setApePrin(request.getParameter("txt_ape1"));
				cliente.setApeSec(request.getParameter("txt_ape2"));
//				cliente.setTipoDocumento(Integer.parseInt(request.getParameter("cbx_tipodoc")));
				cliente.setNroDocumento(request.getParameter("num_doc"));
				cliente.setTelefono(request.getParameter("num_telef"));
//				cliente.setIdDistrito(Integer.parseInt(request.getParameter("cbx_distritos")));
				cliente.setDireccion(request.getParameter("txt_direcc"));
				cliente.setEmail(request.getParameter("txt_correo"));
//				cliente.setEstadoActivo(Boolean.parseBoolean(request.getParameter("estado")));
				
				System.out.println(cliente);
				
				dao.modificar(cliente);
				
				request.getRequestDispatcher("ServletGestionarCliente?accion=listar").include(request, response);
				
				break;

			default:
				request.getRequestDispatcher("ServletGestionarCliente?accion=listar").forward(request, response);
		}
    	
    	listarDistritos(request);
    	request.getRequestDispatcher("vista/encargado/gestionClientes.jsp").forward(request, response);
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
		request.getSession().getServletContext().setAttribute("lstDistritos", lst);
	}

	
	
	
}
