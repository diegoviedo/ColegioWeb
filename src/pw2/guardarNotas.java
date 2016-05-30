package pw2;

import java.io.IOException;
import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import pw2.PMF;

@SuppressWarnings("serial")
public class guardarNotas extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		HttpSession misesion= req.getSession();
		//ArrayList<String> codigos = new ArrayList<String>();
		ArrayList<String> codigos = (ArrayList<String>) misesion.getAttribute("codigos");
		String []notas = req.getParameterValues("nota");
		String anho = (String) misesion.getAttribute("tutorAnho");
		String curso = (String) misesion.getAttribute("curso");
		//System.out.println(notas.length+"           adasdasd");
		for(int i=0;i<notas.length;i++){
		//System.out.println(codigos.get(i)+"\t"+notas[i]+"\t"+anho+""+curso);
			//nota a = new nota(codigos[i],anho,curso,notas[0]);
		
		/*resp.getWriter().print("<!DOCTYPE html>"		 
				+ "<html><body>");
*/			if(notas[i].equals("--"))continue;
		//	nota n = new nota(codigos.get(i),anho,curso,notas[i]);
		
			PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			
			pm.makePersistent( new nota(codigos.get(i),anho,curso,notas[i]));
			System.out.println("GUARDO :D");
			
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrió un error, <a href='index.jsp'>vuelva a intentarlo</a>");
		}finally{
			pm.close();
		}
		
}		
		resp.sendRedirect("comoDocente.jsp");
		
	}
}
