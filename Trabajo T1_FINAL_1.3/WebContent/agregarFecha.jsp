<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body bgcolor>

<%String mensaje=(String)request.getAttribute("mensaje");%>
<form name="form1" method="post" action="agregarFecha">
	
  <table width="372" border="0" align="center">
    <tr>
      <td colspan="2" bgcolor="#0099FF"><div align="center"><strong>AGREGAR FECHA </strong></div></td>
    </tr>
    <tr>
      <td bgcolor="#CCCCCC">Fecha</td>
      <td><input name="txt_fecha" type="text" id="txt_fecha"/></td>
    </tr>
    <tr>
      <td bgcolor="#CCCCCC">Descripcion</td>
      <td><textarea name="txt_descripcion" id="txt_apellidos"></textarea></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input name="btn_grabar" type="submit" id="btn_grabar" value="Actualizar">
      <input name="btn_limpiar" type="reset" id="btn_limpiar" value="Limpiar"></td>
    </tr>
    <%if(mensaje!=null){ %>
    <%=mensaje %>
    <%} %>
  </table>

</form>

</body>
</body>
</html>