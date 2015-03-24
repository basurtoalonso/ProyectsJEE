//########################//validacion de texField de entradas del form
function validaCadena(v) {
	patron = /[^a-zA-Z .:,()ñáéíóúÑÁÉÍÓÚ\.]/;
	v.value = v.value.replace(patron, "");
}

// ########################//validacion de formato de email
function validaEmail(cadena) {
	cadena = cadena.toUpperCase();
	var Template;
	Template = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	return Template.test(cadena);
}

//########################//Validamos un campo de texto como numérico, por ejemplo el campo teléfono de 9 dígitos
function validaTelefono(cadena){
	var Template;
	Template = /^\d{10}$/;
	return Template.test(cadena);
}

// ##################################################//Guardar Objeto ActionFoward Java
function guardar() {
	var form = document.getElementById("formulario");
	if (form.opcion.value == 'guardar') {
		if (validaFrmReclamo()) {
			confirmarReclamo();
		}
	}
}

function cargarIdBien() {
	alert("entro a cargarIdBien");
	AdministradorDWR.obtieneBienCntr(printIdBien);
}

function printIdBien(data) {
	var messages = new Array()
	messages = data.split(']');
	alert(messages);

	if (messages[0] != 'error' && messages[0] != 'no hay producto') {
		alert("entro a if IDBIEN");
		cadena = '<select onchange="llenaReclamo(this.value);" property="bienContratado" styleId="bienContratado" name="TaCasoForm">';
		cadena += '<option value="-1">SELECCIONE.........</option>';
		for (x = 0; x < messages.length; x++) {
			subMessages = messages[x].split('"');
			cadena += '<option value="' + subMessages[2] + '">' + subMessages[1] + '</option>';
		}
		cadena += '</select>'
		document.getElementById("selectBien").innerHTML = cadena;
	} else {
		document.getElementById("selectBien").innerHTML = '<select disabled="disabled" id="idRecXBien"></select>';
	}
}

function llenaReclamo(e) {
	if (e == -1) {
		document.getElementById("selectProdServ").innerHTML = '<select disabled="disabled" style="width: 200px"></select>';
		document.getElementById("selectProducto").innerHTML = '<select disabled="disabled" style="width: 200px"></select>';
		document.getElementById("selectnaturalezaCaso").innerHTML = '<select disabled="disabled" style="width: 150px"></select>';
	} else {
		AdministradorDWR.obtieneProdServ(e, printProdServ);
		AdministradorDWR.obtieneNaturaleza(printNaturaleza);
		AdministradorDWR.obtieneProducto(printCatalagoProducto);
	}
}

function printProdServ(data) {
	var messages = new Array()
	messages = data.split(']');

	if (messages[0] != 'error' && messages[0] != 'no hay producto') {
		cadena = '<select property="tProdServ" id="tProdServ">'; // onchange="asignaIdBienXRec(this.value);
		cadena += '<option value="-1">SELECCIONE TIPO</option>';
		for (x = 0; x < messages.length - 1; x++) {
			subMessages = messages[x].split('"');
			cadena += '<option value="' + subMessages[2].substring(15, 17) + '">' + subMessages[1] + '</option>';
		}
		cadena += '</select>'
		document.getElementById("selectProducto").innerHTML = cadena;
	} else {
		document.getElementById("selectProducto").innerHTML = '<select disabled="disabled" id="tProdServ"></select>';
	}
}

function printCatalagoProducto(data) {
	var messages = new Array()
	messages = data.split(']');

	if (messages[0] != 'error' && messages[0] != 'no hay producto') {
		cadena = '<select property="idBienXRec" value="-1" styleId="idBienXRec" onchange="asignaIdBienXRec(this.value);">';
		cadena += '<option value="-1">SELECCIONE</option>';
		for (x = 0; x < messages.length - 1; x++) {
			subMessages = messages[x].split('"');
			cadena += '<option value="' + subMessages[2].substring(15) + '">' + subMessages[1] + '</option>';
		}
		cadena += '</select>'
		document.getElementById("selectProdServ").innerHTML = cadena;
	} else {
		document.getElementById("selectProdServ").innerHTML = '<select disabled="disabled" id="idRecXBien"></select>';
	}
}

function printNaturaleza(data) {
	var messages = new Array()
	messages = data.split(']');

	if (messages[0] != 'error' && messages[0] != 'no hay producto') {
		cadena = '<select property="naturalezaCaso" styleId="naturalezaCaso" onchange="asignaNaturaleza(this.value);">';
		cadena += '<option value="-1">SELECCIONE</option>';
		for (x = 0; x < messages.length - 1; x++) {
			subMessages = messages[x].split('"');
			cadena += '<option value="' + subMessages[2].substring(17) + '">' + subMessages[1] + '</option>';
		}
		cadena += '</select>'
		document.getElementById("selectnaturalezaCaso").innerHTML = cadena;
	} else {
		document.getElementById("selectnaturalezaCaso").innerHTML = '<select disabled="disabled" id="naturalezaCaso"></select>';
	}
}

