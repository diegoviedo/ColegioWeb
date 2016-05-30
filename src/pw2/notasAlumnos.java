package pw2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class notasAlumnos extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		PersistenceManager pm1 = PMF.get().getPersistenceManager();
		
		PrintWriter out = resp.getWriter();
		ArrayList<String> codigos = new ArrayList<String>();
		resp.setContentType("text/html");
		HttpSession misesion= req.getSession();
		Query q = pm.newQuery(alumno.class);
		Query q1 = pm1.newQuery(nota.class);
		String note="";
		String anho = (String) misesion.getAttribute("tutorAnho");
		resp.getWriter().print("<h1>LISTA DE ALUMNOS</h1>");
		try{
			int ii=0;
			List<alumno> alumnos = (List<alumno>) q.execute();
			List<nota> notas = (List<nota>) q1.execute();
			
			out.println("<form action='eliminarNotas'>");
			for(alumno p: alumnos){
				System.out.println(alumnos.size()+"\t"+p.getAnho()+"\t"+anho+"  "+ii);
				if(p.getAnho().equals(anho)){
					out.print("------- <label name='codigo'>"+p.toString()+"</label>");
					codigos.add(p.getCodigo());
					out.print("<select name='nota'>");
					out.print("<option>--</option>");
				for(nota t: notas){
					System.out.println("EL TAMA�O DE  NOTA ES  "+notas.size() +"     "+t.getNota());
						if(t.getCodigo().equals(p.getCodigo()))note=t.getNota();
				
					}
				for(int i=0;i<21;i++){
					out.print("<option value='"+i+"'");
					if(note.equals(i+""))
						out.print("selected");
					out.print(">"+i+"</option>");
				}
				out.print("</select><br><br>");
				}ii++;
			}
			misesion.setAttribute("codigos",codigos);
			
		}catch(Exception e){
			
		}finally{
			 q.closeAll();
		}
		resp.getWriter().print(
				"<input type='submit' name='boton' value='INGRESAR NOTAS'></form>"
				);
	}
}