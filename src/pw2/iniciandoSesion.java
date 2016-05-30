package pw2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class iniciandoSesion extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PrintWriter out = resp.getWriter();
		String action="";
		String boton = req.getParameter("boton");
		if(boton.equals("COMO DOCENTE"))action="sesionDocente";
		resp.setContentType("text/html");
		
		out.print("<form action='"+action+"'>");
		out.print("INGRESE CODIGO");
		out.print("<input type ='text' name='codigo'><br>");
		out.print("INGRESE CONTRASEÑA");
		out.print("<input type ='text' name='contrasena'><br>");
		out.print("<input type='submit' value ='OK'></form>");
		
	
	}
}
