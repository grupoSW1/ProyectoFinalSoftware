<%@ page language="java" contentType="text/html; charset=iso-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<title>Insert title here</title>
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
<%@ page import="bean.FechaBean" %>
<%@ page import="java.util.List" %>
<% List<FechaBean> fechas= (List<FechaBean>)request.getAttribute("fecha"); %>
<% String mensaje=(String)request.getAttribute("mensaje"); %>

<table width="103%" border="0" align="center" bgcolor="#A31E3A">
      		     <tr>
      		       <td height="132" colspan="4"  align="left" valign="top"><script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0','width','780','height','130','src','flash/flash1','quality','high','pluginspage','http://www.macromedia.com/go/getflashplayer','movie','flash/flash1' ); //end AC code
                   </script>
                     <noscript>
                     <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="1190" height="130" align="middle">
                       <param name="movie" value="flash/flash1.swf">
                       <param name="quality" value="high">
                       <param name="wmode" value="opaque">
                       <embed src="flash/flash1.swf" width="1190" height="130" align="middle" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" wmode="opaque"></embed>
                     </object>
                   </noscript></td>
	       </tr>
      		     <tr>
       <td width="16%" height="209"  align="left" valign="top">
       <table width="100%" border="0" bgcolor="#A31E3A">
          <tr>
             <td><img src="img2/oper.fw.png" alt="" width="190" height="50" align="middle"></td>
           </tr>
           <tr>
             <td><a href="listarAlumnos"><img src="img2/img_al.fw.png" width="190" height="50" border="0"></a></td>
           </tr>
           <tr>
             <td><a href="listarArchivosAdmi"><img src="img2/img_arch.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
           <tr>
             <td><a href="listarFechas"><img src="img2/img_fecha.fw.png" width="190" height="50" border="0" align="middle"></a></td>
           </tr>
           <tr>
             <td><a href="login.jsp"><img src="img/img_salir.fw.png" width="190" height="50" border="0"></a></td>
           </tr>
         </table></td>
       <td width="84%">
       
        <a href="agregarFecha.jsp">Agregar Fecha</a>
        <%if(fechas.size()>0){%>
        <a href="agregarFecha.jsp"></a>
<table width="96%" border="1">
         
     <tr>
           <td width="10%"><h3>N&deg;</h3></td>
           <td width="21%"><h3>Fecha</h3></td>
           <td width="33%"><h3>Descripcion</h3></td>
           <td width="12%"><h3>&nbsp;</h3></td>
           <td width="24%">&nbsp;</td>
        </tr>
         <%for(FechaBean fecha : fechas){ %>
         <tr>
           <td height="23"><%= fecha.getIdFecha() %></td>
           <td><%= fecha.getFecha() %></td>
           <td><%= fecha.getDescripcion() %></td>
           <td><a href="editarFecha?fecha=<%=fecha.getIdFecha()%>">Editar</a></td>
           <td><a href="eliminarFecha?fecha=<%=fecha.getIdFecha()%>">Eliminar</a></td>
         </tr>
           <% } %>
       </table>
<% }else{%>
	    	<div align="center"><%=mensaje %></div>
	  <%} %>
         <p>&nbsp;</p>
<p>&nbsp;</p></td>
     </tr>
     <tr>
       <td>&nbsp;</td>
       <td><img src="img2/img_1.fw.png" width="1040" height="70"></td>
     </tr>
   </table>

</body>
</html>