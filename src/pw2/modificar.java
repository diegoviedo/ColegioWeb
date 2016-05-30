package pw2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

import pw2.PMF;

@SuppressWarnings("serial")
public class modificar extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String codigo = (String) req.getAttribute("codigo");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		Query q = pm.newQuery(alumno.class);	
		
	try{
				
				List<alumno> alumnos = (List<alumno>) q.execute();

				for(alumno p: alumnos){
					if(p.getCodigo().equals(codigo)){
							try{
							
							
						out.print(
						 "<form action='agregarAlum' method ='get'>"+
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
							
							out.print("</select><br>");
					   		
							
							
							
							
							
							out.print("Año"+
							
						   "<select name='anho'>");
						out.print("<option value='1ro'");
						if(p.getAnho().equals("1ro")){out.print("selected");}
						out.print(">1ro</option>");
						
								
						out.print("<option value='2do'");
						if(p.getAnho().equals("2do")){out.print("selected");}
						out.print(">2do</option>");
						
								
						out.print("<option value='3ro'");
						if(p.getAnho().equals("3ro")){out.print("selected");}
						out.print(">3ro</option>");
						
								
						out.print("<option value='4to'");
						if(p.getAnho().equals("4to")){out.print("selected");}
						out.print(">4to</option>");
						
								
						out.print("<option value='5to'");
						if(p.getAnho().equals("5to")){out.print("selected");}
						out.print(">5to</option>");
						
								
						System.out.println(p.getAnho());	
								
								
								
						out.print("</select><br>"+
					   		
					   		"Agregar foto:" +
					   		"<input type='file'  name='archivo'><br>"+
					   
					   
					  	 	
					    
					    "<input type='submit' value ='MODIFICAR'>"+
					   "</form>");
						
						pm.deletePersistent(p);
						
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
	
			
	}
}