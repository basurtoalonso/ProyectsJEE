<html>
    <head>
        <meta name=viewport content="width=device-width">
        <meta http-equiv="X-UA-Compatible" content="IE=5">
        <meta http-equiv="Content-Language" content="es-mx"> 
        
        <%@include file = "/WEB-INF/jspf/styles.jspf" %>
        <%@include file = "/WEB-INF/jspf/javascript.jspf" %>

                
<link type="text/css" href="resources/ui/css/bootstrap/css/bootstrap.min.css" rel="stylesheet" />


        <style type="text/css" >
            #loading {
                background: url(resources/img/ajax-loader.gif) no-repeat;
            } 
        </style>
    </head>
    <body>

        <div id="loading" style="display:none"></div><br>

        <form  method="get" action="controllerInsert" onSubmit="return validarForm(this);">
       
            <div id="Lyr_Container" title="">
                <div id="wb_Text_Username">
                    <span id="wb_uid10"><strong>USERNAME:</strong></span></div>
                <input type="text" id="Txt_Username" name="Txt_Username" value="" tabindex="1">

                <div id="wb_Text_Password">
                    <span id="wb_uid5"><strong>PASSWORD:</strong></span></div>
                <input type="text" id="Txt_Password" name="Txt_Password" value="" tabindex="2">

                <div id="wb_Text_Nombres">
                    <span id="wb_uid4"><strong>NOMBRES:</strong></span></div>
                <input type="text" id="Txt_Nombres" name="Txt_Nombres" value="" tabindex="3">

                <div id="wb_Text_Apellidos">
                    <span id="wb_uid9"><strong>APELLIDOS:</strong></span></div>
                <input type="text" id="Txt_Apellidos" name="Txt_Apellidos" value="" tabindex="4">

                <div id="wb_Text_Email">
                    <span id="wb_uid7"><strong>EMAIL:</strong></span></div>
                <input type="text" id="Txt_Email" name="Txt_Email" value="" tabindex="5">

                <div id="wb_Text_Buq">
                    <span id="wb_uid3"><strong>CEL:</strong></span></div>
                <input type="text" id="Txt_Cel" name="Txt_Cel" value="" tabindex="6" >

                <div id="wb_Text_Sel">
                    <span id="wb_uid1"><strong>CP:</strong></span></div>
                <input type="text" id="Txt_CP" name="Txt_CP" value="" tabindex="7" >

                <div id="wb_Text_Domicilio">
                    <span id="wb_uid11"><strong>DOMIC:</strong></span></div>
                <input type="text" id="Txt_Domicilio" name="Txt_Domicilio" value="" tabindex="8">
                               
                <div id="wb_Text_Foto">
                      <span id="wb_uid10"><strong>EXAMINAR FOTOGRAF&Iacute;A:</strong></span></div>         
                <input type="file" id="Txt_fotop" name="Txt_fotop" value="" tabindex="8">
               

                <input type="button" class="Btn_Agregar" id="jAlert"  tabindex="8" value="Registrar"/> 
                <input type="button" id="Btn_Borrar" value="Limpiar"  tabindex="9" onclick="limpiarUsuario();" />   
            </div>
        </form>  
    </body>
</html>