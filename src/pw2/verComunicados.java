package pw2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class verComunicados extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		Query q = pm.newQuery(comunicado.class);

		resp.getWriter().print("<html>"
				  +"<head>"
				    +"<meta http-equiv='content-type' content='text/html; charset=UTF-8'>"
				    +"<title>Ver Comunicados</title>"
				   
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
						+"<a href='docenteHtml'><img src='../imagenes/docente.png' class='imagenSesion'></a>"
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
						+"<h1>ADMINISTRADOR</h1>"
						+"</div>"
						+"<div class=bloqueDe2>"


				+ "<h1>LISTA DE COMUNICADOS</h1>");
		try{
			
			List<comunicado> comunicados = (List<comunicado>) q.execute();
	
			out.println("<form action='eliminarComunicado'>");
			for(comunicado p: comunicados){
				out.print("<input type='radio' name='comunicado' value='"+p.getComunicado()+"'>");
				out.print(p.getComunicado()+"<br>"+"PUBLICADO EL:"+p.getFecha()+"<br><br>");
				
			}

		}catch(Exception e){
			
		}finally{
			 q.closeAll();
		}
		resp.getWriter().print(
				"<input type='submit' name='boton' value='ELIMINAR COMUNICADO'></form>"
				+ "</div>"	
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
