package utp.taller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    
	private Cliente cliente = new Cliente();
	private DaoCliente dao = new DaoCliente();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter("accion");

		if (accion.equalsIgnoreCase("Ingresar")) {
			String user = request.getParameter("txt_user");
			String pass = request.getParameter("txt_pass");
			int rol = Integer.parseInt(request.getParameter("cbx_rol")) ;
			
			DtoUsuario dto = new DtoUsuario();
			
			switch (rol) {
			case 1: {
					DaoCliente daoCliente = new DaoCliente();
					dto = daoCliente.validar(user, pass);
					if (dto.getEmail() != null) {
						request.getSession().setAttribute("dtoUsuario", dto);
						request.getRequestDispatcher("vista/cliente/servicios.jsp").forward(request, response);
						
					} else {
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					break;
			}
			case 2: {
					DaoEncargado daoEncargado = new DaoEncargado();
					dto = daoEncargado.validar(user, pass);
					
					if (dto.getEmail() != null) {
						request.getSession().setAttribute("dtoUsuario", dto);
						request.getRequestDispatcher("vista/encargado/menuEncargado.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					break;
			}
			case 3: {
					DaoTecnico  daoTecnico = new DaoTecnico();
					dto = daoTecnico.validar(user, pass);
					
					if (dto.getEmail() != null) {
						request.getSession().setAttribute("dtoUsuario", dto);
						request.getRequestDispatcher("vista/tecnico/menuTecnico.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					break;
			}
			default:
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}	else if(accion.equalsIgnoreCase("registrar")) {
			recuperarDatos(request);
			dao.insertar(cliente);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} 
		else {
			request.getRequestDispatcher("index.html").forward(request, response);
		}
		
	}
	
	private void recuperarDatos(HttpServletRequest request) {
		//foto = 
		
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
		cliente.setEstadoActivo(Boolean.parseBoolean(request.getParameter("estado")));
	}
	

}
