
$(document).ready(function() {//valida form button
    $('#jAlert').click(function validarForm() {
        if (Txt_Username.value.length === 0) {
            jAlert("ERROR... Introduce Username", "[Message Error]");
        }

        else if (Txt_Password.value.length === 0) {
            jAlert("ERROR... Introduce Password", "[Message Error]");
        }
        
        else if (Txt_Nombres.value.length === 0) {
            jAlert("ERROR... Introduce Nombres", "[Message Error]");
        }
        
        else if (Txt_Apellidos.value.length === 0) {
            jAlert("ERROR... Introduce Apellidos", "[Message Error]");
        }

        else if (Txt_Password.value.length !== 0) {
            jConfirm('Desea Guardar Los Datos?', 'Dialogo De Confirmacion', function(r) {
                if (r === true) {
                    document.getElementById("loading").style.display = "block";
                    agregarUsuario();
                }
            });
        }
    });
});

function f_KeyPressMenuSave(p_Element) {//valida for menu
    if (p_Element === 'nb_Save' && Txt_Username.value.length === 0) {
        jAlert("ERROR! Introduce Username", "[Message Error]");
    }

    else if (p_Element === 'nb_Save' && Txt_Password.value.length === 0) {
        jAlert("ERROR! Introduce Password", "Message Error");
    }

    else if (p_Element === 'nb_Save' && Txt_Password.value.length !== 0) {
        jConfirm('Desea Guardar Los Datos?', 'Dialogo De Confirmacion', function(r) {
            if (r === true) {
                document.getElementById("loading").style.display = "block";
                agregarUsuario();
            }
        });
    }

    else if (p_Element === 'nb_Info') {
        jAlert("Information application Web", "Alert Message");
    }
    
    else if (p_Element === 'nb_Back'){ 
        history.go(-1);  
    }  
    
  else if(p_Element === 'nb_Next'){ 
        history.go(1);   
    }  
}

var urlAgregarUsuario;
urlAgregarUsuario = "http://localhost:8080/applicationMVC/controllerInsert?";

function agregarUsuario() {
    var u = document.getElementById("Txt_Username").value;
    var p = document.getElementById("Txt_Password").value;
    var n = document.getElementById("Txt_Nombres").value;
    var a = document.getElementById("Txt_Apellidos").value;
    var e = document.getElementById("Txt_Email").value;
    var c = document.getElementById("Txt_Cel").value;
    var cp = document.getElementById("Txt_CP").value;
    var d = document.getElementById("Txt_Domicilio").value;

    urlAgregarUsuario += "Txt_Username=" + u;
    urlAgregarUsuario += "&Txt_Password=" + p;
    urlAgregarUsuario += "&Txt_Nombres=" + n;
    urlAgregarUsuario += "&Txt_Apellidos=" + a;
    urlAgregarUsuario += "&Txt_Email=" + e;
    urlAgregarUsuario += "&Txt_Cel=" + c;
    urlAgregarUsuario += "&Txt_CP=" + cp;
    urlAgregarUsuario += "&Txt_Domicilio=" + d;
    urlAgregarUsuario += "&id=" + Math.random();

    //alert(urlAgregarUsuario);
    location.assign(urlAgregarUsuario);
}



function borrarUsuario(usuario) {
    alert(usuario);
}

function limpiarUsuario() {
    document.getElementById("Txt_Username").value = "";
    document.getElementById("Txt_Password").value = "";
    document.getElementById("Txt_Nombres").value = "";
    document.getElementById("Txt_Apellidos").value = "";
    document.getElementById("Txt_Email").value = "";
    document.getElementById("Txt_Cel").value = "";
    document.getElementById("Txt_CP").value = "";
    document.getElementById("Txt_Domicilio").value = "";
}
