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
	font-size: medium;
}
body {
	background-color: #A31E3A;
}
-->
</style></head>
<body>

<p>
  
    <% String mensaje=(String)request.getAttribute("mensaje"); %>
   
    

  
  
 <table width="95%" border="0" align="center">
     <tr>
<td colspan="2" align="center" bgcolor="#EEF0EF"><h2>
  <script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0','width','876','height','147','src','flash/flash1','quality','high','pluginspage','http://www.macromedia.com/go/getflashplayer','movie','flash/flash1' ); //end AC code
  </script>
  <noscript>
  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="1190" height="130">
    <param name="movie" value="flash/flash1.swf">
    <param name="quality" value="high">
    <param name="wmode" value="opaque">
    <param name="SCALE" value="exactfit">
    <embed src="flash/flash1.swf" width="1190" height="130" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" wmode="opaque" scale="exactfit"></embed>
  </object>
  </noscript>
</h2></td>
     </tr>
     <tr>
       <td width="15%" align="left" valign="top">
       <table width="100%" border="0" align="center" bgcolor="#A31E3A">
         <tr>
             <td><img src="img2/oper.fw.png" alt="" width="190" height="59" align="middle"></td>
          </tr>
           <tr>
             <td><a href="subirArchivo.jsp"><img src="img2/img_enviarArch_Usu.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
           <tr>
             <td><a href="listarArchivosUsu"><img src="img2/img_MostrarArch_Usu.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
           <tr>
             <td><a href="mostrarFechas"><img src="img2/img_fechPre_Usu.fw.png" width="190" height="59" border="0" align="middle"></a></td>
           </tr>
           <tr>
             <td><a href="login.jsp"><img src="img2/img_salir1.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
       </table>
       </td>
       
       <td width="85%" align="center"><h3>En esta secci&oacute;n podra subir los archivos que les corresponde subir. Tomar precaucion al momento de subir sus archivos y revise correctamente antes de enviar</h3>   <h3>Cargar Archivo:</h3>
         <form action="${pageContext.request.contextPath}/subirArchivo" method="post" enctype="multipart/form-data">
      
         
         <input type="file" name="Cargar Archivo"/>
         <p>
           <input type="submit" name="Subir Archivo" value="Subir Archivo"/>
       </p>
       <p> 
         <%if(mensaje!=null){ %>
       			<%=mensaje %>
       		<%} %>
       </p>
       </form>
       </td>
       
     </tr>

     <tr>
       <td>&nbsp;</td>
       <td><img src="img2/img_1.fw.png" width="1040" height="70" align="middle"></td>
     </tr>
   </table>
   

    





</body>
</html>