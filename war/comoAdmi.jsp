<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>ADMINISTRADOR</title>

<jsp:include page="cabecerA.jsp"></jsp:include>

<div class=cuerpo2>
	<div class=tituloSesion>
		<h1>ADMINISTRADOR</h1>
	</div>
	<div class=bloqueDe3>
		<h2>ALUMNOS</h2>

		<form action="alumnoAgregar.jsp" method="get">
			<input type="submit" value="Agregar Alumno">
		</form>

		<form action="verAlumnos" method="get">
			<input type="submit" value="Ver Alumnos">
		</form>
	</div>
	<div class=bloqueDe3>
		<h2>DOCENTES</h2>

		<form action="agregarDocente.jsp" method="get">
			<input type="submit" value="Agregar Docente">
		</form>


		<form action="verDocentes" method="get">
			<input type="submit" value="Ver Docente">
		</form>
	</div>
	<div class=bloqueDe3>
		<h2>COMUNICADOS</h2>

		<form action="agregarComunicado.jsp" method="get">
			<input type="submit" value="Agregar Comunicado">
		</form>

		<form action="verComunicados" method="get">
			<input type="submit" value="Ver Comunicados">
		</form>
	</div>
</div>
<jsp:include page="pieDePagina.jsp"></jsp:include>
</body>
</html>