
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
</head>

<body>

<p>
  
    <% String mensaje=(String)request.getAttribute("mensaje"); %>
   
    
<form action="${pageContext.request.contextPath}/mongo" method="post" enctype="multipart/form-data">
  
  
  <table width="100%" border="0">
     <tr>
       <td height="137" colspan="2" align="center"><h2><strong>
         <script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0','width','780','height','130','src','file:///C|/Users/CarlosVictor/Desktop/PROYECTO_T1/Proyec_T1/src/flash/flash1','quality','high','pluginspage','http://www.macromedia.com/go/getflashplayer','movie','file:///C|/Users/CarlosVictor/Desktop/PROYECTO_T1/Proyec_T1/src/flash/flash1' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="780" height="130">
           <param name="movie" value="file:///C|/Users/CarlosVictor/Desktop/PROYECTO_T1/Proyec_T1/src/flash/flash1.swf">
           <param name="quality" value="high">
           <embed src="file:///C|/Users/CarlosVictor/Desktop/PROYECTO_T1/Proyec_T1/src/flash/flash1.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="780" height="130"></embed>
         </object></noscript>
       </strong></h2></td>
     </tr>
     <tr>
       <td width="17%" align="left" valign="top"><table width="61%" border="0">
         <tr>
           <td><img src="file:///C|/Users/CarlosVictor/Desktop/PROYECTO_T1/Proyec_T1/src/img/oper.fw.png" width="194" height="32"></td>
         </tr>
       </table>
         <table width="88%" border="0">
           <tr>
             <td><a href="subirArchivo"><img src="file:///C|/Users/CarlosVictor/Desktop/PROYECTO_T1/Proyec_T1/src/img2/img_enviarMensaje_Usu.fw.png" width="200" height="50" border="0"></a></td>
           </tr>
           <tr>
             <td><a href="listarArchivosUsu"><img src="file:///C|/Users/CarlosVictor/Desktop/PROYECTO_T1/Proyec_T1/src/img2/img_MostrarArch_Usu.fw.png" width="200" height="50" border="0"></a></td>
           </tr>
           <tr>
             <td><a href="mostrarFechas"><img src="file:///C|/Users/CarlosVictor/Desktop/PROYECTO_T1/Proyec_T1/src/img2/img_fechPre_Usu.fw.png" width="200" height="50" border="0"></a></td>
           </tr>
           <tr>
             <td><a href="login.jsp"><img src="file:///C|/Users/CarlosVictor/Desktop/PROYECTO_T1/Proyec_T1/src/img2/img_Salir.fw.png" width="200" height="50" border="0"></a></td>
           </tr>
           <tr>
             <td>&nbsp;</td>
           </tr>
         </table>  
         <p>&nbsp;</p>
         <p>&nbsp;</p>
       </td>
       <td width="83%"><p>En esta secci&oacute;n podra subir los archivos que les corresponde subir. Tomar precaucion al momento de subir sus archivos y revise correctamente antes de enviar</p>
         <p>Cargar Archivo:</p>
         <input type="file" name="Cargar Archivo"/>
         <p>
           <input type="submit" name="Subir Archivo" value="Subir Archivo"/>
       </p>
       <p><%if(mensaje!=null){ %>
       			<%=mensaje %>
       		<%} %>
       </p>
       </td>
     </tr>

     <tr>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
     </tr>
  </table>
   
    </form>
    





</body>
</html>