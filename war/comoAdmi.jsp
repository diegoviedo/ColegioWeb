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
   
  </body>
</html>