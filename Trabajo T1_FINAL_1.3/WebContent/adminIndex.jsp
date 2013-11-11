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
.style1 {color: #FFFFFF}
.style3 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 24px;
}
body {
	background-color: #A31E3A;
}
-->
</style>
</head>
<body >
<%@ page import="bean.UserBean" %>
<% UserBean objBean=(UserBean)session.getAttribute("user"); %>


<table width="90%" height="660" border="0" align="center" >
<tr>
       <td colspan="2" align="center"></td>
     </tr>
     <tr>
       <td height="149" colspan="2" align="center" bgcolor="#EEF0EF"><h2>
         <script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0','width','729','height','130','src','flash/flash1','quality','high','pluginspage','http://www.macromedia.com/go/getflashplayer','movie','flash/flash1' ); //end AC code
         </script>
         <noscript>
         <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="1190" height="150" align="middle">
           <param name="movie" value="flash/flash1.swf">
           <param name="quality" value="high">
           <param name="wmode" value="opaque">
           <embed src="flash/flash1.swf" width="1190" height="150" align="middle" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" wmode="opaque"></embed>
         </object>
         </noscript>
       </h2></td>
     </tr>
     <tr>
       <td width="17%" height="500"  align="left" valign="top">
       <table width="100%" border="0" bgcolor="#A31E3A">
         <tr>
             <td><img src="img2/oper.fw.png" alt="" width="190" height="50" align="middle"></td>
         </tr>
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
           <tr>
           <td><a href="ayuda.jsp"> Ayuda</a></td>
           </tr>
           
       </table>
       <td width="83%" >
       <table width="92%" height="451" border="0" align="center" bgcolor="#000000">
         <tr>
           <td height="369" bgcolor="#A31E3A"><p align="center"><span class="style3">BIENVENIDO ADMINISTRADOR:</span> :<span class="style3"><%= objBean.getNombre() %></span></p>
             <table width="100%" border="0">
               <tr>
                 <td width="21%">&nbsp;</td>
                 <td width="53%" rowspan="3"><table width="100%" border="0">
                   <tr>
                     <td height="286"><img src="img2/img2.fw.png" width="878" height="150" align="middle"><img src="img2/administracion-de-la-herencia.png" width="200" height="179" align="top"></td>
                   </tr>
                 </table></td>
                 <td width="26%">&nbsp;</td>
               </tr>
               <tr>
                 <td>&nbsp;</td>
                 <td>&nbsp;</td>
               </tr>
               <tr>
                 <td>&nbsp;</td>
                 <td>&nbsp;</td>
               </tr>
             </table></td>
         </tr>
		 <tr>
           <td height="76" bgcolor="#A31E3A"><img src="img2/img_1.fw.png" width="1040" height="70"> </td>
         </tr>
       </table></td>
     </tr>
   </table>

</body>
</html>
</html>
</html>
