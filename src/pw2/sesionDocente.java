package pw2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class sesionDocente extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		String codigo = req.getParameter("codigo");
		String contrasena = req.getParameter("pass");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		resp.setContentType("text/html");
		
		Query q = pm.newQuery(docente.class);

		try{
			
			List<docente> docentes = (List<docente>) q.execute();
			for(docente p: docentes){
				if(p.getCodigo().equals(codigo)&&p.getContrasena().equals(contrasena)){
					HttpSession misesion= req.getSession(true);
					misesion.setAttribute("nombre",p.getNombres());
					misesion.setAttribute("apellidos",p.getApellidos());
					misesion.setAttribute("codigo",p.getCodigo());
					misesion.setAttribute("tutorAnho",p.getTutorAnho());
					misesion.setAttribute("curso",p.getCurso());
					resp.sendRedirect("comoDocente.jsp");
				}
				else{
					resp.sendRedirect("index.jsp");
				}
			}

		}catch(Exception e){
			
		}finally{
			 q.closeAll();
		}
		
		
		
	
	}
}