function llenaCausas(idProducto) {
	if (idProducto == -1) {
		document.getElementById("selectCausa").innerHTML = '<select disabled="disabled" property="idProdXCausa" style="width: 200px"></select>';
	} else {
		AdministradorDWR.obtieneCausas(idProducto, printCausas);
	}
}

function printCausas(data) {
	var messages = new Array();
	messages = data.split('#');

	if (messages[0] != 'error' && messages[0] != 'no hay producto') {
		cadena = '<select  property="idProdXCausa" styleId="idProdXCausa" onchange="asignaIdProdXCausa(this.value);">';
		cadena += '<option value="-1">SELECCIONE CAUSA</option>';
		for (x = 0; x < messages.length - 1; x++) {
			subMessages = messages[x].split('=');
			//alert(subMessages[1]);
			cadena += '<option value="' + subMessages[2] + '">'+ subMessages[1].replace("idprodxcausa","") + '</option>';
		}
		cadena += '</select>'
		document.getElementById("selectCausa").innerHTML = cadena;
	} else {
		document.getElementById("selectCausa").innerHTML = '<select disabled="disabled" id="idProdXCausa"></select>';
	}
}

// ##################################################//Metodo que limpia los campos del form
function limpiar() {
	document.getElementById("nombre").value = "";
	document.getElementById("apePat").value = "";
	document.getElementById("apeMat").value = "";
	document.getElementById("nombreTutor").value = "";
	document.getElementById("email").value = "";
	document.getElementById("direccion").value = "";
	document.getElementById("telefono").value = "";
	document.getElementById("pedido").value = "";
	document.getElementById("descripcion").value = "";
	document.getElementById("montoReclamo").value = "";
	document.getElementById("identidadText").value = "-1";
	document.getElementById("identidad").value = "";
	document.getElementById("naturalezaCaso").value = "-1";
	document.getElementById("idBienXRec").value = "-1";
	document.getElementById("idProdXCausa").value = "-1";
    document.getElementById("bienContratado").value = "-1";
}

function validaFrmReclamo() {
	var b = true;
	var form = document.getElementById("formulario");
	var nombreError = document.getElementById("nombreError");
	var aPaternoError = document.getElementById("aPaternoError");
	var aMaternoError = document.getElementById("aMaternoError");
	var tutorError = document.getElementById("tutorError");
	var correoError = document.getElementById("correoError");
	var direccionError = document.getElementById("direccionError");
	var telefonoError = document.getElementById("telefonoError");
	var docIdentidadError = document.getElementById("docIdentidadError");

    var tProdServError = document.getElementById("tProdServError");
	var ProdServError = document.getElementById("ProdServError");
	var natCasoError = document.getElementById("natCasoError");
	var causaError = document.getElementById("causaError");

	var montoReclamoError = document.getElementById("montoReclamoError");
	var pedidoError = document.getElementById("pedidoError");
	var descripcionError = document.getElementById("descripcionError");

	var bienError = document.getElementById("bienError");

	nombreError.innerHTML = "";
	aPaternoError.innerHTML = "";
	aMaternoError.innerHTML = "";
	tutorError.innerHTML = "";
	correoError.innerHTML = "";
	direccionError.innerHTML = "";
	telefonoError.innerHTML = "";
	docIdentidadError.innerHTML = "";

    tProdServError.innerHTML = "";
	ProdServError.innerHTML = "";
	natCasoError.innerHTML = "";
	causaError.innerHTML = "";

	montoReclamoError.innerHTML = "";
	pedidoError.innerHTML = "";
	descripcionError.innerHTML = "";
	bienError.innerHTML = "";

	if (form.nombre.value.length == 0) {
		nombre.focus();
		b = b && false;
		nombreError.innerHTML = '<font color="red">Favor de introducir un nombre de cliente valido</font>';
	}

	if (form.apePat.value.length == 0) {
		b = b && false;
		aPaternoError.innerHTML = '<font color="red">Favor de introducir un apellido paterno valido</font>';
	}

	if (form.apeMat.value.length == 0) {
		b = b && false;
		aMaternoError.innerHTML = '<font color="red">Favor de introducir un apellido materno valido</font>';
	}

	if (form.nombreTutor.value.length == 0) {
		b = b && false;
		tutorError.innerHTML = '<font color="red">Favor de introducir un nombre de tutor valido</font>';
	}

	if (form.email.value.length == 0) {
		b = b && false;
		correoError.innerHTML = '<font color="red">Favor de introducir un correo electronico valido</font>';
	} else {
		if (!validaEmail(form.email.value)) {
			b = b && false;
			correoError.innerHTML = '<font color="red">El formato del correo electronico es Invalido</font>';
		}
	}

	if (form.direccion.value.length == 0) {
		b = b && false;
		direccionError.innerHTML = '<font color="red">Favor de introducir una direccion valida</font>';
	}

	if (form.telefono.value.length == 0) {
		b = b && false;
		telefonoError.innerHTML = '<font color="red">Favor de introducir un telefono valido</font>';
	}else{
		if(isNaN(form.telefono.value)) {
			b = b && false;
			telefonoError.innerHTML = '<font color="red">El formato del telefono es Ivalido</font>';		 
			}	
		/*if(!validaTelefono(form.telefono.value)){
		   b = b && false;
		   telefonoError.innerHTML = '<font color="red">El formato del telefono es Ivalido</font>';		   
		}*/
	}

	if (form.identidadText.value == -1) {
		b = b && false;
		docIdentidadError.innerHTML = '<font color="red">Favor de seleccionar un doc. de indentidad</font>';
	}

	if (form.montoReclamo.value.length == 0) {
		b = b && false;
		montoReclamoError.innerHTML = '<font color="red">Favor de introducir el Monto del reclamo</font>';
	}

	if (form.pedido.value.length == 0) {
		b = b && false;
		pedidoError.innerHTML = '<font color="red">Favor de introducir el pedido del reclamo</font>';
	}

	if (form.descripcion.value.length == 0) {
		b = b && false;
		descripcionError.innerHTML = '<font color="red">Favor de introducir descripcion/reclamo</font>';
	}

	if (form.bienContratado.value == -1) {
		b = b && false;
		bienError.innerHTML = '<font color="red">Favor de seleccionar Bien Contratado</font>';
	}

	if (form.tProdServ.value == -1) {
		b = b && false;
		tProdServError.innerHTML = '<font color="red">Favor de seleccionar Tipo Producto o Servicio</font>';
	}
	
	if (form.idBienXRec.value == -1) {
		b = b && false;
		ProdServError.innerHTML = '<font color="red">Favor de seleccionar el Producto/Servicio</font>';
	}

	if (form.naturalezaCaso.value == -1) {
		b = b && false;
		natCasoError.innerHTML = '<font color="red">Favor de seleccionar Naturaleza del caso</font>';
	}

	if (form.idProdXCausa.value == -1) {
		b = b && false;
		causaError.innerHTML = '<font color="red">Favor de seleccionar la causa del reclamo</font>';
	}

	if (form.identidad.value.length == 0) {
		b = b && false;
		identidadError.innerHTML = '<font color="red">Favor de digitar documento de identidad</font>';
	}

	if (form.identidad.value.length > 0 && form.identidad.value.length < 8) {
		b = b && false;
		identidadError.innerHTML = '<font color="red">Favor de ingresar una identidad valida.</font>';
	}

	return b;
}

