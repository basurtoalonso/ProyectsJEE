package com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos;

import java.io.IOException;
import net.sf.json.JSONArray;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class CasosReclamoAclCatalagos {
	
	public CasosReclamoAclCatalagos(){}

	public static JSONArray getCatalagoProdServObjectJson(int idBienContratado) throws IOException, HttpMediaTypeNotAcceptableException, HttpStatusCodeException{	
		System.out.println("Entro a obtener getCatalagoProdServObjectJson()###");
		JSONArray jsonArray = new JSONArray();
		RestTemplate restClient=null;
		try{
			
		     restClient = new RestTemplate();
		     String urlWS="http://10.51.193.199:8080/UEAUMex/rest/servicio/caso/getCatalogoProdServ/"+idBienContratado;
		     jsonArray = restClient.getForObject(urlWS, JSONArray.class);
		     System.out.println("jsonArray PRODUCTO/SERVICIO: " +jsonArray);
			  
		  } catch (RestClientException ex) {
			System.out.println("RestClientException refused connection" +ex.getMessage());		
	      } catch (HttpMessageNotReadableException e) {
	        System.out.println("The GET request FAILED with the message being not readable:" + e.getMessage());
	      } catch (RuntimeException e) {
	    	System.out.println("The GET request FAILED " + ExceptionUtils.getFullStackTrace(e));
	     }
	    
	  return jsonArray;
  }
	
	public static JSONArray getCatalagoCausaObjectJson(int idProducto)  throws IOException, HttpMediaTypeNotAcceptableException{	
		System.out.println("Entro a obtener getCatalagoCausaObjectJson()###");
		JSONArray jsonArray = new JSONArray();
		RestTemplate restClient=null;
		try{
			  restClient = new RestTemplate();
			  String urlWS="http://10.51.193.199:8080/UEAUMex/rest/servicio/caso/getCatalogoCausa/"+idProducto;
			  jsonArray = restClient.getForObject(urlWS, JSONArray.class);
			  System.out.println("jsonArray CAUSA: " +jsonArray);
		 
		    }catch (RestClientException ex) {
				System.out.println("RestClientException refused connection" +ex.getMessage());		
		    } catch (HttpMessageNotReadableException e) {
		        System.out.println("The GET request FAILED with the message being not readable:" + e.getMessage());
		    } catch (RuntimeException e) {
		    	System.out.println("The GET request FAILED " + ExceptionUtils.getFullStackTrace(e));
		    }
		      
	  return jsonArray;
   }
	
	public static JSONArray getCatalagoNaturalezaObjectJson() {
		System.out.println("Entro a obtener getCatalagoNaturalezaObjectJson()###");
		JSONArray jsonArray = new JSONArray();
		RestTemplate restClient=null;
		try{
			  restClient = new RestTemplate();
			  String urlWS="http://10.51.193.199:8080/UEAUMex/rest/servicio/caso/getCatalogoNaturaleza";
			  jsonArray = restClient.getForObject(urlWS, JSONArray.class);
			  System.out.println("jsonArray NATURALEZA: " +jsonArray);
		 
		    }catch (RestClientException ex) {
				System.out.println("RestClientException refused connection" +ex.getMessage());		
		    } catch (HttpMessageNotReadableException e) {
		        System.out.println("The GET request FAILED with the message being not readable:" + e.getMessage());
		    } catch (RuntimeException e) {
		    	System.out.println("The GET request FAILED " + ExceptionUtils.getFullStackTrace(e));
		    }
		      
	  return jsonArray;
		
	}

	public static JSONArray getCatalagoBienCntrObjectJson() {
		System.out.println("Entro a obtener getCatalagoBienCntrObjectJson()###");
		JSONArray jsonArray = new JSONArray();
		RestTemplate restClient=null;
		try{
			  restClient = new RestTemplate();
			  String urlWS="http://10.51.193.199:8080/UEAUMex/rest/servicio/caso/getCatalogoBienCntr";
			  jsonArray = restClient.getForObject(urlWS, JSONArray.class);
			  System.out.println("jsonArray BIENCNTR: " +jsonArray);
		 
		    }catch (RestClientException ex) {
				System.out.println("RestClientException refused connection" +ex.getMessage());		
		    } catch (HttpMessageNotReadableException e) {
		        System.out.println("The GET request FAILED with the message being not readable:" + e.getMessage());
		    } catch (RuntimeException e) {
		    	System.out.println("The GET request FAILED " + ExceptionUtils.getFullStackTrace(e));
		    }
		      
	  return jsonArray;
	}
	
	public static JSONArray getCatalagoProductosObjectJson() {
		System.out.println("Entro a obtener getCatalagoProductoObjectJson()###");
		JSONArray jsonArray = new JSONArray();
		RestTemplate restClient=null;
		try{
			  restClient = new RestTemplate();
			  String urlWS="http://10.51.193.199:8080/UEAUMex/rest/servicio/caso/getCatalogoProducto/1";
			  jsonArray = restClient.getForObject(urlWS, JSONArray.class);
			  System.out.println("jsonArray PRODUCTOS: " +jsonArray);
		 
		    }catch (RestClientException ex) {
				System.out.println("RestClientException refused connection" +ex.getMessage());		
		    } catch (HttpMessageNotReadableException e) {
		        System.out.println("The GET request FAILED with the message being not readable:" + e.getMessage());
		    } catch (RuntimeException e) {
		    	System.out.println("The GET request FAILED " + ExceptionUtils.getFullStackTrace(e));
		    }
		      
	  return jsonArray;
	}
}
