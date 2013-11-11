<%@ page language="java" contentType="text/html; charset=iso-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Insert title here</title>
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<style type="text/css">
<!--
body,td,th {
	font-size: medium;
}
-->
</style></head>
<body>
<p>
  <% String mensaje=(String)request.getAttribute("mensaje"); %>
</p>
<table width="99%" border="0" align="center">
  <tr>
    <td colspan="2" align="center"><h1>
      <script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0','width','709','height','130','src','flash/flash1','quality','high','pluginspage','http://www.macromedia.com/go/getflashplayer','movie','flash/flash1' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="1190" height="130" align="middle">
        <param name="movie" value="flash/flash1.swf">
        <param name="quality" value="high">
        <param name="wmode" value="opaque">
        <embed src="flash/flash1.swf" width="1190" height="130" align="middle" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" wmode="opaque"></embed>
      </object></noscript>
    </h1></td>
  </tr>
</table>
<form name="form1" method="post" action="login">
  <table width="31%" border="0" align="center">
   
    <tr>
      <td height="21">&nbsp;</td>
      <td height="21">Usuario:</td>
    </tr>
    <tr>
      <td width="25%"><img src="img2/imagenusuario.png" width="20" height="23" align="middle" longdesc="usuarioIndex.jsp"></td>
      <td width="75%"><input type="text" name="txt_usuario" id="txt_usuario">      </td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>Clave:</td>
    </tr>
    <tr>
      <td><img src="img2/LLAVE CABEZA DE PLASTICO R52 AMARILLA-600x600.PNG" width="20" height="23" align="top" longdesc="usuarioIndex.jsp"></td>
      <td><input type="password" name="txt_contraseña" id="txt_contraseña">      </td>
    </tr>
    <tr>
      <td><input type="submit" name="button" id="button" value="Ingresar">      </td>
      <td><a href="recuperarContrasena.jsp">&iquest;Olvidaste tu contrase&ntilde;a?</a></td>
    </tr>
    <tr>
      <td height="20" colspan="2"><%if(mensaje!=null){ %>
        <%=mensaje %>
        <%} %>      </td>
    </tr>
    <tr>
      <td  colspan="2"><a href="ayuda.jsp">Ayuda</a></td>
    </tr>
  </table>
  <table width="80%" border="0" align="center">
    <tr>
      <td height="61"> <h4><img src="img2/img_1.fw.png" alt="" width="1040" height="70" vspace="5" align="middle"></h4>
      </td>
    </tr>
  </table>

</form>
</body>
</html>