function mostrarText(identidadText) {
	document.getElementById("identidadCont").style.visibility = 'inherit';

	var identidad = document.getElementById('identidad');
	var identidadError = document.getElementById('errorIdentidead');
	var s = identidad.value;
	var errorDni = document.getElementById('errorDni');
	errorDni.innerHTML = "";

	switch (identidadText.value) {

	case '1': // DNI
		document.getElementById("identidad").disabled = false;
		identidad.focus();
		identidad.maxLength = 8;
		if (identidad.value.length > 8) {
			identidad.value = s.substring(0, 8);
		}
		break;

	case '2': // Carnet de Extranjería
		document.getElementById("identidad").disabled = false;
		identidad.focus();
		identidad.maxLength = 9;
		identidad.value = s;
		break;

	case '-1': // Seleccione
		ocultar();
		identidad.value = '';
		identidadError.innerHTML = '';
		break;

	default:
	}
}

function ocultar() {
	document.getElementById("identidad").disabled = true;
}

function validaIdentidad() {
	var identidad = document.getElementById('identidad');
	var identidadText = document.getElementById('identidadText');
	var identidadError = document.getElementById('errorIdentidead');

	switch (identidadText.value) {

	case '1': // DNI
		docIdentidadError.innerHTML = '';
		if (identidad.value.length != 8) { // || identidad.value.length == 0
			identidadError.innerHTML = '<font color="red">La identidad DNI deben ser 8 caracteres</font>';
			identidad.focus();
		} else {
			identidadError.innerHTML = '';
		}
		break;

	case '2': // Carnet de Extranjería
		docIdentidadError.innerHTML = '';
		if (identidad.value.length != 9) { // || identidad.value.length == 0
			identidadError.innerHTML = '<font color="red">La identidad CARNET deben ser 9 caracteres</font>';
			identidad.focus();
		} else {
			identidadError.innerHTML = '';
		}
		break;

	case '-1': // Seleccione
		identidadError.innerHTML = '';
		break;

	default:
	}
}


function confirmarReclamo() {
	confirmar = confirm("Favor de revisar que todos los datos ingresados sean correctos, pues una vez guardados no podras realizar modificaciones.");
	if (confirmar) {
		var form = document.getElementById("formulario");
		form.metodo.value = "setCasoReclamoAcl";
		form.submit();
	}
}

// Selector jQuery para el click evento del select, para aparecer formulario
$(function() {	
	$('#reclamo').focus().on('keypress', function(e) {
		var p = e.which;
		if (p === 13) {
			$('#formulario').submit();
		}
	});

	/*$("#reclamo").dblclick(function() {
		$('#formulario').submit();
	});*/
});


