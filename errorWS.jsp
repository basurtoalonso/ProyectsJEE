<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<link href="<html:rewrite page="/resources/css/clases_ccenter.css"/>" rel="stylesheet" type="text/css"/>

  <style type="text/css" >  
#error{
   border: 1px #A9A9A9 solid;
   -moz-border-radius: 5px;
   -webkit-border-radius: 5px;
   border-radius: 5px;
   background-color: #cccccc;
   color :#000000;
   font-family: Arial;
   font-size: 16px;
   padding: 10px 10px 10px 10px;
   text-align: left;
   resize: none;
}

#Lyr_Icono_Error{
   position: absolute;
   text-align: left;
   left: 130px;
   top: 100px;
   width: 400px;
   height: 80px;
   z-index: 1;
}

#Lyr_Icono_Error{
   background-color: transparent;
   background-image: url(images/Error.png);
   background-repeat: no-repeat;
   top: 20px;
}
</style>

<table width="500" border="0" bgcolor="#C8CC97" class="texto" align="center">
	<tr><td align="center">&nbsp;</td></tr>
	<div id="Lyr_Icono_Error" title=""></div> 
    <tr><td align="center"><br><span class="error"><bean:write name="errorMensaje" scope="session" filter="false"/></span></td></tr>
</table>
