<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

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