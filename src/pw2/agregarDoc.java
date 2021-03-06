package pw2;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import pw2.PMF;

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
		
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(d);
			resp.sendRedirect("alumnoCorrecto.jsp");
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrió un error, <a href='index.jsp'>vuelva a intentarlo</a>");
		}finally{
			pm.close();
		}
		
		
		
		
	}
}
