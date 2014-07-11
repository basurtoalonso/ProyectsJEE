      <%
            HttpSession sesion = request.getSession(false);
            sesion.getAttribute("username");
        %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>       
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
            <%@include file = "/WEB-INF/jspf/styles.jspf" %>
        <%@include file = "/WEB-INF/jspf/javascript.jspf" %>

<script> 
$(document).ready(function(){	
	$('#jalert').click(function validarForm() {
	     if(username.value.length===0 && password.value.length===0) { 
	     jAlert("INTRODUCE CAMPOS ¬¬", "[MessageError]");
		 return false;
	     }
		 
		 else if(username.value.length===0) { 
	     jAlert("INTRODUCE USERNAME ¬¬", "[MessageError]");
		 return false; 
	     }
		
		 else if(password.value.length===0) { 
	     jAlert("INTRODUCE PASSWORD ¬¬", "[MessageError]");
		 return false; 
	     }
		 
		 else if(password.value.length>4) {
	     jAlert("Introduce un Password de 4 caracteres ¬¬", "[MessageError]");
		 return false; 
	     }		 
	});
	return true;	
});
</script>


<script language='javascript'>
var txt="Application Web ";
var espera=100;
var refresco=null;
function rotulo_title() {
document.title=txt;
txt=txt.substring(1,txt.length)+txt.charAt(0);
refresco=setTimeout("rotulo_title()",espera);}
rotulo_title();
</script>

</head>

<style type="text/css">
.Estilo4 {color: #FFFFFF}
.Estilo5 {color: #990000}
</style>
<BR>
<BR>
<BR>
<BR>
<BR>
<BR>

<body background="fondos/f1.png">
<center>
<div id="container1">
<div id="container2">
<h4 class="Estilo4"><br><center>INICIAR SESIÓN</center></h4><br>
<p><center><img style="border:1px solid #gggggg;" src="resources/imag/candado.png" width="81" height="80" /></center></p>
  <p>
<BR>


<center>
<form method="get" action="ServletAutentica" onSubmit="return validarForm(this);">
<table width="302" height="141" style="background:#CCCCCC; border:2px solid #666666; letter-spacing:normal">

<td width="142" height="31">Nombre De Usuario</td>
<td width="146"><input name="username" type="text" id="username" size="20" placeholder="            Username"></td>

<tr>
<td height="33">Password De Usuario</td>
<td><input name="password" type="password" id="password" size="20" placeholder="            Password"></td>
</tr>

<tr>
 <tr>
     <td height="26" alig n='center'><input name="entra" type="submit" class="acept" id="jalert" value="ENTRAR"><td>
<input type="reset" value="LIMPIAR" class="cansel">
		

<tr>
<td colspan="2"><a href="registro.jsp?&keepThis=true&TB_iframe=true&height=320&width=350"title="Registro De Usuario"class="thickbox"> <center><span class="Estilo5"><font class=\"content\">Identificarse</font></span></center></a></td>
 </tr>
		
		
</table>
</form>
<br>

</center>
</div>
</div>
</center>
</html>