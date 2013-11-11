<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body bgcolor>
<%@ page import="bean.FechaBean" %>

<%FechaBean objfecha = (FechaBean)request.getAttribute("fecha"); 
	String mensaje=(String)request.getAttribute("mensaje");
%>
<form name="form1" method="post" action="editarFecha">
<%if(objfecha!=null){ %>	
	<input name="txt_id" type="hidden" 
      		value="<%=objfecha.getIdFecha()%>"/>

  <table width="372" border="0" align="center">
    <tr>
      <td colspan="2" bgcolor="#0099FF"><div align="center"><strong>EDITAR FECHA </strong></div></td>
    </tr>
    <tr>
      <td bgcolor="#CCCCCC">Fecha</td>
      <td><input name="txt_fecha" type="text" id="txt_fecha"
      		value="<%=objfecha.getFecha()%>"/></td>
    </tr>
    <tr>
      <td bgcolor="#CCCCCC">Descripcion</td>
      <td><textarea name="txt_descripcion" id="txt_apellidos"><%=objfecha.getDescripcion()%></textarea></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input name="btn_grabar" type="submit" id="btn_grabar" value="Actualizar">
      <input name="btn_limpiar" type="reset" id="btn_limpiar" value="Limpiar"></td>
    </tr>
  </table>
  <%}else{ %>
  <%=mensaje %>
  <%} %>
</form>

</body>
</html>