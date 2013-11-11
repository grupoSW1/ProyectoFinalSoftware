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
.style3 {	color: #FFFFFF;
	font-weight: bold;
	font-size: 24px;
}
.style4 {color: #FFFFFF}
body {
	background-color: #A31E3A;
}
body,td,th {
	font-size: small;
}
-->
</style>
</head>
<body>
<p>
  <%@ page import="bean.UserBean" %>    
<% UserBean objBean=(UserBean)session.getAttribute("user"); %>
<table width="92%" border="0" align="center">
     <tr>
       <td colspan="2" align="center" bgcolor="#EEF0EF"><h2>
         <script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0','width','876','height','147','src','flash/flash1','quality','high','pluginspage','http://www.macromedia.com/go/getflashplayer','movie','flash/flash1' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="1190" height="130">
           <param name="movie" value="flash/flash1.swf">
           <param name="quality" value="high">
           <param name="wmode" value="opaque">
           <param name="SCALE" value="exactfit">
           <embed src="flash/flash1.swf" width="1190" height="130" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" wmode="opaque" scale="exactfit"></embed>
         </object></noscript>
       </h2></td>
  </tr>
     <tr>
       <td width="15%" rowspan="2" align="left" valign="top" ><table width="100%" border="0" bgcolor="#000000">
         <tr>
           <td><img src="img2/oper.fw.png" width="190" height="50"></td>
         </tr>
     </table>
         <table width="100%" height="218" border="0" align="center" bgcolor="#A31E3A">
           <tr>
             <td height="52"><a href="subirArchivo.jsp?usuario=<%= objBean.getUsuario() %>"><img src="img2/img_enviarArch_Usu.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
           <tr>
             <td height="52"><a href="listarArchivosUsu"><img src="img2/img_MostrarArch_Usu.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
           <tr>
             <td height="52"><a href="mostrarFechas"><img src="img2/img_fechPre_Usu.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
           <tr>
             <td height="52"><a href="login.jsp"><img src="img2/img_salir1.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
         </table></td>
       <td width="85%" bgcolor="#A31E3A"><h3 align="center" class="style3">BIENVENIDO USUARIO:<%= objBean.getNombre() %></h3>
         <table width="89%" border="0" align="center">
           <tr>
             <td height="238" bgcolor="#A31E3A"><img src="img2/img_cli.fw.png" width="612" height="181" border="0"><img src="img2/ing_clie.fw.png" width="185" height="219"></td>
           </tr>
       </table></td>
     </tr>
     <tr>
       <td height="76"><img src="img2/img_1.fw.png" width="1040" height="70"></td>
     </tr>
</table>
</body>
</html>