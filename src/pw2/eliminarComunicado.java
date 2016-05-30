package pw2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;


import epis.unsa.PMF;
import epis.unsa.alumno;

@SuppressWarnings("serial")
public class eliminarComunicado extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PrintWriter out = resp.getWriter();
		String comunicado = req.getParameter("comunicado");
		
		resp.setContentType("text/html");
		PersistenceManager pm = PMF.get().getPersistenceManager();

			Query q = pm.newQuery(comunicado.class);
			try{
		
			List<comunicado> comunicados = (List<comunicado>) q.execute();
				for(comunicado p: comunicados){
					if(comunicado.equals(p.getComunicado()))
					pm.deletePersistent(p);
				}
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
				
			}finally{
				 q.closeAll();
			}
			

		
		
		
		
		
		
	}
}
