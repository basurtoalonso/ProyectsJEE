//var g_Boton;
//var g_MessageError;

/*function f_SubmitForm(p_Form_Name,p_Form_Action)
{   
    document.forms[p_Form_Name].enctype = "application/x-www-form-urlencoded";
    document.forms[p_Form_Name].action = p_Form_Action;      
    document.forms[p_Form_Name].submit();
}*/

/*function f_KeyPress(p_Key,p_Element,frm)
{
    var Unicode;

    if (p_Key.charCode)
    {
        Unicode=p_Key.charCode;
    }
    else
    {
        Unicode=p_Key.keyCode;
    }
    //alert(" "+Unicode);
    //alert("Presionaste: ASCII: "+Unicode+", Elemento: "+p_Element);
    //var g_MessageError;
    //if (p_Element === 'Txt_Gate' && Unicode === 13)
    //{


        //g_MessageError = "Error: Puerta de entrada seleccionada y debe elegir una de puerta de salida.";
        //alert("LO HISO");
        //location.href="T_Error.jsp?variable="+g_MessageError+"";
            //window.location = "T_Error.jsp?acron="+g_MessaggerError;
            
        //    request.setAttribute("NO",g_MessageError);
          //  request.getRequestDispatcher("/T_Error.jsp").forward(request,response);
    //}
}*/

/*function f_setPage(p_Element){
    g_Boton = p_Element;
}



function f_getPage(){
   return g_Boton; 
}*/


//var g_Boton;
//var g_MessageError;

/*function f_SubmitForm(p_Form_Name,p_Form_Action)
{   
    document.forms[p_Form_Name].enctype = "application/x-www-form-urlencoded";
    document.forms[p_Form_Name].action = p_Form_Action;      
    document.forms[p_Form_Name].submit();
}*/

/*function f_KeyPress(p_Key,p_Element,frm)
{
    var Unicode;

    if (p_Key.charCode)
    {
        Unicode=p_Key.charCode;
    }
    else
    {
        Unicode=p_Key.keyCode;
    }
    //alert(" "+Unicode);
    //alert("Presionaste: ASCII: "+Unicode+", Elemento: "+p_Element);
    //var g_MessageError;
    //if (p_Element === 'Txt_Gate' && Unicode === 13)
    //{


        //g_MessageError = "Error: Puerta de entrada seleccionada y debe elegir una de puerta de salida.";
        //alert("LO HISO");
        //location.href="T_Error.jsp?variable="+g_MessageError+"";
            //window.location = "T_Error.jsp?acron="+g_MessaggerError;
            
        //    request.setAttribute("NO",g_MessageError);
          //  request.getRequestDispatcher("/T_Error.jsp").forward(request,response);
    //}
}*/

/*function f_setPage(p_Element){
    g_Boton = p_Element;
}



function f_getPage(){
   return g_Boton; 
}*/


/*function f_KeyPressMenu(p_Element){    
 jAlert("Presionaste: "+p_Element, "!Alert Message!");  

  if(p_Element === 'nb_Start'){ 
     //request.getRequestDispatcher("./index.jsp").forward(request,response);
     //window.location = "index.jsp";
     //history.forward("../index.jsp");
     //setTimeout("location.href='index.jsp\'",5000);     
    }   
    
  if(p_Element === 'nb_Save'){ 
    jConfirm('Desea Guardar Los datos?', 'Mensaje De Confirmacion', function(){
    //jAlert('Confirmar: ' + r, 'Resultados De Confirmacion');
    window.location = "admin_usuarios.jsp";
    }); 
  }    
    
 
    
  if(p_Element === 'nb_Back'){ 
        history.go(-1);  
    }  
    
  if(p_Element === 'nb_Next'){ 
        history.go(1);   
    }  
}
*/


/*function f_KeyPressMenu(p_Element) //Eventos del Menú
{
    alert("Presionaste: "+p_Element);  
    //if (p_Element === 'nb_Start')
    //{      
    //}  
}*/

/*function f_SelectGate()
{  
    g_MessageError="";
    var l_Gate = document.Form_Gate.Txt_Gate.value;
  
    if(l_Gate == 1 || l_Gate == 2 || l_Gate == 10 || l_Gate == 11 || l_Gate == 12)
    {
        g_MessageError = "Error: Puerta de entrada seleccionada y debe elegir una de puerta de salida.";
        Form_Gate.Txt_Error.value = g_MessageError;
    }
    else if(l_Gate == 3 || l_Gate == 4 || l_Gate == 20 || l_Gate == 21 || l_Gate == 22)
    {
        g_MessageError = "Error: Puerta de salida seleccionada y debe elegir una de puerta de entrada.";
        Form_Gate.Txt_Error.value = g_MessageError;
    }
    else
    {
        g_MessageError = "Error: Puerta erronea.";
        Form_Gate.Txt_Error.value = g_MessageError;
    }
    
    if(g_MessageError === ''){
        document.forms[0].enctype = "application/x-www-form-urlencoded";
        document.forms[0].action = "T_Information.jsp";
    }else{
        document.forms[0].enctype = "application/x-www-form-urlencoded";
        document.forms[0].action = "T_Error.jsp";
    }
}




function f_Error()
{
    return g_MessageError;
}*/


