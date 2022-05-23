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
import utp.taller.dto.DtoClienteConsulta;
import utp.taller.dto.DtoEncargadoConsulta;
import utp.taller.dto.DtoTecnicoConsulta;

/**
 * Servlet implementation class ServletValidar
 */
@WebServlet("/ServletValidar")
public class ServletValidar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DaoCliente daoCliente = new DaoCliente();
	DtoClienteConsulta dtoCliente = new DtoClienteConsulta();
	
	DaoTecnico daoTecnico = new DaoTecnico();
	DtoTecnicoConsulta dtoTecnico = new DtoTecnicoConsulta();
	
	DaoEncargado daoEncargado = new DaoEncargado();
	DtoEncargadoConsulta dtoEncargado = new DtoEncargadoConsulta();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter("accion");

		if (accion.equalsIgnoreCase("Ingresar")) {
			String user = request.getParameter("txtuser");
			String pass = request.getParameter("txtpass");
			int rol = Integer.parseInt(request.getParameter("op_rol")) ;
			
			switch (rol) {
			case 1: {
					dtoCliente = daoCliente.validar(user, pass);
					if (dtoCliente.getEmail() != null) {
						System.out.println(dtoCliente.getEmail());
						request.getRequestDispatcher("Vista/servicios.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					break;
			}
			case 2: {
					dtoEncargado = daoEncargado.validar(user, pass);
					if (dtoEncargado.getEmail() != null) {
						System.out.println(dtoEncargado.getEmail());
						request.getRequestDispatcher("Vista/menu.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					break;
			}
			case 3: {
					dtoTecnico = daoTecnico.validar(user, pass);
					if (dtoTecnico.getEmail() != null) {
						System.out.println(dtoTecnico.getEmail());
						request.getRequestDispatcher("Vista/tecnico/menu.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					break;
			}
			default:
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
				

		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
