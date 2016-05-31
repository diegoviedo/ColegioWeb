package pw2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

import pw2.PMF;

@SuppressWarnings("serial")
public class modificarDoc extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String codigo = (String) req.getAttribute("codigo");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		Query q = pm.newQuery(docente.class);	
		out.print("<html>"
				  +"<head>"
				    +"<meta http-equiv='content-type' content='text/html; charset=UTF-8'>"
				    +"<title>MODIFICAR DOCENTE</title>"
				   
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
						+"<h1>ADMINISTRADOR</h1>"
						+"</div>"
						+"<div class=bloqueDe2>");
	try{
				
				List<docente> docentes = (List<docente>) q.execute();
				for(docente p: docentes){
					if(p.getCodigo().equals(codigo)){
							try{	
						out.print("<h1>MODIFICAR DOCENTE</h1>"
						 +"<form action='agregarDoc' method ='get'>"+
						   "Codigo <input type='text' placeholder='Codigo' value= "+p.getCodigo()+ " name='codigo'><br>"+
						   "Contraseña <input type='text' placeholder='Contrasena' value= "+p.getContrasena()+ " name='contrasena'><br>"+
						  "Nombres <input type='text' placeholder='Nombres' value= "+p.getNombres()+ " name='nombres'><br>"+
						   "Apellidos <input type='text' placeholder='Apellidos' value= "+p.getApellidos()+ " name='apellidos'><br>"+
						   "Direccion <input type='text' placeholder='Direccion' value= "+p.getDireccion()+ " name='direccion'><br>"+
						   
					 
					   	   "Sexo"+
						   "<select name='sexo'>");
						out.print("<option value='masculino'");
						
						
						if(p.getSexo().equals("masculino")){out.print("selected");}
						out.print(">Masculino</option>");
						
						out.print("<option value='femenino'");
						if(p.getSexo().equals("femenino")){out.print("selected");}
						out.print(">femenino</option>");
						
								
								out.print("</select><br>"+
					   		"Tutor Anho"+
						   "<select name='tutorAnho'>");

						out.print("<option value='1ro'");
						if(p.getTutorAnho().equals("1ro")){out.print("selected");}
						out.print(">1ro</option>");
						
								
						out.print("<option value='2do'");
						if(p.getTutorAnho().equals("2do")){out.print("selected");}
						out.print(">2do</option>");
						
								
						out.print("<option value='3ro'");
						if(p.getTutorAnho().equals("3ro")){out.print("selected");}
						out.print(">3ro</option>");
						
								
						out.print("<option value='4to'");
						if(p.getTutorAnho().equals("4to")){out.print("selected");}
						out.print(">4to</option>");
						
								
						out.print("<option value='5to'");
						if(p.getTutorAnho().equals("5to")){out.print("selected");}
						out.print(">5to</option>");
						
						
						
						
							out.print("</select><br>"+
					   		

						   	"Curso <input type='text' placeholder='Curso'  value= "+p.getCurso()+ " name='curso'><br>"+
							"Correo <input type='text' placeholder='Correo'  value= "+p.getCorreo()+ " name='correo'><br>"+
							"Telefono <input type='text' placeholder='Telefono'  value= "+p.getTelefono()+ " name='telefono'><br>"+
							   
						   		
					   		
					   		
					   		
					   		
					   		
					   		
					   		
					   		
					   		
					   		
					   		
					   		"Agregar foto:" +
					   		"<input type='file'  name='archivo'><br>"+
					   
					   
					  	 	
					    
					    "<input type='submit' value ='REGISTRAR'>"+
					   "</form>");
						
						pm.deletePersistent(p);
						System.out.println("YA BORRO");
						}catch(Exception e){
								
							}finally{
								 q.closeAll();
							}
						
					
						
						
						
					}
				}
	
			}catch(Exception e){
				
			}finally{
				 q.closeAll();
			}
	out.print("</div>"	
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