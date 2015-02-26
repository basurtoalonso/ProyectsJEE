
$(document).ready(function(){	

$('#fenviar').click(function validar() {
	if (telefono.value.length==0){ 
      	 //alert("ERROR....Introduce telefono") ;
		  jAlert("ERROR....Introduce telefono ¬¬", "[MessageError]");
         return false;
   	} 
		else if (telefono.value.length>10){ 
      	  //alert("el numero telefonico debe tener maximo 10 digitos.") 
		   jAlert("el numero telefonico debe tener maximo 10 digitos. ¬¬", "[MessageError]");
         return false;
   	} 
	  else if(telefono.value.length !== 0){ 
            jConfirm('Desea Guardar Los Datos?', 'Dialogo De Confirmacion', function(r) {
                if (r === true) {
                    document.getElementById("loading").style.display = "block";
                    //agregarUsuario();
			       }
            });
	  }
     //return true;

});

					
    $('.numeros').keyup(function (){
    this.value = this.value.replace(/[^0-9\.]/g,'');
    });
	
	$('.numeros[name=telefono],.telefono').blur(function (){
	this.value = this.value.replace(/[^0-9\.]/g,'');
	if(this.value.length < 8){
		 jAlert("el numero telefonico debe tener minimo 8 digitos. ¬¬", "[MessageError]");
	}
	
   });
   
   if($('select[name=puesto]').val() == "selecciona puesto" && $('input[name=sueldo]').val()=='' && $('input[name=telefono]').val()==''){
		$('#fenviar').attr('disabled','disabled');
	}
			
	 $('select[name=puesto]') && $('input[name=sueldo]') && $('input[name=telefono]').change(function(){
	 $('#fenviar').removeAttr('disabled');
	// var valor = $(this).val();

   });

});

