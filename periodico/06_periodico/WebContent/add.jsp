<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
    <form class="col s12" action="add" method="post">
      
      <div class="row">
        <div class="input-field col s12">
          <input id="email" type="email" class="validate" name="mail">
          <label for="email">Email</label>
        </div>
      </div>
		

  <select class="browser-default">
    <option value="" disabled selected>Selecciona una opcion</option>
    <option value="1">Deportes</option>
    <option value="2">Politica</option>
    <option value="3">Economia</option>
  </select>

      <div class="row">
        <div class="input-field col s6">
          <input id="first_name" type="text" class="validate"name="titulo">
          <label for="first_name">Titulo</label>
        </div>
      </div>
       
   
      <div class="row">
        <div class="input-field col s12">
          <textarea id="textarea1" class="materialize-textarea" name="contenido"></textarea>
          <label for="textarea1">Contenido</label>
        </div>
      </div>
      
      <input type="submit" value ="enviar">
      <a class="waves-effect waves-light btn" href="leer.jsp">Ver noticias</a>
    </form>
  </div>
      
    </form>
  </div>
</body>
</html>