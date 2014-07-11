
<%-- Importaciones que son necesarias para que se muestre el JSP --%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.*" %>
<%@page import="Entities.*" %>
<%@page import="java.util.*" %>

<%-- Obtenemos el id o el id del usuario que deseamos modificar o actualizar --%>
<%
    Usuario u = ControlDB.obtenerUsuario(Integer.parseInt(request.getParameter("id")));
%>

<html>
    <head>
        <meta name=viewport content="width=device-width">
        <meta http-equiv="X-UA-Compatible" content="IE=5">
        <meta http-equiv="Content-Language" content="es-mx"> 
    </head>
    <body>

        <form  method="post" action="controllerUpdate">     
       
            <table width="365" border="1" cellpadding="1" style="background:#CCCCCC; border:1px solid #999999; letter-spacing:normal;">
                <td width="139">Id:</td>
                <td width="208"><input name="id" id="id"  type="text" value="<%= u.getId()%>"  size="32" readonly /></td>				
                </tr>
                <tr>
                <td>Username:</td>
                <td> <input name="username" id="username"  type="text" value="<%= u.getUsername()%>"  size="32"/></td>
                </tr>
                <tr>
                <td>Password:</td>
                <td> <input name="password" id="password" type="text" value="<%= u.getPasword()%>" size="32" /></td>
                </tr>
                <tr>
                <td>Nombre Del Usuario:</td> 
                <td> <input name="nombres" id="nombres" type="text" value="<%= u.getNombres()%>" size="32"/></td>
                </tr>
                <tr>
                <td>Apellidos Del Uusario:</td> 
                <td> <input name="apellidos" id="apellidos" type="text" value="<%= u.getApellidos()%>"  size="32" /></td>
                </tr>
                <tr>
                <td>Email De Usuario:</td>
                <td> <input name="email" id="email" type="text" value="<%= u.getEmail()%>" size="32"  /></td>
                </tr>
                <tr>
                <td>Telefono Del Usuario: </td>
                <td> <input name="telefono" id="telefono" type="text"  value="<%= u.getTelefono()%>"  size="32"/></td>
                </tr>
                <tr>
                <td>C.P:</td>
                <td><input name="cp" id="cp" type="text" value="<%= u.getCp()%>"  size="32" /></td>
                </tr>
                <tr>
                <td>Domicilio:</td>
                <td><input name="domicilio" id="domicilio" type="text"  value="<%= u.getDomicilio()%>" size="32"/></td>
                </tr>
                <tr>
                <td colspan="2"><center>
                  <h3 class="Estilo4"><tt>EXAMINAR FOTOGRAF&Iacute;A... </tt></h3>
                   </center></td>
                </tr>
                <tr>
                <td colspan="2"><input name="fotop" type="file" id="fotop" value=""></td>
                </tr>

                <tr>
                <td>&nbsp;</td>    
               <td><input name="actualizar" type="submit" id="actualiza" value="Actualizar" onClick="self.parent.tb_remove();" /></td>
               
                <!--<td><input name="actualiza" type="submit" id="actualiza" value="Actualizar"/></td> -->
                </tr>
            </table>
        </form>
    </body>
</html>