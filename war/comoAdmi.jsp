<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Agregar Alumno</title>
   
  	<jsp:include page="cabecerA.jsp"></jsp:include>
  	
   <h1> ALUMNOS </h1>
   
   <form action="agregarAlumno.jsp" method ="get">
    <input type="submit" value ="Agregar Alumno">
   </form>
   
   
    <form action="verAlumnos" method ="get">
    <input type="submit" value ="Ver Alumnos">
   </form>
   
   <h1> DOCENTES </h1>
   
   <form action="agregarDocente.jsp" method ="get">
    <input type="submit" value ="Agregar Docente">
   </form>
   
   
    <form action="verDocentes" method ="get">
    <input type="submit" value ="Ver Docente">
   </form>
   
   <h1> COMUNICADOS </h1>
   
   <form action="agregarComunicado.jsp" method ="get">
    <input type="submit" value ="Agregar Comunicado">
   </form>
	
	 <form action="verComunicados" method ="get">
    <input type="submit" value ="Ver Comunicados">
   </form>
   
   <jsp:include page="pieDePagina.jsp"></jsp:include>
  </body>
</html>