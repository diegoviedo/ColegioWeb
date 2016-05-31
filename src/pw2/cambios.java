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
public class cambios extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PrintWriter out = resp.getWriter();
		String codigo = req.getParameter("codigo");
		String boton = req.getParameter("boton");
		resp.setContentType("text/html");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		if(boton.equals("ELIMINAR ALUMNO")){

			Query q = pm.newQuery(alumno.class);
			try{
			List<alumno> alumnos = (List<alumno>) q.execute();
				for(alumno p: alumnos){
					if(codigo.equals(p.getCodigo()))
					pm.deletePersistent(p);
				}
				try{
					
					RequestDispatcher rd = req.getRequestDispatcher("comoAdmi.jsp");
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
			
			
		}else{
			
			try{
				
				
				req.setAttribute("codigo", codigo);
				RequestDispatcher rd = req.getRequestDispatcher("/modificar");
				rd.forward(req, resp);
			}catch(Exception e){
				System.out.println(e);
			}finally{
				if( pm.currentTransaction().isActive() ){
					pm.currentTransaction().rollback();
			    }
			}
		
		
		
		}
		
		
		
		
	}
}
