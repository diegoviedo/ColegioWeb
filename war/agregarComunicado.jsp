<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Comunicado</title>
   
  	<jsp:include page="cabecerA.jsp"></jsp:include>
   <h1> AGREGAR COMUNICADO </h1>
   
   <form action="agregarComunicado" method ="get">
	   
	   <textarea rows="4" cols="50" name="comunicado">
	
		</textarea><br>
  	 	
    
    <input type="submit" value ="PUBLICAR">
   </form>
	 	
    
    <input type="submit" value ="REGISTRAR">
   </form>
   <jsp:include page="pieDePagina.jsp"></jsp:include>
  </body>
</html>