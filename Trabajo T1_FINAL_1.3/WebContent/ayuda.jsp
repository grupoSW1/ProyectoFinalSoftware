<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
  <script>
  $(function() {
    $( "#dialog-modal" ).dialog({
      height:200,
      modal: true
    });
  });

   function Descargar(){
	   window.location.href='img/pdf_prueba.pdf';
    }
  
  </script>
<body>

 <div  id="dialog-modal" title="Ventana de Ayuda">
  <p> Descargue la documentacion del Sistema </p>
   <input type="button" value="Descargar"  onClick="Descargar()"/>
</div>
</body>
</html>