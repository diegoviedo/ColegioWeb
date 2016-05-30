package pw2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import pw2.PMF;
import pw2.alumno;

@SuppressWarnings("serial")
public class eliminarNotas extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PrintWriter out = resp.getWriter();
		String []notas = req.getParameterValues("nota");
		resp.setContentType("text/html");
		PersistenceManager pm = PMF.get().getPersistenceManager();

			Query q = pm.newQuery(nota.class);
			try{
		
			List<nota> ns = (List<nota>) q.execute();
				for(nota p: ns){
					pm.deletePersistent(p);
				}
				try{
					req.setAttribute("nota",notas);
					RequestDispatcher rd = req.getRequestDispatcher("/guardarNotas");
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
