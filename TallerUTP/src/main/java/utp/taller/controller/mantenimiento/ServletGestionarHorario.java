package utp.taller.controller.mantenimiento;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jms.Message;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.taller.dao.DaoHorario;
import utp.taller.dao.DaoTecnico;
import utp.taller.dto.DtoTecnicoNombre;
import utp.taller.entidades.Horario;

/**
 * Servlet implementation class ServletProgramacionHorario
 */
@WebServlet("/ServletGestionarHorario")
public class ServletGestionarHorario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public ServletGestionarHorario() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String accion = request.getParameter("accion");
    	switch(accion) {
    	case "listar":
    		int m = Integer.parseInt(request.getParameter("mes"));
        	
        	DaoTecnico dao = new DaoTecnico();
        	List<DtoTecnicoNombre> lstSH = dao.listarTecnicoSinHorario(m, 2022);
        	List<DtoTecnicoNombre> lstCH = dao.listarTecnicoConHorario(m, 2022);
        	request.getSession().setAttribute("mes", m);
        	request.getSession().setAttribute("lstSH",lstSH);
        	request.setAttribute("lstCH",lstCH);
        	System.out.println("Ingreso al servlet -----------*****<<<<<" );
        	request.getRequestDispatcher("vista/encargado/gestionHorarios.jsp").forward(request, response);
    		break;
    	case "generar":
    		int horaInicio = Integer.parseInt(request.getParameter("hInicio").substring(0,2));
        	int horaFinal = Integer.parseInt(request.getParameter("hFinal").substring(0, 2));
        	
        	int intervalo = horaFinal - horaInicio;
        	
        	System.out.println(horaInicio + " " +horaFinal);
        	int mes = Integer.parseInt(request.getParameter("mes"));
        	List<DtoTecnicoNombre> lst = (List<DtoTecnicoNombre>) request.getSession().getAttribute("lstSH");
        	
        	
        	System.out.println(lst.size() + " el tamaño de la lista <<<");
        	
        	//SimpleDateFormat format = new SimpleDateFormat();
        	Calendar calendar = Calendar.getInstance();
        	calendar.set(2022, mes+1, 1);
        	
        	DaoHorario daoHorario = new DaoHorario();
        	for (DtoTecnicoNombre dtoTecnico : lst) {
				for (int i = 0; i < diasDelMes(mes, 2022); i++) {
					for (int j = 1; j <= intervalo; j++) {
						Horario horario = new Horario();
						horario.setIdTecnico(dtoTecnico.getId());
						horario.setFechaAtencion(calendar.getTime());
						horario.setHoraInicio(((intervalo<10)?("0"+horaInicio+j):horaInicio+j) +":00:00");	
						daoHorario.insertarHorario(horario);
											
					}
					calendar.add(Calendar.DATE, 1);	
				}
				calendar.set(2022, mes+1, 1);
			}
        	request.getRequestDispatcher("vista/encargado/gestionHorarios.jsp").forward(request, response);
        	break;
    	}
    	
    	
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}
	
	
	protected int diasDelMes(int mes, int anyo) {
		int numDias = 0;
 
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                numDias = 31;
                break;
            case 4: case 6: case 9: case 11:
                numDias = 30;
                break;
            case 2:
                if((anyo%4==0 && anyo%100!=0) || anyo%400==0){
                    numDias = 29;
                }
                else{
                    numDias = 28;
                }
                break;
            default:
               
                break;
        }
		
        return numDias;
	}

}
