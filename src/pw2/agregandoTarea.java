package pw2;

import java.io.IOException;
import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import pw2.PMF;

@SuppressWarnings("serial")
public class agregandoTarea extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		HttpSession misesion= req.getSession();
		String nombre = (String) misesion.getAttribute("nombre");
		String tutorAnho = (String) misesion.getAttribute("tutorAnho");
		String curso = (String) misesion.getAttribute("curso");
		String dia = req.getParameter("dia");
		String mes = req.getParameter("mes");
		String hora = req.getParameter("hora");
		String minuto = req.getParameter("minuto");
		String tarea = req.getParameter("tarea");
		Date date = new Date();
		String fecha = date.toString(); 
		tarea t = new tarea(nombre,tutorAnho,curso,dia,mes,hora,minuto,tarea,fecha);
		
		resp.getWriter().print("<!DOCTYPE html>"		 
				+ "<html><body>");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(t);
			System.out.println(t.getNombre()+"\t"+t.getTutorAnho()+"\t"+t.getCurso()+"\t"+t.getDia()+"\t"+t.getMes()+"\t"+t.getHora()+"\t"+t.getMinuto()+"\t"+t.getTarea());
			//System.out.println(dia+"\t"+mes+"\t"+hora+"\t"+minuto+"\t"+tarea);
			resp.sendRedirect("comoDocente.jsp");
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrió un error, <a href='index.jsp'>vuelva a intentarlo</a>");
		}finally{
			pm.close();
		}
		
		
		resp.getWriter().print("<form action='comoAdmi.jsp'>"+
		
				"<input type='submit' value='REGRESAR AL MENU'></form>");
		
	}
}
