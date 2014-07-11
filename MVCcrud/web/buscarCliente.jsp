<%-- 
    Document   : mostrarClientes
    Created on : 21/04/2014, 08:02:32 PM
    Author     : Raùl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.*" %> 
<%@page import="Modelo.*" %> 
<%@page import="Entities.*" %>     
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MENU PRINCIPAL</title>
        <!-- Estilos y javaScript de pruebas no existen !-->
        <link rel="stylesheet" type="text/css" href="../css/EstiloEnabezado.css">
        <link rel="stylesheet" type="text/css" href="../css/EstiloClientes.css">
        <link rel="stylesheet" type="text/css" href="../css/EstiloTablas.css">
        <script type="text/javascript" src="../js/jConfirmation.js"></script> 
        
        <script type="text/javascript">
            
        </script>
        
    </head>
    <body>
        <%--<%@include file="Encabezado.jspf"%> --%>
        <div id="menu">
         <nav>
           <ul>
              <a href="menuPrincipal.jsp" title="Pagina De Inicio" <li id="ini" INICIO</li></a>
              <a href="mostrarClientes.jsp" title="Clientes" <li id="cli" CLIENTES</li></a>
              <a href="mostrarProductos.jsp" title="Productos" <li id="pro" PRODUCTOS</li></a>
              <a href="menuPrincipal.jsp" title="Cerrar Sesión" <li id="cs" CERRAR SESIÓN</li></a>
           <ul/>                          
         </nav>
       </div>
        <br>
        <br>
        <br>
        
        <% 

String nombre="";
//String codigoEliminar;
String tipoBuscar="busCliente";


   String varListaBuscar = request.getParameter("lstBuscar"); 

   if(varListaBuscar != null){
	     
	     if(request.getParameter("lstBuscar").equalsIgnoreCase("busCliente")){
	     tipoBuscar="busCliente";	
	      }
	
	     else if(request.getParameter("lstBuscar").equalsIgnoreCase("busCodigo")){
      	     tipoBuscar="busCodigo";
             }
       
            else if(request.getParameter("lstBuscar").equalsIgnoreCase("busRuc")){
      	    tipoBuscar="busRuc";
            }
          
           else {
                tipoBuscar="busCiudad";
           }
           
        }
        
         if((request.getParameter("nomBuscar") != null)){
	         nombre=request.getParameter("nomBuscar").toUpperCase();
	     }	
	     
	     /*if((request.getParameter("eliminar") != null)){  por el momento no interesa
	   	     codigoEliminar=request.getParameter("codigoEliminar");
	     
	         ClienteDAO dao = new ClienteDAO();
	         dao.eliminar(codigoEliminar);	//verificar el metodo eliminar de la class ClienteDAO
	     
	     }*/
	     
	     %>

             <form id="frmCliente" name="frmClientes" method="POST" action="mostrarClientes.jsp">
                 <fieldset id="fieldRadio">
                     <legend> Busqueda por </legend>
                     <select name="lstBuscar" style="float: left; margin-top: 10px;">
                         <option value="busCodigo">Codigo</option> 
                         <option value="busRuc">RUC</option> 
                         <option value="busCliente">Cliente</option> 
                         <option value="busCodigo">Codigo</option> 

                     </select> 
                     
                     <div id="containerTextoBuscar">
                         <input name="nomBuscar" type="text" id="idBuscar" class="campo" required/>
                     </div>
                     
                     <div>
                         <input <%--style="estilo de posisciones de la imagen"--%> src="../img/buscar.jpg" width="45" height="45" type="image" title="Buscar Cliente" id="idBuscar"/>
                     </div>
                 </fieldset> 
                     <br>
                 </form>    
                     
                     <div id="zona-agregar">
                         <a href="agregarCliente.jsp" title="Agregar un nuevo cliente">    
                         <img src="../img/agregar.jpg" width="40" height="40" alt="Agregar un nuevo cliente"></a>
                         &nbsp;
                         <!--invocacion de un servlet llamado (SReporteClientes) donde le pasamos 2 parametros -->
                         <a href="SReporteClientes?varBuscar=<%=tipoBuscar%>&nombre=<%=nombre%>" title="Reporte Clientes">
                         <img src="../img/reporte.jpg" width="52" height="40" alt="Reporte de clientes"></a>
                     </div>
                         
                       <%
                         ClienteDAO dao= new ClienteDAO();
                         List<Usuario> lista =dao.listar(nombre, tipoBuscar);
                         boolean rs_tienedatos = !lista.isEmpty();
                         
                         if(rs_tienedatos){
                         
                         %>
                         
                     <div id="table-acroll" style="float: left; margin-top: 90px;">
                       <div id="fixedY">
                         <table border="1">
                             <thead id="table-head">
                                 <tr>
                                     <th width="7%">ID</th>
                                     <th width="7%">USERNAME</th>
                                     <th width="7%">PASSWORD</th>
                                     <th width="7%">NOMBRES</th>
                                     <th width="7%">APELLIDOS</th>
                                     <th width="7%">EMAIL</th>
                                     <th width="7%">TELEFONO</th>
                                     <th width="7%">CP</th>
                                     <th width="7%">DOMICILIO</th>
                                     <th width="7%"></th>
                                     <th width="7%"></th>
                                 </tr>
                             </thead>
                         </table>
                         </div>
                        
                         <%
                         for(int i=0;  i<=lista.size(); i++){
                            
                         %>
                     
                         <table id="table-clientes" border="1">
                             <tbody>
                                 <tr id="table-body" cellpadding="3" cellspacing="0" dwcopytype="CopyTableRow">
                                        <th width="7%" align="middle"><%=lista.get(i).getId()%></th>
                                    <th width="7%" align="middle"><%=lista.get(i).getUsername()%></th>
                                    <th width="7%" align="middle"><%=lista.get(i).getPasword()%></th>
                                    <th width="7%" align="middle"><%=lista.get(i).getNombres()%></th>
                                    <th width="7%" align="middle"><%=lista.get(i).getApellidos()%></th>
                                      <th width="7%" align="middle"><%=lista.get(i).getTelefono()%></th>
                                    <th width="7%" align="middle"><%=lista.get(i).getEmail()%></th>
                                    <th width="7%" align="middle"><%=lista.get(i).getTelefono()%></th>
                                    <th width="7%" align="middle"><%=lista.get(i).getCp()%></th>
                                    <th width="7%"  align="middle"></th>
                                    <a href="editarCliente.jsp?codigo=<%=lista.get(i).getId()%>" title="Reporte Clientes">
                                    <img src="../img/editar.jpg" width="20" height="20" alt="Editar"></a>
                                    <th width="7%"  align="middle"></th>
                                    <a class="ask-custom" href="mostrarClientes.jsp?codigoEliminar=<%=lista.get(i).getId()%>&nombre=<%=nombre%>" title="Reporte Clientes">
                                    <img src="../img/delete.jpg" width="20" height="20" alt="Eliminar"></a>
                                 </tr>
                               </tbody> 
                         </table>
                           <%
                         }
                         
                        }
                         %>   
              
    </body>
</html>
