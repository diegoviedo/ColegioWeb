<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Agregar Alumno</title>
   
  	<jsp:include page="cabecerA.jsp"></jsp:include>
  	<div class=cuerpo2>
	<div class=tituloSesion>
		<h1>DOCENTE</h1>
	</div>
	
	<div class=bloqueDe3>
   <h2> NOTAS </h2>
   
   <form action="notasAlumnos" method ="get">
    <input type="submit" value ="Agregar Notas">
   </form>
   </div>
	<div class=bloqueDe3>
   
    
   <h2> TAREAS </h2>
   
   <form action="agregarTarea.jsp" method ="get">
    <input type="submit" value ="Agregar Tarea">
   </form>
   
       <form action="verTareas" method ="get">
    <input type="submit" value ="Ver Tareas">
   </form>
   
   </div>
	
 
  </div>  
   <jsp:include page="pieDePagina.jsp"></jsp:include>
  </body>
</html>
 