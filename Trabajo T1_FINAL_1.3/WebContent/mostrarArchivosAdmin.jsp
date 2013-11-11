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
	color: #FFF;
}
body {
	background-color: #A31E3A;
}
-->
</style></head>
<body>
<%String mensaje=(String)request.getAttribute("mensaje"); %>


<table width="85%" border="0" align="center">
     <tr>
      <td colspan="2" align="center" bgcolor="#EEF0EF"><h2>
        <script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0','width','780','height','130','src','flash/flash1','quality','high','pluginspage','http://www.macromedia.com/go/getflashplayer','movie','flash/flash1' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="1190" height="130">
          <param name="movie" value="flash/flash1.swf">
          <param name="quality" value="high">
          <param name="wmode" value="opaque">
          <embed src="flash/flash1.swf" width="1190" height="130" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" wmode="opaque"></embed>
        </object></noscript>
      </h2></td>
     </tr>
     <tr>
       <td width="16%" align="left" valign="top">
	   
	   <table width="100%" border="0" bgcolor="#000000">
         <tr>
           <td bgcolor="#A31E3A"><img src="img2/oper.fw.png" width="190" height="50" align="middle"></td>
         </tr>
       </table>
         <table width="100%" border="0" bgcolor="#A31E3A">
            <tr>
             <td><a href="listarAlumnos"><img src="img2/img_al.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
           <tr>
             <td><a href="listarArchivosAdmi"><img src="img2/img_arch.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
           <tr>
             <td><a href="listarFechas"><img src="img2/img_fecha.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
           <tr>
             <td><a href="login.jsp"><img src="img/img_salir.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
         </table>
	   
	   </td>
       <td width="84%"><p><%= mensaje %></p><table width="100%" border="1">
  <tr>
    <td width="5%"><h3>N&deg;</h3></td>
    <td width="14%"><h3>Codigo</h3></td>
    <td width="12%"><h3>Nombre</h3></td>
    <td width="16%"><h3>Grupo</h3></td>
    <td width="29%"><h3>Seccion</h3></td>
    <td width="24%"><h3>&nbsp;</h3></td>
    </tr>
  <tr>
    <td>1</td>
    <td>10222</td>
    <td>Erika</td>
    <td>grupo1</td>
    <td>32E</td>
    <td><a href="pruebaDescarga.jsp">Mostrar descargas</a></td>
  </tr>
  <tr>
    <td>2</td>
    <td>10333</td>
    <td>Diego</td>
    <td>grupo2</td>
    <td>32E</td>
    <td><a href="pruebaDescarga.jsp">Mostrar descargas</a></td>
  </tr>
</table></p>
<p>&nbsp;</p></td>
     </tr>
     <tr>
       <td>&nbsp;</td>
       <td><img src="img2/img_1.fw.png" width="1040" height="70"></td>
     </tr>
</table>

</body>
</html>
</html>
