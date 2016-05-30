<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Agregar Alumno</title>
   
  	<jsp:include page="cabecerA.jsp"></jsp:include>
   <h1> AGREGAR ALUMNO </h1>
   
   <form action="agregarAlum" method ="get">
	   Codigo <input type="text" placeholder="Codigo" name="codigo"><br>
	   Contraseña <input type="text" placeholder="Contraseña" name="contrasena"><br>
	   Nombres <input type="text" placeholder="Nombres" name="nombres"><br>
	   Apellidos <input type="text" placeholder="Apellidos" name="apellidos"><br>
	   Direccion <input type="text" placeholder="Direccion" name="direccion"><br>
	   
 
   	   Sexo
	   <select name="sexo">
			<option value="masculino">Masculino</option>
			<option value="femenino">Femenino</option>
		</select><br>
   		Año
	   <select name="año">
			<option value="1°">1°</option>
			<option value="2°">2°</option>
			<option value="3°">3°</option>
			<option value="4°">4°</option>
			<option value="5°">5°</option>
		</select><br>
   		
   		Agregar foto: 
   		<input type="file"  name="archivo"><br>
	
    
    <input type="submit" value ="REGISTRAR">
   </form>
   
   
   <jsp:include page="pieDePagina.jsp"></jsp:include>
  </body>
</html>
