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
			//	List<Persona> personas = (List<Persona>) q.execute();
				//out.println("<form action='cambios'>");
				for(alumno p: alumnos){
					if(p.getCodigo().equals(codigo)){
							try{
							//	List<Persona> personas = (List<Persona>)q.execute("Amarillo");
								//	pm.deletePersistent(p);
							
						out.print(
						 "<form action='agregar' method ='get'>"+
						   "Codigo <input type='text' placeholder='Codigo' value= "+p.getCodigo()+ " name='codigo'><br>"+
						   "Contraseña <input type='text' placeholder='Contrasena' value= "+p.getContrasena()+ " name='contrasena'><br>"+
						  "Nombres <input type='text' placeholder='Nombres' value= "+p.getNombres()+ " name='nombres'><br>"+
						   "Apellidos <input type='text' placeholder='Apellidos' value= "+p.getApellidos()+ " name='apellidos'><br>"+
						   "Direccion <input type='text' placeholder='Direccion' value= "+p.getDireccion()+ " name='direccion'><br>"+
						   
					 
					   	   "Sexo"+
						   "<select name='sexo'>"+
								"<option value='masculino'>Masculino</option>"+
								"<option value='femenino'>Femenino</option>"+
							"</select><br>"+
					   		"Año"+
						   "<select name='año'>"+
								"<option value='1°'>1°</option>"+
								"<option value='2°'>2°</option>"+
								"<option value='3°'>3°</option>"+
								"<option value='4°'>4°</option>"+
								"<option value='5°'>5°</option>"+
							"</select><br>"+
					   		
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
	
			
	}
}