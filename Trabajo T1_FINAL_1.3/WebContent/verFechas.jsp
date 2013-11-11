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
<%@ page import="bean.FechaBean" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<% SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");%>

<% List<FechaBean> fechas= (List<FechaBean>)request.getAttribute("fecha"); %>
<% String mensaje=(String)request.getAttribute("mensaje"); %>


<body>
<table width="104%" border="0" align="center">
     <tr>
       <td colspan="2" align="center" bgcolor="#EEF0EF"><h2>
         <script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0','width','780','height','130','src','flash/flash1','quality','high','pluginspage','http://www.macromedia.com/go/getflashplayer','movie','flash/flash1' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="1190" height="130" align="middle">
           <param name="movie" value="flash/flash1.swf">
           <param name="quality" value="high">
           <param name="wmode" value="opaque">
           <embed src="flash/flash1.swf" width="1190" height="130" align="middle" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" wmode="opaque"></embed>
         </object></noscript>
       </h2></td>
     </tr>
     
     <tr>
       <td width="19%" align="left" valign="top">
       
       <table width="100%" border="0" bgcolor="#A31E3A">
           <tr>
             <td><img src="img2/oper.fw.png" alt="" width="190" height="50" align="middle"></td>
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
         
       </table></td>
       
       
       <td width="81%">
       
      
       
 
 <%if(fechas.size()>0){%>


 <table width="100%" border="1">
  <tr>
    <td width="10%"><h3><strong>N&deg;</strong></h3></td>
    <td width="19%"><h3><strong>Fecha</strong></h3></td>
    <td width="71%"><h3><strong>Descripcion</strong></h3></td>
  </tr>
  	<%for(FechaBean fecha : fechas){ %>
  <tr>
    <td><%= fecha.getIdFecha() %></td>
    <td> <%=format.format(fecha.getFecha()) %></td>
    <td> <%=fecha.getDescripcion() %> </td>
  </tr>
  	<% } %>
</table>

  <% }else{%>

    	<div align="center"><%=mensaje %> </div>

  <%} %>
</td>
     <tr>
       <td align="center">&nbsp;</td>
       <td align="center"><img src="img2/img_1.fw.png" width="1040" height="70" align="middle"></td>
     </tr>
</table>
</body>
</html>
</html>
