package pw2;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import pw2.PMF;

@SuppressWarnings("serial")
public class agregar extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String codigo = req.getParameter("codigo");
		String contrasena = req.getParameter("contrasena");
		String nombres = req.getParameter("nombres");
		String apellidos = req.getParameter("apellidos");
		String direccion = req.getParameter("direccion");
		String sexo = req.getParameter("sexo");
		String a�o = req.getParameter("a�o");

		alumno a = new alumno();
		a.setCodigo(codigo);
		a.setContrasena(contrasena);
		a.setNombres(nombres);
		a.setApellidos(apellidos);
		a.setDireccion(direccion);
		a.setSexo(sexo);
		a.setA�o(a�o);
	//	resp.getWriter().print(codigo+"\t"+contrase�a+"\t"+nombres+"\t"+apellidos+"\t"+direccion+"\t"+sexo+"\t"+a�o+"\t");
	//	resp.getWriter().print(a.getCodigo()+"\t"+a.getContrase�a()+"\t"+a.getNombres()+"\t"+a.getApellidos()+"\t"+a.getDireccion()+"\t"+a.getSexo()+"\t"+a.getA�o()+"\t"+"ASDKADNKANDASKDNAKSDN");
		resp.getWriter().print("<!DOCTYPE html>"		 
				+ "<html><body>");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(a);
			resp.getWriter().println("Datos grabados correctamente");
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrió un error, <a href='index.jsp'>vuelva a intentarlo</a>");
		}finally{
			pm.close();
		}
		
		
		resp.getWriter().print("<form action='index.html'>"+
		
				"<input type='submit' value='REGRESAR AL MENU'></form>");
		
	}
}
