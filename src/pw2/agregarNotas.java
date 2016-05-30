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
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class agregarNotas extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		HttpSession misesion= req.getSession();
		Query q = pm.newQuery(alumno.class);
		String anho = (String) misesion.getAttribute("tutorAnho");
		resp.getWriter().print("<h1>LISTA DE ALUMNOS</h1>");
		try{
			int ii=0;
			List<alumno> alumnos = (List<alumno>) q.execute();
			out.println("<form action='cambios'>");
			for(alumno p: alumnos){
				System.out.println(alumnos.size()+"\t"+p.getAnho()+"\t"+anho+"  "+ii);
				if(p.getAnho().equals(anho)){
					out.print("<input type='radio' name='codigo' value='"+p.getCodigo()+"'>");
					out.print("------- <label>"+p.toString()+"</label>");
				out.print("<select name='nota'>");
				for(int i=0;i<21;i++){
					out.print("<option>"+i+"</option>");
				}
				out.print("</select><br><br>");
				}ii++;
			}

		}catch(Exception e){
			
		}finally{
			 q.closeAll();
		}
		resp.getWriter().print(
				"<input type='submit' name='boton' value='REGISTRAR NOTA'></form>"
				);
	}
}
