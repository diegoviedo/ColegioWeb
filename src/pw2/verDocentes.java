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
public class verDocentes extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		Query q = pm.newQuery(docente.class);

		resp.getWriter().print("<h1>LISTA DE DOCENTES</h1>");
		try{
			
			List<docente> docentes = (List<docente>) q.execute();
			out.println("<form action='cambiosDoc'>");
			for(docente p: docentes){
				out.print("<input type='radio' name='codigo' value='"+p.getCodigo()+"'>");
				out.print(p+"<br>");
				
			}

		}catch(Exception e){
			
		}finally{
			 q.closeAll();
		}
		resp.getWriter().print(
				"<input type='submit' name='boton' value='MODIFICAR DOCENTE'><br><br>"+
				"<input type='submit' name='boton' value='ELIMINAR DOCENTE'></form>"
				);
	}
}
