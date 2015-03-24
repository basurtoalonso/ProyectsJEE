<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html:html>
<head>
	<script type="text/javascript" src="../js/aclaraciones/validateAclReclamo.js"></script>
	<link href="<html:rewrite page="/style/clases_casoReclamo.css"/>" rel="stylesheet" type="text/css" />

	<script type='text/javascript' src='/eBankingWeb/dwr/util.js'> </script>
	<script type='text/javascript' src='/eBankingWeb/dwr/engine.js'></script>
	<script type='text/javascript' src='/eBankingWeb/dwr/interface/AdministradorDWR.js'></script>

	<script type="text/javascript"> 		
    function asignaIdBienXRec(e){
       //alert("valor Producto: " +e);
       llenaCausas(e);
	   document.getElementById("hiddens").innerHTML='<html:hidden name ="TaCasoForm" property="idBienXRec" styleId="idBienXRec"/>';
	   document.getElementById("idBienXRec").value= e;
    }
  
  	function asignaIdProdXCausa(id){  
	   //alert("valor causa: " +id);
	   document.getElementById("hiddens2").innerHTML='<html:hidden name ="TaCasoForm" property="idProdXCausa" styleId="idProdXCausa"/>';	
	   document.getElementById("idProdXCausa").value = id;
    }
    
    function asignaNaturaleza(id){  
	   //alert("valor naturaleza: " +id);
	   document.getElementById("hiddens3").innerHTML='<html:hidden name ="TaCasoForm" property="naturalezaCaso" styleId="naturalezaCaso"/>';	
	   document.getElementById("naturalezaCaso").value = id;
    }
    
    </script>
</head>

