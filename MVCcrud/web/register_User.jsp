
<html>
    <head><title>Administrador</title>
        <%@include file = "/WEB-INF/jspf/styles.jspf" %>
        <%@include file = "/WEB-INF/jspf/javascript.jspf" %>
        <script>
            $(document).ready(function() {
                $("#mo").click(function() {
                    $("#div").fadeOut("slow");
                });
                $("#ocu").click(function() {
                    $("#div").slideUp("slow");
                });
            });
        </script>
    </head>
    <body bgcolor="FAFAFA">

        <%
            HttpSession sesion = request.getSession(false);
            if (sesion.getAttribute("username") != null || (sesion.getAttribute("password") != null)) {
        %>

        <div id="containerr"> 
            <%@include file = "/WEB-INF/jspf/navbar.jspf" %>
            <div id="about">
                <div align="center"><h4><font color="#000000">REGISTRAR USUARIO</font></h4></div>

                <%@include file="resources/form/registro_Usuario.jsp" %>  

            </div>
            <table id="linkList" width="193" class="" height="200" border="0">
                <td width="181">	    
                    <h3><span><a id="mo" href=""><font color="#ffffff">Administrar Recursos</font></a></span></h3>
                    <ul id="div">	
                        <li><a href="register_User.jsp">Aplicación Web</a></li>
                        <li><a href="register_User.jsp">Registrar Usuario</a></li>
                        <li><a href="Management_User.jsp">Gestión Usuario</a></li>
                        <li><a href="destruyeT.jsp">Cerrar Sesión</a></li>
                        <!--<li><a href="admin_usuarios.jsp">Registrar Cliente</a></li>
                        <li><a href="checarpedidos.php?estado=pendientes">Revisar Pedidos </a></li>
                        <li><a href="pedidosenviados.php?estado=enviados">Pedidos Enviados</a></li>
                        <li><a href="pedidosenviados.php?estado=enviados">Administrar Pedidos</a></li>-->
                        <li><a id="ocu" href="#">Cerrar Menu</a></li>
                    </ul>
                </td>
            </table>
        </div>
<%
}else{
      %>  
      <meta http-equiv="refresh" content="0; url=index.jsp?mensaje=1">
       <%
    }
%>
    </body>
</html>