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

// ##################################################//Consulta ActionFoward Java
function consultar() {
	var form = document.getElementById("formulario");
	if (form.opcion.value == 'consultar') {
		 if (validaFrmConsulta()) {
		 confirmarConsulta();
		 }
	}
}


// ##################################################//Metodo que limpia los campos del form CONSULTA
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
	document.getElementById("identidad").value = "";
}

function validaFrmConsulta() {
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
	var montoReclamoError = document.getElementById("montoReclamoError");
	var pedidoError = document.getElementById("pedidoError");	
	var descripcionError = document.getElementById("descripcionError");

	nombreError.innerHTML = "";
	aPaternoError.innerHTML = "";
	aMaternoError.innerHTML = "";
	tutorError.innerHTML = "";
	correoError.innerHTML = "";
	direccionError.innerHTML = "";
	telefonoError.innerHTML = "";
	docIdentidadError.innerHTML = "";
	montoReclamoError.innerHTML = "";
	pedidoError.innerHTML = "";
	descripcionError.innerHTML = "";

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
	}
	
	if (form.identidadText.value == -1) {
		b = b && false;
		docIdentidadError.innerHTML = '<font color="red">Favor de seleccionar un doc. de indentidad</font>';
	}
	
	if (form.descripcion.value.length == 0) {
		b = b && false;
		descripcionError.innerHTML = '<font color="red">Favor de introducir descripcion/Consulta</font>';
	}

	if (form.montoReclamo.value.length == 0) {
		b = b && false;
		montoReclamoError.innerHTML = '<font color="red">Favor de introducir el Monto del Reclamo</font>';
	}

	if (form.pedido.value.length == 0) {
		b = b && false;
		pedidoError.innerHTML = '<font color="red">Favor de introducir el pedido de la Consulta</font>';
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

function confirmarConsulta() {
	confirmar = confirm("Favor de revisar que todos los datos ingresados sean correctos, para poder consultar la informacion del cliente.");
	if (confirmar) {
		var form = document.getElementById("formulario");
		form.metodo.value = "setCasoConsultaAcl";
		form.submit();
	}
}