<body>  <!-- onload="limpiar();" -->
	<html:form action="/CasosReclamoAcl" method="POST" onsubmit="return false;" styleId="formulario">
		<html:hidden property="metodo" />
		<html:hidden property="opcion" styleId="opcion" value="guardar" />
		<div id="container">
			<div id="wb_Form_Information">
				<div id="Lyr_Container" title="">
					<%-- <bean:message key="label.nombre"/> --%>

					<div id="wb_Label_Nombre">
						<span id="wb_uid4"><strong>Nombre (s):</strong></span>
					</div>
					<html:text styleClass="Txt_nombre" property="nombre" styleId="nombre" tabindex="1" value="Victor" onkeyup="return validaCadena(this);" />
					<div style="margin-top: 22px; position: absolute;" id="nombreError"></div>

					<div id="wb_Label_ApellidoP">
						<span id="wb_uid4"><strong>Apellido Paterno:</strong></span>
					</div>
					<html:text styleClass="Txt_ApellidoP" property="apePat" styleId="apePat" tabindex="2" value="Basurto" onkeyup="return validaCadena(this);" />
					<div style="margin-top: 72px; position: absolute;" id="aPaternoError"></div>

					<div id="wb_Label_ApellidoM">
						<span id="wb_uid4"><strong>Apellido Materno:</strong></span>
					</div>
					<html:text styleClass="Txt_ApellidoM" property="apeMat" styleId="apeMat" tabindex="3" value="Alonso" onkeyup="return validaCadena(this);" />
					<div style="margin-top: 122px; position: absolute;" id="aMaternoError"></div>

					<div id="wb_Label_NombreTutor">
						<span id="wb_uid4"><strong>Nombre Tutor:</strong></span>
					</div>
					<html:text styleClass="Txt_NombreTutor" property="nombreTutor" styleId="nombreTutor" tabindex="4" value="Fulanito" onkeyup="return validaCadena(this);" />
					<div style="margin-top: 172px; position: absolute;" id="tutorError"></div>

					<div id="wb_Label_Email">
						<span id="wb_uid4"><strong>Correo-E:</strong> </span>
					</div>
					<html:text styleClass="Txt_Email" property="email" styleId="email" tabindex="5" value="basurto_nike10@hotmail.com" />
					<div style="margin-top: 222px; position: absolute;" id="correoError"></div>

					<div id="wb_Label_Direccion">
						<span id="wb_uid4"><strong>Direccion:</strong></span>
					</div>
					<html:text styleClass="Txt_Direccion" property="direccion" styleId="direccion" tabindex="6" value="D.F" />
					<div style="margin-top: 272px; position: absolute;" id="direccionError"></div>

					<div id="wb_Label_Telefono">
						<span id="wb_uid4"><strong>Telefono:</strong></span>
					</div>
					<html:text styleClass="Txt_Telefono" property="telefono" styleId="telefono" tabindex="7" value="5585531963" />
					<div style="margin-top: 322px; position: absolute;" id="telefonoError"></div>

					<!-- ################################ INICIO VALIDACION DE DOCUMENTOS DE IDENTIDAD ################################ -->
					<div id="wb_Label_DocumentoIdentidad">
						<span id="wb_uid4"><strong>Doc. Identidad:</strong></span>
					</div>
					<div id="selectDocumento">
						<select id="identidadText" style="width: 160px"
							onchange="mostrarText(this);" tabindex="8">
							<option value="-1">SELECCIONE</option>
							<option value="1">DNI</option>
							<option value="2">Carnet de Extranjería</option>
							<select>
					</div>
					<span id="identidadCont" style='visibility: hidden'>
				    <html:text styleClass="Txt_Documento" property="identidad" styleId="identidad" value="12345678" onblur="validaIdentidad();"></html:text>
					</span>
					<div style="margin-top: 373px; position: absolute;" id="docIdentidadError"></div>
					<div style="margin-top: 412px; position: absolute;" id="errorIdentidead"></div>
					<div style="margin-top: 412px; position: absolute;" id="errorDni"></div>
					<!-- ################################ FIN VALIDACION DE DOCUMENTOS DE IDENTIDAD ################################ -->

					<div id="wb_Label_DescripcionReclamo">
						<span id="wb_uid4"><strong>Descripción Reclamo:</strong></span>
					</div>
					<html:textarea styleClass="Txt_DescripcionReclamo"
						property="descripcionReclamo" styleId="descripcion" tabindex="16"
						value="Esto es un reclamo..." />
					<div style="margin-top: 535px; margin-left: 320px; position: absolute;"id="descripcionError"></div>

					<div id="wb_Label_BienContratado">
						<span id="wb_uid4"><strong>Bien Contratado:</strong></span>
					</div>
					<div id="selectBien">
					  <html:select onchange="llenaReclamo(this.value);" value="-1" property="bienContratado" styleId="bienContratado" name="TaCasoForm" tabindex="10">
						<html:option value="-1">SELECCIONE BIEN</html:option>
						<html:option value="1">Producto</html:option>
						<html:option value="2">Servicio</html:option>
					  </html:select>
					 <!-- <select disabled="disabled" style="width: 200px"></select> -->
					</div>
					 <div style="margin-top: 38px; margin-left: 338px; position: absolute;" id="bienError"></div>

					<div id="wb_Label_ProductoServicio">
						<span id="wb_uid4"><strong>Tipo De Producto ó Servicio:</strong></span>
					</div>
					<div id="selectProducto">
						<select disabled="disabled" style="width: 200px"></select>
					</div>
				   <div style="margin-top:110px; width: 465px; margin-left:320px; position:absolute;" id="tProdServError"></div> 

					<div id="wb_Label_ProdServic">
						<span id="wb_uid4"><strong>Producto/Servicio:</strong></span>
					</div>
					<div id="selectProdServ">
						<select disabled="disabled" style="width: 200px"></select>
					</div>
					<div style="margin-top: 180px; margin-left: 320px; position: absolute;" id="ProdServError"></div>


					<div id="wb_Label_Causa">
						<span id="wb_uid4"><strong>CAUSA:</strong></span>
					</div>
					<div id="selectCausa">
						<select disabled="disabled" style="width: 200px"></select>
					</div>
					<div style="margin-top: 460px; margin-left: 15px; position: absolute;" id="causaError"></div>

					<div id="wb_Label_Caso">
						<span id="wb_uid4"><strong>Naturaleza Caso:</strong></span>
					</div>
					<div id="selectnaturalezaCaso">
						<select disabled="disabled" style="width: 150px"></select>
					</div>
					<div style="margin-top: 232px; margin-left: 320px; position: absolute;" id="natCasoError"></div>

					<div id="wb_Label_MontoReclamo">
						<span id="wb_uid4"><strong>Monto Recl:</strong></span>
					</div>
					<html:text styleClass="Txt_MontoReclamo" property="montoReclamo" styleId="montoReclamo" value="200" tabindex="14" />
					<div style="margin-top: 283px; margin-left: 320px; position: absolute;" id="montoReclamoError"></div>

					<div id="wb_Label_Pedido">
						<span id="wb_uid4"><strong>Pedido:</strong></span>
					</div>
					<html:textarea styleClass="Txt_Pedido" property="pedido" styleId="pedido" tabindex="15" value="1" />
					<div style="margin-top: 380px; margin-left: 320px; position: absolute;" id="pedidoError"></div>

					<div id="wb_button_registroCaso"><input class="acept" type="button" value="REGISTRAR" onclick="javascript:guardar();"></div>
					<div id="wb_button_limpiar"> <input class="cansel" type="button" value="CANCELAR" onclick="javascript:limpiar();"></div>
				</div>
			</div>
		</div>
		<div id="hiddens"></div>
		<div id="hiddens2"></div>
		<div id="hiddens3"></div>
		<div id="hiddens4"></div>
	</html:form>
</body>
</html:html>
