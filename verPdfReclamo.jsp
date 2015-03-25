<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page language="java" isThreadSafe="true" contentType="text/html; charset=ISO-8859-1"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println("path:  " + path);
System.out.println("basePath:  " + basePath);
 request.getSession().removeAttribute("carpeta");
 request.getSession().setAttribute("carpeta","Reclamos");
%>
<% String pathB=basePath+"/pdfpublica/PdfAction.do?method=obtenerPdfD";%>

<html>
  <head>
		<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  </head>

<BODY>
<table width="99%"  border="0" cellspacing="0" cellpadding="0">
<iframe frameborder="0" src="<%=pathB%>" height="700" width="100%" style=" overflow: hidden" ></iframe>
</table>
</BODY>
</html>
