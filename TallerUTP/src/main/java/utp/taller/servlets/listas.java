package utp.taller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//IMPORTANDO ENTIDADES Y DAOS
import utp.taller.entidades.*;
import utp.taller.dao.*;
/**
 * Servlet implementation class listas
 */
@WebServlet("/listas")
public class listas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public listas() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoCliente daocli = new DaoCliente();
		List<Cliente> listaClientes = daocli.listar();
		request.setAttribute("listaClientes", listaClientes);
		request.getRequestDispatcher("./Vista/Cliente.jsp").forward(request, response);
	}

}
