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
public class verComunicados extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/JSP");
		
		Query q = pm.newQuery(comunicado.class);

		resp.getWriter().print("<h1>LISTA DE COMUNICADOS</h1>");
		try{
			
			List<comunicado> comunicados = (List<comunicado>) q.execute();
	
			out.println("<form action='eliminarComunicado'>");
			for(comunicado p: comunicados){
				out.print("<input type='radio' name='comunicado' value='"+p.getComunicado()+"'>");
				out.print(p.getComunicado()+"<br>"+"PUBLICADO EL:"+p.getFecha()+"<br><br>");
				
			}

		}catch(Exception e){
			
		}finally{
			 q.closeAll();
		}
		resp.getWriter().print(
				"<input type='submit' name='boton' value='ELIMINAR COMUNICADO'></form>"
				);
	}
}
