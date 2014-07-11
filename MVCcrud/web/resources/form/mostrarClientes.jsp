<%-- Importaciones que son necesarias para que se muestre el JSP --%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.*" %>
<%@page import="Entities.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

<html>
    <head>
        
<link type="text/css" href="resources/ui/css/smoothness/jquery-ui-1.8.23.custom.css" rel="stylesheet" />
<link type="text/css" href="resources/ui/css/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="resources/ui/css/master.css" rel="stylesheet" />

<script type="text/javascript" src="resources/ui/js/jquery_ui/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="resources/ui/js/jquery_ui/jquery-ui-1.8.23.custom.min.js"></script>
<script type="text/javascript" src="resources/ui/js/bootstrap/bootstrap.min.js"></script>

<script type="text/javascript" src="resources/ui/js/jquery-validation-1.10.0/dist/jquery.validate.min.js"></script>
<script type="text/javascript" src="resources/ui/js/jquery-validation-1.10.0/lib/jquery.metadata.js"></script>
<script type="text/javascript" src="resources/ui/js/jquery-validation-1.10.0/localization/messages_es.js"></script>

<script type="text/javascript" src="resources/ui/js/mainJavaScript.js"></script>


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    
</head>
<body>
    
    <div class="hide" id="agregarUser" Title="Agregar Usuario">
	    	<form action="" method="post" id="formUsers" name="formUsers">
	    		<fieldset id="ocultos">
	    			<input type="hidden" id="accion" name="accion" class="{required:true}"/>
	    			<input type="hidden" id="id_user" name="id_user" class="{required:true}" value="0"/>
	    		</fieldset>
				<fieldset id="datosUser">
					<p>Username</p>
					<span></span>
					<input type="text" id="usr_nombre" name="usr_nombre" placeholder="Nombre Completo" class="{required:true,maxlength:120} span3"/>
					<p>Password</p>
					<span></span>
					<input type="text" id="usr_puesto" name="usr_puesto" placeholder="puesto que desempeña" class="{required:true,maxlength:80} span3"/>
					<p>Nombres</p>
					<span></span>
					<input type="text" id="usr_nick" name="usr_nick" placeholder="nickname" class="{required:true,maxlength:25} span3"/>
                                        
                                        <p>Apellidos</p>
					<span></span>
					<input type="text" id="usr_nick" name="usr_nick" placeholder="nickname" class="{required:true,maxlength:25} span3"/>

                                        <p>Email</p>
					<span></span>
					<input type="text" id="usr_nick" name="usr_nick" placeholder="nickname" class="{required:true,maxlength:25} span3"/>

                                        <p>Telefono</p>
					<span></span>
					<input type="text" id="usr_nick" name="usr_nick" placeholder="nickname" class="{required:true,maxlength:25} span3"/>

                                        <p>CP</p>
					<span></span>
					<input type="text" id="usr_nick" name="usr_nick" placeholder="nickname" class="{required:true,maxlength:25} span3"/>

                                        <p>Domiciolio</p>
					<span></span>
					<input type="text" id="usr_nick" name="usr_nick" placeholder="nickname" class="{required:true,maxlength:25} span3"/>

				<fieldset id="btnAgregar" style="text-align:center;">
					<input type="submit" id="continuar" value="Continuar" />
				</fieldset>

				<fieldset id="ajaxLoader" class="ajaxLoader hide">
					<img src="resources/ui/images/default-loader.gif">
					<p>Espere un momento...</p>
				</fieldset>
			</form>
	    </div>
    
    <center>
        
        	<div id="dialog-borrar" title="Eliminar registro" class="hide">
	          <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Este registro se borrará de forma permanente. ¿Esta seguro?</p>
		</div>

        <div id="wraper">
            <section id="content">
                
                <div id="btnAddUser" class="center addUser">
                    <button id="goNuevoUser" class="btn btn-inverse btn-small">
                        <i class="icon-plus"></i> Agregar Usuario</button>
                </div>
                
                <!--<div id="listaOrganizadores">-->

                    <!--<table  id="listadoUsers" class="table table-striped table-bordered table-hover table-condensed">-->
                    <table id="contador" border="2" cellpadding="2" bordercolor="#666">
                        <TR><TD><p align="center">Id</P></TD>
                        <TD><p align="center">Username</P></TD>
                        <TD><p align="center">Password</P></TD>
                        <TD><p align="center">Nombres</P></TD>
                        <TD><p align="center">Email</P></TD>
                        <TD><p align="center">Borrar</P></TD>
                        <TD><p align="center">Actualizar</P></TD>      
                        </TR>

                        <tr>
                            <%-- Lista de todos los usuarios --%>
                            <%
                                
                                
                                //if((request.getParameter("search") != null)){
                                //String search=request.getParameter("search");

                                //ArrayList<Usuario> lista = ControlDB.searchUser(search);
                                ArrayList<Usuario> lista = ControlDB.mostrarUsuarios();
                                for (Usuario u : lista) {
                            %>

                        <tr style="background: ${((contador.index % 2) == 0) ? '#D9E5F2' : '#ABC6E2'}">
                        <td><%= u.getId()%></td>
                        <td><%= u.getUsername()%></td>
                        <td><%= u.getPasword()%></td>
                        <td><%= u.getNombres()%></td>
                        <td><%= u.getEmail()%></td>
                        
                         <%--<c:forEach items="${Entities.Usuario}" var="lista" varStatus="loop">
                            <tr style="background: ${((loop.index % 2) == 0) ? '#D9E5F2' : '#ABC6E2'}">
                            <td><b><c:out value="${lista.id}" /></b></td>
                            <td><b><c:out value="${lista.username}" /></b></td>
                            <td><b><c:out value="${lista.pasword}" /></b></td>
                            <td><b><c:out value="${lista.nombres}" /></b></td>
                            <td><b><c:out value="${lista.email}" /></b></td>
                            </c:forEach>--%>
                            
                        <!--borrar-->   
                        <td><center><a href="controllerDelete?id=<%= u.getId()%>"><img src="resources/img/borrar.jpg" alt="Header image" width="25" height="25" border="0"/></a></center></td>         
                        <!--actualizar--> 
                        <td><center><a href="update_User.jsp?id=<%= u.getId()%>&keepThis=true&TB_iframe=true&height=355&width=350" title="Actualizar Cliente" class="thickbox"><img src="resources/img/actu.png" alt="Header image" width="30" height="30" border="0"/></a></center></td>    
                        </tr>
                        <%
                }
                //}
%>
                    </table>

                <!--</div>-->

            </section>
        </div>
    </center>
                <footer>
	        Powered by Victor Basurto Alonso || 2014
		</footer>
</body>
</html>




