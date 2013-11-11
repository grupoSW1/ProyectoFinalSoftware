<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String mensaje=(String)request.getAttribute("mensaje"); %>
<form name="form1" method="post" action="agregarAlumno">
	

  <table width="372" border="0" align="center">
    <tr>
      <td colspan="2" bgcolor="#0099FF"><div align="center"><strong>AGREGAR ALUMNO </strong></div></td>
    </tr>
    <tr>
      <td bgcolor="#CCCCCC">Nombre:</td>
      <td><input name="txt_nombre" type="text" id="txt_correo"
      		/></td>
    </tr>
    <tr>
      <td bgcolor="#CCCCCC">Contrase&ntilde;a:</td>
      <td><input name="txt_contraseña" type="password" id="txt_apellidos"
      		/></td>
    </tr>
    <tr>
      <td bgcolor="#CCCCCC">Grupo:</td>
      <td><input name="txt_grupo" type="text" id="txt_nombres"
      		></td>
    </tr>
    <tr>
      <td bgcolor="#CCCCCC">Seccion:</td>
      <td><input name="txt_seccion" type="text" id="txt_fechaNacimiento"
      		"/></td>
    </tr>
    <tr>
      <td bgcolor="#CCCCCC">Cargo:</td>
      <td><select name="selec_cargo" id="select">
        
        <option value="JP">JP</option>
        <option value="LT">LT</option>
        <option value="Dise&ntilde;ador">Dise&ntilde;ador</option>
        <option value="Programador">Programador</option>
        <option value="Analista">Analista</option>
      </select></td>
    </tr>
    <tr>
      <td bgcolor="#CCCCCC">Correo:</td>
      <td><input name="txt_correo" type="text" id="txt_nombres"
      		"></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input name="btn_grabar" type="submit" id="btn_grabar" value="Agregar">
      <input name="btn_limpiar" type="reset" id="btn_limpiar" value="Limpiar"></td>
    </tr>
    <%if(mensaje!=null){ %>
    <%=mensaje %>
    <%} %>
  </table>
</form>

</body>
</html>