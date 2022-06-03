package utp.taller.controller.atencion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoActividad;
import utp.taller.entidades.Actividad;

/**
 * Servlet implementation class ServletPresupuesto
 */
@WebServlet("/ServletPresupuesto")
public class ServletPresupuesto extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private DaoActividad dao = new DaoActividad();
	private static List<Actividad> actividadesOfrecidas = new ArrayList<Actividad>();
	private static List<Actividad> actividadesSeleccionadas = new ArrayList<Actividad>();
	private double acumulado=0;
	
    public ServletPresupuesto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		switch (accion) {
		case "listar": 		// actividads...
			actividadesOfrecidas = dao.listarActividades(2);
			request.getSession().setAttribute("lstActividadesOfrecidas", actividadesOfrecidas);
			
			break;

		case "agregar":
			int id = Integer.parseInt(request.getParameter("idActividad"));
			Actividad sub = actividadesOfrecidas.stream().filter(ac -> ac.getIdActividad() == id).findFirst().get();
			actividadesSeleccionadas.add(sub);
			actividadesOfrecidas.remove(sub);
			acumulado += sub.getPrecio();
			request.getSession().setAttribute("presupuesto", acumulado);
			request.getSession().setAttribute("lstActividadesSeleccionadas", actividadesSeleccionadas);
			
			break;
		
		case "quitar":
			id = Integer.parseInt(request.getParameter("idActividad"));
			sub = actividadesSeleccionadas.stream().filter(ac -> ac.getIdActividad() == id).findFirst().get();
			actividadesOfrecidas.add(sub);
			actividadesSeleccionadas.remove(sub);
			acumulado -= sub.getPrecio();
			request.getSession().setAttribute("presupuesto", acumulado);
			request.getSession().setAttribute("lstActividadesSeleccionadas", actividadesSeleccionadas);
			break;
		}
		
		
		

		
		request.getRequestDispatcher("vista/tecnico/resumenAtencion.jsp").forward(request, response);
		
	}

	/*System.out.println("-".repeat(30) +"OFRECIDAS"+"-".repeat(30));
	for (Actividad a : actividadesOfrecidas) {
		System.out.println(a.getNombre()+"=>"+a.getPrecio());
	}
	System.out.println("-".repeat(70));
	
	System.out.println("-".repeat(30) +"SELECCIONADAS"+"-".repeat(30));
	for (Actividad a : actividadesSeleccionadas) {
		System.out.println(a.getNombre()+"=>"+a.getPrecio());
	}
	System.out.println("-".repeat(70));*/
}
