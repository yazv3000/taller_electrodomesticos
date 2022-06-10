package utp.taller.controller.atencion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoActividad;
import utp.taller.dao.DaoAtencion;
import utp.taller.dao.DaoPieza;
import utp.taller.dto.DtoAtencion;
import utp.taller.entidades.Actividad;
import utp.taller.entidades.Pieza;

/**
 * Servlet implementation class ServletPresupuesto
 */
@WebServlet("/ServletPresupuesto")
public class ServletPresupuesto extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private DaoActividad dao = new DaoActividad();
	private static List<Actividad> actividadesOfrecidas = new ArrayList<Actividad>();
	private static List<Actividad> actividadesSeleccionadas = new ArrayList<Actividad>();
	
	private DaoPieza daopi = new DaoPieza();
	private static List<Pieza> piezasOfrecidas = new ArrayList<Pieza>();
	private static List<Pieza> piezasSeleccionadas = new ArrayList<Pieza>();
	
	private double acumuladoActi=0;
	private double acumuladoPiezi=0;
	
	
    public ServletPresupuesto() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String accion = request.getParameter("accion");
		if(request.getParameter("id_servicio")!=null) {
			int idServ = Integer.parseInt(request.getParameter("id_servicio"));
			request.getSession().setAttribute("id_servicio", idServ);
		}
    	
		switch (accion) {
		case "listar": 		// actividades...

			actividadesOfrecidas = dao.listarActividades((int) request.getSession().getAttribute("id_servicio"));
			request.getSession().setAttribute("lstActividadesOfrecidas", actividadesOfrecidas);
			break;

		case "agregar":
			int id = Integer.parseInt(request.getParameter("idActividad"));
			Actividad sub = actividadesOfrecidas.stream().filter(ac -> ac.getIdActividad() == id).findFirst().get();
			actividadesSeleccionadas.add(sub);
			actividadesOfrecidas.remove(sub);
			acumuladoActi += sub.getPrecio();
			request.getSession().setAttribute("presupuesto", acumuladoActi);
			request.getSession().setAttribute("lstActividadesSeleccionadas", actividadesSeleccionadas);
			
			break;
		
		case "quitar":
			id = Integer.parseInt(request.getParameter("idActividad"));
			sub = actividadesSeleccionadas.stream().filter(ac -> ac.getIdActividad() == id).findFirst().get();
			actividadesOfrecidas.add(sub);
			actividadesSeleccionadas.remove(sub);
			acumuladoActi -= sub.getPrecio();
			request.getSession().setAttribute("presupuesto", acumuladoActi);
			request.getSession().setAttribute("lstActividadesSeleccionadas", actividadesSeleccionadas);
			break;
		
		case "listarPi": 		// actividads...
			piezasOfrecidas = daopi.listar();
			request.getSession().setAttribute("lstPiezasOfrecidas", piezasOfrecidas);
			
			break;
	
		case "agregarPi":
			int idPi = Integer.parseInt(request.getParameter("idPieza"));
			Pieza sub2 = piezasOfrecidas.stream().filter(pi -> pi.getIdPieza() == idPi).findFirst().get();
			if(piezasOfrecidas.contains(sub2)) {	// todavía se puede ofrecer piezas
				sub2.setCantidadComprar(sub2.getCantidadComprar()+1);
				sub2.setStock(sub2.getStock()-1);
				if(!piezasSeleccionadas.contains(sub2)){	// si no está en la tabla de piezas Seleccionadas
					piezasSeleccionadas.add(sub2);	// la agrega
				}
				if(piezasOfrecidas.get(piezasOfrecidas.indexOf(sub2)).getStock()==0){
				      piezasOfrecidas.remove(sub2);
				}
				acumuladoPiezi += sub2.getPrecio();
			}
			request.getSession().setAttribute("presupuesto2", acumuladoPiezi);
			request.setAttribute("lstPiezasSeleccionadas", piezasSeleccionadas);
			break;
		
		case "quitarPi":
			idPi = Integer.parseInt(request.getParameter("idPieza"));
			sub2 = piezasSeleccionadas.stream().filter(pi -> pi.getIdPieza() == idPi).findFirst().get();
			if(piezasSeleccionadas.contains(sub2)) {	// todavía se puede quitar piezas
				sub2.setCantidadComprar(sub2.getCantidadComprar()-1);
				sub2.setStock(sub2.getStock()+1);
				if(piezasSeleccionadas.get(piezasSeleccionadas.indexOf(sub2)).getCantidadComprar()==0){
				      piezasSeleccionadas.remove(sub2);
				}
				
				if(!piezasOfrecidas.contains(sub2)){ // si ya no estaba en la tabla de piezas Ofrecidas
					piezasOfrecidas.add(sub2);	// la agrega
				}

				acumuladoPiezi -= sub2.getPrecio();
			}
			request.getSession().setAttribute("presupuesto2", acumuladoPiezi);
			request.setAttribute("lstPiezasSeleccionadas", piezasSeleccionadas);
			break;
			
		case "confirmar": 
			/*DtoAtencion dtoAtencion = (DtoAtencion) request.getSession().getAttribute("dtoAtencion");
			int idServ =(int) request.getSession().getAttribute("id_servicio");
			
			DaoAtencion daoAte = new DaoAtencion();
			DaoActividad daoAct = new DaoActividad();
			DaoPieza daoPi = new DaoPieza();
			
			
			double presupuestoServ = (double) request.getSession().getAttribute("presupuesto");
			double costoPiezas = (double) request.getSession().getAttribute("presupuesto2");
			
			System.out.println("ID SERVICIO: "+idServ);
			System.out.println("Total de actividades: "+actividadesSeleccionadas.size());
			System.out.println("Total de piezas diferentes: "+piezasSeleccionadas.size());
			System.out.println("Servicio + venta: "+presupuestoServ+"+"+costoPiezas);
			
			daoAct.agregar_actividad_servicio(dtoAtencion.getIdAtencion(), idServ, actividadesSeleccionadas);
			if(piezasSeleccionadas!=null) {
				if(piezasSeleccionadas.size()>0)
					daoAte.agregarVenta(dtoAtencion.getIdAtencion(), costoPiezas);
					daoPi.uso_pieza(dtoAtencion.getIdAtencion(), idServ, piezasSeleccionadas);
			}
			
			daoAte.finalizarAtencionDomicilio(dtoAtencion.getIdAtencion(), idServ, presupuestoServ);
			
			limpiarListas();
			*/
			PrintWriter writer = response.getWriter();
			String htmlRespone = "<html>";
			htmlRespone += "<script type=\"text/javascript\">"
					+ "		        window.parent.location.href =vista/tecnico/menuTecnico.jsp"
					+ "		    </script>";
			htmlRespone += "</html>";
			 
			writer.println(htmlRespone);
			return;

		}		
		request.getRequestDispatcher("vista/tecnico/resumenAtencion.jsp").forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void limpiarListas() {
		actividadesOfrecidas.clear();
		actividadesSeleccionadas.clear();
		piezasOfrecidas.clear();
		piezasSeleccionadas.clear();
	}
}
