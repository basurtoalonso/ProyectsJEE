<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<style type="text/css">
#error {
	width: 620px;
	border: 1px #A9A9A9 solid;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	color: #000000;
	font-family: Arial;
	font-size: 12px;
}

#Lyr_Icono_Error{
   position: absolute;
   text-align: left;
   left: 665px;
   top: 145px;
   width: 120px;
   height: 120px;
}

#Lyr_Icono_Error{
   background-color: transparent;
    background-image: url(images/exito.png);
   background-repeat: no-repeat;
}

</style>

<table width="620" bgcolor="#D1D1D1" border="0" class="texto" align="center">
	<tr>
		<td align="center">
			&nbsp;
		</td>
	</tr>
	<div id="Lyr_Icono_Error" title=""></div>
	<tr>
		<td align="justify" width="620px">
		<p>
		Si considera necesario presentar documentación que sustente su reclamo
		lo puede realizar en cualquiera de nuestras agencias, indicando que
		presentó el reclamo por la página web y precisando su número de Folio.
		Para conocer la ubicación de nuestras agencias haga click aquí. Su reclamo
		será atendido dentro de un plazo de 30 días hábiles, salvo en los
		casos de mayor complejidad donde el reclamo podría extenderse hasta 30
		días calendario adicionales. Para consultas comunicarse a nuestra
		Línea Azteca al 613 0004 ó al 0 800 53298  Atentamente, Atención al
		Cliente Banco Azteca del Perú (Incluir Logo del BAZ).
	    </p><br>
		<strong><center><span id="error"><bean:write name="exito" scope="session" filter="false"/></span></center></strong><br>
		</td>
	</tr>
</table>
