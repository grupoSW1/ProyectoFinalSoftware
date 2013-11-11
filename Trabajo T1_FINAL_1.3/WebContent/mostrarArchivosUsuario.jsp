<%@ page language="java" contentType="text/html; charset=iso-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Insert title here</title>
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script><style type="text/css">
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


<table width="104%" border="0">
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
     <tr>
       <td width="17%" align="left" valign="top">

         <table width="100%" border="0" bgcolor="#A31E3A">
            <tr>
           <td bgcolor="#A31E3A"><img src="img2/oper.fw.png" width="190" height="50" align="middle"></td>
        	</tr>
           <tr>
             <td><a href="subirArchivo.jsp"><img src="img2/img_enviarArch_Usu.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
           <tr>
             <td><a href="listarArchivosUsu"><img src="img2/img_MostrarArch_Usu.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
           <tr>
             <td><a href="mostrarFechas"><img src="img2/img_fechPre_Usu.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
           <tr>
             <td><a href="login.jsp"><img src="img2/img_salir1.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
         </table>
	   
	   </td>
       <td width="83%"><p><%= mensaje %></p>
         <table width="100%" border="1">
           <tr>
    <td width="6%">N&deg;</td>
    <td width="15%">Fecha</td>
    <td width="62%">Nombre</td>
    <td width="9%">&nbsp;</td>
    <td width="8%">&nbsp;</td>
  </tr>
  <tr>
    <td>1</td>
    <td>12/12/2013</td>
    <td>Enunciado del trabajo</td>
    <td><a href="D:\data\LYSM.docx" target="_blank">Descargar</a></td>
  </tr>
</table>
<p></p></td>
     </tr>
     <tr>
       <td>&nbsp;</td>
       <td><img src="img2/img_1.fw.png" width="1040" height="70"></td>
     </tr>
</table>
</body>
</html>
</html>