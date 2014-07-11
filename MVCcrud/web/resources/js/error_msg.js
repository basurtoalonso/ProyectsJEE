//recuperas datos de cadena queryString

/*
function getData(c_name){
    try{
        var x, y;
        var qs= document.URL.substr(document.URL.indexOf("?")+1);
        var datos= qs.split("&");
        
        for(i=0; i<datos.length; i++){
           x= datos[i].substr(0, datos[i].indexOf("=")); 
           y= datos[i].substr(datos[i].indexOf("=")+1); 
           x= x.replace(/^\s+|\s+$/g, ""); 
           
           if(x===c_name){
             return unescape(y);
           }
        }
        return "";   
    }catch (oError){
        alert(oError.message);
    }
}*/

