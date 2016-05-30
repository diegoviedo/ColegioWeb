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
   <h1> AGREGAR DOCENTE </h1>
   
   <form action="agregarDoc" method ="get">
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
   		Tutor Año
	   <select name="tutorAnho">
			<option value="1ro">1ro</option>
			<option value="2do">2do</option>
			<option value="3ro">3ro</option>
			<option value="4to">4to</option>
			<option value="5to">5to</option>
		</select><br>
   		
   		Curso <input type="text" placeholder="Curso" name="curso"><br>
	  	Correo <input type="text" placeholder="Correo" name="correo"><br>
	  	Telefono <input type="text" placeholder="Telefono" name="telefono"><br>
	   
   		
   		
   		Agregar foto: 
   		<input type="file"  name="archivo"><br>
   
   
  	 	
    
    <input type="submit" value ="REGISTRAR">
   </form>
  </body>
</html>
