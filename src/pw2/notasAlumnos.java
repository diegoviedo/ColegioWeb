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
		out.println("<html>"
				  +"<head>"
				    +"<meta http-equiv='content-type' content='text/html; charset=UTF-8'>"
				    +"<title>ESCRIBE TITULO AQUI</title>"
				   
				+"<link rel='stylesheet' type='text/css' href='../estilos/inicioCSS.css' media='screen' />"
				+"</head>"
				+"<body>"
				+"<"
					+"<div class='general'>"
					+"<div class='cabecera'>"
						+"<div  class=titulo>"
						+"<a href='inicio.jsp'><img src='../imagenes/logo.png' id=logo></a></div >"
						+"<div class=sesiones>"
						+"<a href='comoAdmi.jsp'><img src='../imagenes/administrador.png' class='imagenSesion'></a>"
						+"<a href='docente.html'><img src='../imagenes/docente.png' class='imagenSesion'></a>"
						+"<a href='#'><img src='../imagenes/alumno.png' class='imagenSesion'></a>"
						+"</div>"
						+"<div class=redes>"
						+"<img src='../imagenes/sigue.png' id='sigue'>"
						+"<a href='https://es-la.facebook.com/Colegio-Lourdes-Arequipa-515032385179570/' target='ventanadinamica'> <img src='../imagenes/facebook.jpg' id='hola'></a>"
						+"<a href='https://www.youtube.com/channel/UCtGVyTWCEwnnkGQu8pQy0Rw' target='ventanadinamica'><img src='../imagenes/youtube.png' id='hola'></a>"
						+"</div>"
						+"<br><br>"
						+"<div class=menu>"
							+"<ul class='nav'>"
								+"<li><a href='inicio.jsp'>INICIO</a></li>"
								+"<li><a href='menuNosotros.jsp'> ¿QUIENES SOMOS?</a></li>"
								+"<li><a href='menuServicios.jsp'>SERVICIOS</a></li>"
								+"<li><a href='alumnoEliminar.jsp'>PASTORAL</a></li>"
								+"<li><a href=''>PERSONAL</a></li>"
								+"<li><a href=''>AGENDA</a></li>"
								+"<li><a href=''>ATENCION A PADRES</a></li>"
								+"<li><a href=''>ADMISION</a></li>"
							+"</ul><BR><BR>"
						+"</div>"

						+"<div class=scroll>"
						+"<marquee  scrollamount='20' direction='left' Behavior =alternate onmouseout='this.start()' onmouseover='this.stop()'>"
					
							+"<img title='Titulo de la entrada' alt='Titulo de la entrada' src='../imagenes/scroll1.jpg' class=scrollImag >"
								 
							+"<img title='Titulo de la entrada' alt='Titulo de la entrada'	src='../imagenes/scroll2.jpg' class=scrollImag >"
								
							+"<img title='Titulo de la entrada' alt='Titulo de la entrada' src='../imagenes/scroll3.jpg' class=scrollImag >"
								
							+"<img title='Titulo de la entrada' alt='Titulo de la entrada' src='../imagenes/scroll4.jpg' class=scrollImag >"
								
							+"<img title='Titulo de la entrada' alt='Titulo de la entrada' src='../imagenes/scroll5.jpg' class=scrollImag >"
								
							+"<img title='Titulo de la entrada' alt='Titulo de la entrada' src='../imagenes/scroll6.jpg' class=scrollImag >"
							
						+"</marquee>"
						
					+"<div class=cuerpo>"
				+"<div class=cuerpo2>"
						+"<div class=tituloSesion>"
						+"<h1>DOCENTE</h1>"
						+"</div>"
						+"<div class=bloqueDe2>"


				+ "<h1>LISTA DE ALUMNOS</h1>");
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
					System.out.println("EL TAMAÑO DE  NOTA ES  "+notas.size() +"     "+t.getNota());
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
		
		out.println("</div>"	
				+"<div class=footer>"
				+"<img src='../imagenes/UNO.png' width=1050px  >"
				+"<div id='cuerpo'>"
					+"<p>Av. Alfonso Ugarte 518 Tingo - Arequipa - Peru <br></p>"
					+"<p>Diego Oviedo <br> Diego Maraza <br> Leslie Mestas <br> Jhon Ambrosio" 	
					
				+"</div>"
			+"</div>"
		+"</div>"
	+"</div>"
	+"</body>"
	+"</html>");
	}
}
