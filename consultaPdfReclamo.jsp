<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.ArrayList"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println("path consulta:  " + path);
System.out.println("basePath consulta:  " + basePath);
String listaArcB ="";
%>
 <%
 String URL=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath();
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
		<script type="text/javascript">
	
	function irPdf(nombrePara){
		alert("entrando");
		document.getElementById("formpdf").method.value="obtenerPdf";
		document.getElementById("formpdf").folio.value=nombrePara;
		document.getElementById("formpdf").submit();
	}
	</script>
	
  </head>
 <body>
<form id="formpdf" action="/eBankingWeb/pdfpublica/PdfAction.do">
<input type="hidden" name="folio" value="" />
<%
	if(request.getSession().getAttribute("tabla")==null){
	 listaArcB = "";
	 System.out.println("listaArcB:  " + listaArcB);
	 }else{
	 listaArcB = request.getSession().getAttribute("tabla").toString();
	 System.out.println("else listaArcB:  " + listaArcB);
	 }
%>
<%=listaArcB%>
<form>
</body>
</html>
