package pw2;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import epis.unsa.PMF;

@SuppressWarnings("serial")
public class agregarDoc extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String codigo = req.getParameter("codigo");
		String contrasena = req.getParameter("contrasena");
		String nombres = req.getParameter("nombres");
		String apellidos = req.getParameter("apellidos");
		String direccion = req.getParameter("direccion");
		String sexo = req.getParameter("sexo");
		String tutorAnho = req.getParameter("tutorAnho");
		String curso = req.getParameter("curso");
		String correo = req.getParameter("correo");
		String telefono = req.getParameter("telefono");
		
		docente d = new docente(codigo,contrasena,nombres,apellidos,direccion,sexo,tutorAnho,curso,correo,telefono);
		
		resp.getWriter().print("<!DOCTYPE html>"		 
				+ "<html><body>");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(d);
			resp.getWriter().println("Datos grabados correctamente");
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
