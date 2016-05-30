package pw2;
import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import pw2.PMF;
import pw2.docente;



public class opcionesDocente extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException 
	{
		
		String codigo=req.getParameter("codigo");
		String pass=req.getParameter("pass");
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		//consulta ala clase Docente
		final Query q = pm.newQuery(docente.class);
		
		List<docente> docentes = (List<docente>) q.execute();
		req.setAttribute("docentes", docentes);
		//RequestDispatcher rd = req.getRequestDispatcher("mostrarDocentes.jsp");
		//rd.forward(req, resp);
		boolean entro=false;
		if(docentes!=null)
		{
			for(docente d : docentes)
			{
				if(codigo.equals(d.codigo)&& pass.equals(d.contrasena))
				{
					resp.getWriter().println("<html><head><title>Docente..</title></head>"+
				    "<body><center><img src='imagenes/docente.png' class='admin'></center>"+
					"<center><a href=agregarOModificarNotasAlumno.html><input type='button' value='Agregar o modificar notas' class='admin'></a><br>"+
	"<a href='agregarOModificarTareas.html'><input type='button' value='Agregar o modificar tareas'class='admin'></a><br></center>");
				entro=true;
				break;
				}
				
			}
			if(entro=false)
			{
				resp.getWriter().println("<h1>DOCEMTE NO EXISTENTE!(porfavor revise sus datos)");
				
			}
			}
		}
		
		
		//if()
		
	}

