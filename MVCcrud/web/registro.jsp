<html>
    <head>
        <meta name=viewport content="width=device-width">
        <meta http-equiv="X-UA-Compatible" content="IE=5">
        <meta http-equiv="Content-Language" content="es-mx"> 
       
        
    </head>
    <body>

    <style type="text/css" >
        .acept{
            font-size:11px;
            font-family:Verdana,Helvetica;
            font-weight:bold;
            color:black;
            background: url(resources/imag/ok.png) no-repeat;
            width:100px;
            height:25px;
            cursor:  pointer;
            outline:none; 
            display:block; 
            color: #444;
            overflow: hidden;
            background-color: #000000;
            color: #FFF;text-shadow: 0 -1px 1px rgba(0,0,0,0.25);background-color: graytext;
            outline:none; 
            display:block; 
        }

    </style>

    <form  method="post" action="controllerInsert">     

        <table width="365" border="1" cellpadding="1" style="background:#CCCCCC; border:1px solid #999999; letter-spacing:normal;">
            <tr>
            <td>Username:</td>
            <td> <input name="Txt_Username" id="Txt_Username"  type="text" value=""  size="32"/></td>
            </tr>
            <tr>
            <td>Password:</td>
            <td> <input name="Txt_Password" id="Txt_Password" type="text" value="" size="32" /></td>
            </tr>
            <tr>
            <td>Nombre Del Usuario:</td> 
            <td> <input name="Txt_Nombres" id="Txt_Nombres" type="text" value="" size="32"/></td>
            </tr>
            <tr>
            <td>Apellidos Del Uusario:</td> 
            <td> <input name="Txt_Apellidos" id="Txt_Apellidos" type="text" value=""  size="32" /></td>
            </tr>
            <tr>
            <td>Email De Usuario:</td>
            <td> <input name="Txt_Email" id="Txt_Email" type="text" value="" size="32"  /></td>
            </tr>
            <tr>
            <td>Telefono Del Usuario: </td>
            <td> <input name="Txt_Cel" id="Txt_Cel" type="text"  value=""  size="32"/></td>
            </tr>
            <tr>
            <td>C.P:</td>
            <td><input name="Txt_CP" id="Txt_CP" type="text" value=""  size="32" /></td>
            </tr>
            <tr>
            <td>Domicilio:</td>
            <td><input name="Txt_Domicilio" id="Txt_Domicilio" type="text"  value="" size="32"/></td>
            </tr>
            <tr>
            <td colspan="2"><center>
                    <h3 class="Estilo4"><tt>EXAMINAR FOTOGRAF&Iacute;A... </tt></h3>
                </center></td>
            </tr>
            <tr>
            <td colspan="2"><input name="fotop" type="file" id="fotop" value=""></td>
            </tr>

            <tr>
            <td>&nbsp;</td>    
            <td><input name="actualizar" type="submit" id="jAlert" class="acept" value="Registrar" onClick="self.parent.tb_remove();" /></td>

            <!--<td><input name="actualiza" type="submit" id="actualiza" value="Actualizar"/></td> -->
            </tr>
        </table>
    </form>
</body>
</html>