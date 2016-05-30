package pw2;

import java.io.IOException;
import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import pw2.PMF;

@SuppressWarnings("serial")
public class agregarComunicado extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String comunicado = req.getParameter("comunicado");
		Date date = new Date();
		String fecha = date.toString(); 
		comunicado a = new comunicado(comunicado,fecha);
		

		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(a);

			try{
				
				RequestDispatcher rd = req.getRequestDispatcher("/comoAdmi.jsp");
				rd.forward(req, resp);
			}catch(Exception e){
				System.out.println(e);
			}finally{
				if( pm.currentTransaction().isActive() ){
					pm.currentTransaction().rollback();
			    }
			}	
			
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
