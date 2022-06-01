package utp.taller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utp.taller.dao.DaoCliente;
import utp.taller.dao.DaoEncargado;
import utp.taller.dao.DaoTecnico;
import utp.taller.dto.DtoUsuario;
import utp.taller.entidades.Cliente;

/**
 * Servlet implementation class ServletIniciarSesion
 */
@WebServlet("/ServletIniciarSesion")

public class ServletIniciarSesion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	HttpSession session;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession();
		String accion = request.getParameter("accion");
		
		if (accion.equalsIgnoreCase("ingresar")) {
			iniciarSesion(request, response);
		}
		else if(accion.equalsIgnoreCase("registrar")) {
			registrarCliente(request, response);
		} 
		else {
			request.getRequestDispatcher("index.html").forward(request, response);
		}
		
	}
	
	// REGISTRAR NUEVO CLIENTE
	private void registrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente  = recuperarCliente(request);
		DaoCliente dao = new DaoCliente();
		dao.insertar(cliente);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	// INICIAR SESIÓN
	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recuperar valores del formulario
		String user = request.getParameter("txt_user");
		String pass = request.getParameter("txt_pass");
		int rol = Integer.parseInt(request.getParameter("cbx_rol")) ;
		
		DtoUsuario dto = new DtoUsuario();
		
		// Validar usuario y enviar al respectivo menú según el rol
		switch (rol) {
		
			// USUARIO DE TIPO CLIENTE	
			case 1: 	
					DaoCliente daoCliente = new DaoCliente();
					dto = daoCliente.validar(user, pass);
					if (dto.getEmail() != null) {
						session.setAttribute("dtoUsuario", dto);
						request.getRequestDispatcher("vista/cliente/menuCliente.jsp").forward(request, response);
					} else {
						System.out.println("Cliente no registrado");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
			break;
			
			// USUARIO DE TIPO ENCARGADO
			case 2: 	
					DaoEncargado daoEncargado = new DaoEncargado();
					dto = daoEncargado.validar(user, pass);
					if (dto.getEmail() != null) {
						session.setAttribute("dtoUsuario", dto);
						request.getRequestDispatcher("vista/encargado/menuEncargado.jsp").forward(request, response);
					} else {
						System.out.println("Encargado no registrado");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
			break;

			// USUARIO DE TIPO TÉCNICO
			case 3: 	
					DaoTecnico  daoTecnico = new DaoTecnico();
					dto = daoTecnico.validar(user, pass);
					
					if (dto.getEmail() != null) {
						session.setAttribute("dtoUsuario", dto);
						request.getRequestDispatcher("vista/tecnico/menuTecnico.jsp").forward(request, response);
					} else {
						System.out.println("Técnico no registrado");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
			break;
			
			default:
				request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		}
	}
	
	private Cliente recuperarCliente(HttpServletRequest request) {
		Cliente cliente = new Cliente();
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
		return cliente;
	}

}
