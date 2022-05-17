package utp.taller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoCliente;
import utp.taller.dto.DtoUsuario;

/**
 * Servlet implementation class ServletValidar
 */
@WebServlet("/ServletValidar")
public class ServletValidar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DaoCliente daoCli = new DaoCliente();
	DtoUsuario dtoCli = new DtoUsuario();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter("accion");

		if (accion.equalsIgnoreCase("Ingresar")) {
			String user = request.getParameter("txtuser");
			String pass = request.getParameter("txtpass");
			dtoCli = daoCli.validar(user, pass);

			if (dtoCli.getCorreo() != null) {
				request.getRequestDispatcher("Vista/menu.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("index.html").forward(request, response);
			}

		} else {
			request.getRequestDispatcher("index.html").forward(request, response);
		}
	}

}
