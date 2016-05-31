package pw2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class verTareas extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		Query q = pm.newQuery(tarea.class);

		resp.getWriter().print("<h1>LISTA DE TAREAS</h1>");
		try{
			String activo ="TIEMPO EXPIRADO";
			List<tarea> tareas = (List<tarea>) q.execute();
	
			out.println("<form action='eliminarComunicado'>");
			for(tarea p: tareas){
				//out.print("<input type='radio' name='comunicado' value='"+p.getComunicado()+"'>");
				out.print("<input type='radio' name='tarea' value='"+p.getTarea()+"'>");
				out.print(p.getTarea()+"<br>");
				out.print("PUBLICADO POR "+p.getNombre()+" EL DIA "+p.getFecha()+"<br>");
				out.print("TIEMPO LIMITE:  DIA "+p.getDia()+", MES "+p.getMes()+", HORA "+p.getHora()+", MINUTO "+p.getMinuto()+"<br>" );
				out.print("ESTADO :");
				Date date = new Date();
				//System.out.println(date.getMonth()-Integer.parseInt(p.getMes()));
				if(Integer.parseInt(p.getMes())-date.getMonth()>0)
					activo="TIEMPO NO EXPIRADO";
				else
					if(Integer.parseInt(p.getMes())-date.getMonth()==0)
						if(Integer.parseInt(p.getDia())-date.getDay()>0)
							activo="TIEMPO NO EXPIRADO";
						else
							if(Integer.parseInt(p.getDia())-date.getDay()==0)
								if(Integer.parseInt(p.getHora())-date.getHours()>0)
									activo="TIEMPO NO EXPIRADO";
								else
									if(Integer.parseInt(p.getHora())-date.getHours()==0)
										if(Integer.parseInt(p.getMinuto())-date.getMinutes()>0)
											activo="TIEMPO NO EXPIRADO";
				out.print(activo+"<br><br>");			
			//	out.print(p.getComunicado()+"<br>"+"PUBLICADO EL:"+p.getFecha()+"<br><br>");
				
			}

		}catch(Exception e){
			
		}finally{
			 q.closeAll();
		}
		resp.getWriter().print(
				"<input type='submit' name='boton' value='ELIMINAR TAREA'></form>"
				);
	}
}
