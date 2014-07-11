
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
            HttpSession sesion = request.getSession(true);
            sesion.invalidate();
        %>
         <meta http-equiv="refresh" content="0; url=index.jsp">
    </body>
</html>
