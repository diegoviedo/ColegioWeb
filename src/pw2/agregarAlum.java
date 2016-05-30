package pw2;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import pw2.PMF;

@SuppressWarnings("serial")
public class agregarAlum extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String codigo = req.getParameter("codigo");
		String contrasena = req.getParameter("contrasena");
		String nombres = req.getParameter("nombres");
		String apellidos = req.getParameter("apellidos");
		String direccion = req.getParameter("direccion");
		String sexo = req.getParameter("sexo");
		String anho = req.getParameter("anho");

		alumno a = new alumno();
		a.setCodigo(codigo);
		a.setContrasena(contrasena);
		a.setNombres(nombres);
		a.setApellidos(apellidos);
		a.setDireccion(direccion);
		a.setSexo(sexo);
		a.setAnho(anho);
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(a);

<<<<<<< HEAD
			resp.sendRedirect("../alumnoCorrecto.jsp");

=======
			resp.sendRedirect("alumnoCorrecto.jsp");
>>>>>>> origin/master

		}catch(Exception e){
			System.out.println(e);
			resp.sendRedirect("../alumnoError.jsp");
		}finally{
			pm.close();
		}
		
		
	}
}
