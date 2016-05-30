<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Hello App Engine</title>
  </head>

  <body>
  
  
  <%String eliminado = HttpServletRequest.getAttribute("eliminado");%>
  <%if(eliminado.equals("si")){%>
 <h1>USUARIO ELIMINADO!!</h1><br><br>
  <%}%>
  
   <h1> MENU </h1>
   
   <form action="agregarAlumno.jsp" method ="get">
    <input type="submit" value ="Agregar Alumno">
   </form>
   
   
    <form action="verAlumnos" method ="get">
    <input type="submit" value ="Ver Alumnos">
   </form>
   
   
  </body>
</html>