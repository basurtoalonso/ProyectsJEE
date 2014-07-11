
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta name=viewport content="width=device-width">
        <meta http-equiv="X-UA-Compatible" content="IE=5">
        <meta http-equiv="Content-Language" content="es-mx">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
        
<%@include file = "/WEB-INF/jspf/styles.jspf" %>
<%@include file = "/WEB-INF/jspf/javascript.jspf" %> 
        
    </head>
    <body>
        <div id="container">
            <div id="wb_Form_Error">
                <form name="Frm_Error" method="post" action="" id="Form_Error">
                    <input type="hidden" name="form_name" value="Frm_Error">
                        <div id="Lyr_Icono_Error" title=""></div> 
                        <textarea name="TxtArea_Comentarios" id="TxtArea_Comentarios" rows="2" cols="86"></textarea>
                        <div id="Lyr_Text_Error" title="">                  
                           <span id="sp_Text_Error"><strong><%= request.getParameter("msg_error")%></strong></span>                            
                       </div>
                </form>
            </div>
        </div>
    </body>
</html>