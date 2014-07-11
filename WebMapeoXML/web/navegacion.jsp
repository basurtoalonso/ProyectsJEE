
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%--<c:if test="${!empty requestScope.error}">
    <% request.getRequestDispatcher("../error.jsp").forward(request, response);%>
</c:if>--%>

<c:import url="${requestScope.xml}" var="document" />
<x:parse doc="${document}" var="doc" />

<html>
    <head>
        <meta name=viewport content="width=device-width">
        <meta http-equiv="X-UA-Compatible" content="IE=5">
        <meta http-equiv="Content-Language" content="es-mx">
        <title>Prueba de mapeo XML</title>
        <%@include file = "WEB-INF/jspf/style.jspf" %>
        <script type="text/javascript">
            //Evita redireccionar a la pagina anterior
            /*window.history.forward();
            function noBack() {
                window.history.forward();
            }*/
        </script>

        <style type="text/css">        
            .styleSelect {display:inline-block; overflow:hidden;}
            .styleSelect select { font-size: 20px; padding:10px; margin:-1px -27px -3px -3px; width: 355px; height: 130px;         
            }
        </style>
    </head>
    <body>
        <div id="container">
            <div id="wb_Form_Puerta">
                <%@ include file="WEB-INF/jspf/header.jspf" %>
                <div id="Lyr_Container" title="">
                    <center><br>
                        <form class="styleSelect" action="../nav" method="post" id="formNav">
                            <select name="nav" size="4" id="nav">
                                <x:forEach select="$doc/menu/element" varStatus="incrementable" >
                                    <option ${incrementable.count==1 ? 'selected': ''}  value='<x:out select="action"/>' ><x:out select="name"/></option>                                  
                                </x:forEach>
                            </select>
                        </form></center>
                           <br><center><input type="submit" name="entrar" value="entrar"></center>

                </div>
                <%@include file="WEB-INF/jspf/javascript.jspf" %>
                <script type="text/javascript">
                    $(function() {
                        $('#nav').focus()
                                .on('keypress', function(e) {
                            var p = e.which;
                            if (p === 13) {
                                $('#formNav').submit();
                            }
                        });
                    });
                </script>
            </div>
        </div>
    </body>
</html>