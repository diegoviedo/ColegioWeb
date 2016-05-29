package pw2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class verAlumnos extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		Query q = pm.newQuery(alumno.class);
	//	q.setFilter("color == colorParam");
	//	q.declareParameters("String colorParam");
		resp.getWriter().print("<h1>LISTA DE ALUMNOS</h1>");
		try{
			
			List<alumno> alumnos = (List<alumno>) q.execute();
		//	List<Persona> personas = (List<Persona>) q.execute();
			out.println("<form action='cambios'>");
			for(alumno p: alumnos){
				out.print("<input type='radio' name='codigo' value='"+p.getCodigo()+"'>");
				out.print(p+"<br>");
				
			}

		}catch(Exception e){
			
		}finally{
			 q.closeAll();
		}
		resp.getWriter().print(
				"<input type='submit' name='boton' value='MODIFICAR ALUMNO'><br><br>"+
				"<input type='submit' name='boton' value='ELIMINAR ALUMNO'></form>"
				);
	}
}
