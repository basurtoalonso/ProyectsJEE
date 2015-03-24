<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html:html>
  <head> 
    <script type='text/javascript' src="../js/aclaraciones/validateAclConsulta.js"></script>
    <link href="<html:rewrite page="/style/clases_casoConsulta.css"/>" rel="stylesheet" type="text/css"/>
  </head>

   <body onload="limpiar();">
	    <html:form action="/CasosReclamoAcl" scope="request" method="POST" onsubmit="return false;" styleId="formulario">
		<html:hidden property="metodo" />
		<html:hidden property="naturalezaCaso" value="7"/>
		<html:hidden property="opcion" styleId="opcion" value="consultar" />
                       
            <div id="container">
                <div id="wb_Form_Information">
                    <div id="Lyr_Container" title="">

                        <div id="wb_Label_Nombre"><span id="wb_uid4"><strong>Nombre (s):</strong></span></div>
                        <html:text styleClass="Txt_nombre" property="nombre" styleId="nombre" tabindex="1" onkeyup="return validaCadena(this);"/> 
                        <div style="margin-top:22px; position:absolute;" id="nombreError"></div>

                        <div id="wb_Label_ApellidoP"><span id="wb_uid4"><strong>Apellido Paterno:</strong></span></div>
                        <html:text styleClass="Txt_ApellidoP" property="apePat" styleId="apePat" tabindex="2" onkeyup="return validaCadena(this);"/>
                        <div style="margin-top:72px; position:absolute;" id="aPaternoError"></div> 

                        <div id="wb_Label_ApellidoM"><span id="wb_uid4"><strong>Apellido Materno:</strong></span></div>
                        <html:text styleClass="Txt_ApellidoM" property="apeMat" styleId="apeMat" tabindex="3" onkeyup="return validaCadena(this);"/>
                        <div style="margin-top:122px; position:absolute;" id="aMaternoError"></div>

                        <div id="wb_Label_NombreTutor"><span id="wb_uid4"><strong>Nombre Tutor:</strong></span></div>
                        <html:text styleClass="Txt_NombreTutor" property="nombreTutor" styleId="nombreTutor" tabindex="4" onkeyup="return validaCadena(this);"/>
                        <div style="margin-top:172px; position:absolute;" id="tutorError"></div>
                        
                        <div id="wb_Label_Email"><span id="wb_uid4"><strong>Correo-E:</strong></span></div>
                        <html:text styleClass="Txt_Email" property="email" styleId="email" tabindex="5"/>
                        <div style="margin-top:222px; position:absolute;" id="correoError"></div> 

                        <div id="wb_Label_Direccion"><span id="wb_uid4"><strong>Direccion:</strong></span></div>
                        <html:text styleClass="Txt_Direccion" property="direccion" styleId="direccion" tabindex="6"/>
                        <div style="margin-top:272px; position:absolute;" id="direccionError"></div>

                        <div id="wb_Label_Telefono"><span id="wb_uid4"><strong>Telefono:</strong></span></div>
                        <html:text styleClass="Txt_Telefono" property="telefono" styleId="telefono" tabindex="7"/>
                        <div style="margin-top:322px; position:absolute;" id="telefonoError"></div>

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

                        <div id="wb_Label_DescConsulta"><span id="wb_uid4"><strong>Desc. Consulta:</strong></span></div>   
                        <html:textarea styleClass="Txt_DescripcionConsulta" property="descripcionReclamo" styleId="descripcion" tabindex="9"/> 
                        <div style="margin-top: 95px; position: absolute; margin-left: 322px; " id="descripcionError"></div>    
		                                                                                                       
                        <div id="wb_Label_MontoReclamo"><span id="wb_uid4"><strong>Monto Recl:</strong></span></div>
                        <html:text styleClass="Txt_MontoReclamo" property="montoReclamo" styleId="montoReclamo" tabindex="11"/>
                        <div style="margin-top: 165px; position: absolute; margin-left: 322px; " id="montoReclamoError"></div> 
                        
                        <div id="wb_Label_Pedido"><span id="wb_uid4"><strong>Pedido:</strong></span></div>
                        <html:textarea styleClass="Txt_Pedido" property="pedido" styleId="pedido" tabindex="12"/>  
                        <div style="margin-top: 286px; width: 465px; position:absolute; margin-left: 322px;" id="pedidoError"></div> 
                      
                        <div id="wb_button_registroCaso"><input class="acept" type="button" value="CONSULTAR" onclick="javascript:consultar();"></div>
                        <div id="wb_button_limpiar"><input class="cansel" type="button" value="CANCELAR" onclick="javascript:limpiar();"></div>           
                    </div>
                </div>
             </div>
     </html:form>
</body>
</html:html>
