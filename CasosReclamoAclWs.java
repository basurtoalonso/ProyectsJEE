
package com.bancoazteca.ebanking.web.aclaraciones.action;

import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.client.RestTemplate;
import com.bancoazteca.ebanking.web.bean.ws.Constantes;
import com.bancoazteca.ebanking.web.bean.ws.TaCasoForm;
import com.bancoazteca.ebanking.web.bean.ws.RespuestaGenerica;
import com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos.catalagoBienCntrVO;
import com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos.catalagoProdServVO;
import com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos.catalagoNaturalezaVO;
import com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos.catalagoCausasVO;
import com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos.CasosReclamoAclCatalagos;
import com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos.catalagoProductoVO;

public class CasosReclamoAclWs {
	
	public CasosReclamoAclWs(){}
	
	public static RespuestaGenerica setCasoPeru(TaCasoForm tacasoForm)throws Exception{
		System.out.println("Entro a insertar setCasoPeru()");
		RespuestaGenerica respuestaWs = new RespuestaGenerica();
	    JSONObject objJson = new JSONObject();

		try {
			objJson.put("fcnombre",tacasoForm.getNombre() == null ?  "" : (tacasoForm.getNombre().trim().equals("")) ? "" : tacasoForm.getNombre());
			objJson.put("apePat",tacasoForm.getApePat() == null ?  "" : (tacasoForm.getApePat().trim().equals("")) ? "" : tacasoForm.getApePat());
			objJson.put("apeMat",tacasoForm.getApeMat() == null ?  "" : (tacasoForm.getApeMat().trim().equals("")) ? "" : tacasoForm.getApeMat());
			objJson.put("fcnombretutor",tacasoForm.getNombreTutor() == null ?  "" : (tacasoForm.getNombreTutor().trim().equals("")) ? "" : tacasoForm.getNombreTutor());
			objJson.put("fccorreoelectronico",tacasoForm.getEmail() == null ? "" : (tacasoForm.getEmail().trim().equals("")) ? "" : tacasoForm.getEmail());
			objJson.put("fcdireccion",tacasoForm.getDireccion() == null ? "" : (tacasoForm.getDireccion().trim().equals("")) ? "" : tacasoForm.getDireccion());
			objJson.put("fctelefono",tacasoForm.getTelefono() == null ? "" : (tacasoForm.getTelefono().trim().equals("")) ? "" : tacasoForm.getTelefono());
			objJson.put("fcidentidad",tacasoForm.getIdentidad() == null ? "" : (tacasoForm.getIdentidad().trim().equals("")) ? "" : tacasoForm.getIdentidad());
			objJson.put("fcdescripcion",tacasoForm.getDescripcionReclamo() == null ? "" : (tacasoForm.getDescripcionReclamo().trim().equals("")) ? "" : tacasoForm.getDescripcionReclamo());					
			objJson.put("fimontoreclamado", tacasoForm.getMontoReclamo() == null ? "" : (tacasoForm.getMontoReclamo().equals("")) ? "" : tacasoForm.getMontoReclamo()); 		
			objJson.put("fcpedido",tacasoForm.getPedido() == null ? "" : (tacasoForm.getPedido().trim().equals("")) ? "" : tacasoForm.getPedido());		
						
			objJson.put("fiidbiencontratado", tacasoForm.getBienContratado() == null ?  -1 : (tacasoForm.getBienContratado().equals("")) ? -1 : tacasoForm.getBienContratado());	
			objJson.put("fiidbienxrec", tacasoForm.getIdBienXRec() == null ?  -1 : (tacasoForm.getIdBienXRec().equals("")) ? -1 : tacasoForm.getIdBienXRec());				
			objJson.put("fiidprodxcausa", tacasoForm.getIdProdXCausa() == null ?  -1 : (tacasoForm.getIdProdXCausa().equals("")) ? -1  : tacasoForm.getIdProdXCausa());
			objJson.put("fiidnaturaleza", tacasoForm.getNaturalezaCaso() == null ?  -1 : (tacasoForm.getNaturalezaCaso().equals("")) ? -1 : tacasoForm.getNaturalezaCaso());		
			
		  //parametro adicionales para el WS de aclaraciones
			objJson.put("canalCU", "1");	
			objJson.put("fcnumcuenta", "1714");	
			objJson.put("fcnumtarjeta", "123456");	
			objJson.put("fiidcanal", 1);	
			objJson.put("fiiddept", 1);	
			objJson.put("fiidorganismo", 1);	
			objJson.put("fiidsucursal", 9999);
			objJson.put("folioCU", "1111");
			objJson.put("paisCU", "6");
			objJson.put("sucursalCU", 333);
			objJson.put("fiidmediorespuesta", 1);
					
			System.out.println("objJson: " +objJson);
		}catch (Exception e) {
		System.out.println("CapturaListaImpl:consultarListaJson "+e.getMessage());
		}
			
		try{
		  RestTemplate restClient = new RestTemplate();
		  respuestaWs = restClient.postForObject("http://10.51.193.199:8080/UEAUMex/rest/servicio/caso/setCaso", objJson, RespuestaGenerica.class);	  
		  if(respuestaWs.getExito().equals("OK")){
			System.out.println("entro en ok!");
			respuestaWs.getExito();
			respuestaWs.getMensaje(); 		  
		   }
		  
		  else{
				respuestaWs.setExito(Constantes.ESTATUS_FAILED);
				respuestaWs.setMensaje(Constantes.MENSAJE_FAILED_INVOCA_CASO_DAO);
				respuestaWs.setCodigoError(Constantes.CODIGO_FAILED_DAO);	
		}
		
	}catch(Exception e){
		respuestaWs.setExito(Constantes.ESTATUS_FAILED);
		respuestaWs.setMensaje(Constantes.MENSAJE_FAILED_CREATE_CASO);
		respuestaWs.setCodigoError(Constantes.CODIGO_FAILED_CREATE);						
	}
	return respuestaWs;	  
  }

	public static RespuestaGenerica getCatalogoProdServ(int idBienContratado){	
		System.out.println("Entro a consultar getCatalogoProdServ()");
		RespuestaGenerica respuestaWs = new RespuestaGenerica();
		JSONArray jsonArray = new JSONArray();
	    try{	 
			jsonArray = CasosReclamoAclCatalagos.getCatalagoProdServObjectJson(idBienContratado);
			
			ArrayList<String> lista= new ArrayList<String>();
			ArrayList<catalagoProdServVO> colBien= new ArrayList<catalagoProdServVO>();
			if (jsonArray != null) {  
			   int len = jsonArray.size();
			    for (int i=0; i<len; i++){ 
			        lista.add(jsonArray.get(i).toString());
					try{									
						int fiidbienxrec=Integer.parseInt(lista.get(i).substring(16).split(",")[0]);								
						String fcdescreclamo=(lista.get(i).substring(34,lista.get(i).length()-1).replace(":",""));	
						System.out.println("fiidbienxrec:" +fiidbienxrec +" " +"fcdescreclamo:"+fcdescreclamo);				
					    colBien.add(new catalagoProdServVO(fiidbienxrec, fcdescreclamo));
						respuestaWs.setListCatProdServ(colBien);		
					   }catch (Exception ex) {
			             System.out.println("Exception: Error al parsear el CatalagoProdServObjectJson" +ex.getMessage());
					  }
			       }
			}else{
				respuestaWs.setExito("FAILED");
				respuestaWs.setMensaje("OCURRIO UNA EXCEPCION AL REALIZAR LA CONSULTA");	
				respuestaWs.setCodigoError(Constantes.CODIGO_FAILED_CONSULTA);	
			}        
		}catch(Exception e){		
			respuestaWs.setExito("FAILED");
			respuestaWs.setMensaje("OCURRIO UNA EXCEPCION AL REALIZAR LA CONSULTA");	
			respuestaWs.setCodigoError(Constantes.CODIGO_FAILED_CONSULTA);
		}	
	return respuestaWs;
  }
	
	public static RespuestaGenerica getCatalogoCausa(int idProducto){	
		System.out.println("Entro a consultar getCatalogoCausa()");
		RespuestaGenerica respuestaWs = new RespuestaGenerica();
		JSONArray jsonArray = new JSONArray();
	    try{	 
			jsonArray = CasosReclamoAclCatalagos.getCatalagoCausaObjectJson(idProducto);
			
			ArrayList<String> lista= new ArrayList<String>();
			ArrayList<catalagoCausasVO> colCausas= new ArrayList<catalagoCausasVO>();
			if (jsonArray != null) {  
			   int len = jsonArray.size();
			    for (int i=0; i<len; i++){ 
			        lista.add(jsonArray.get(i).toString());
					try{									
						int fiidprodxcausa=Integer.parseInt(lista.get(i).substring(18).split(",")[0]);	
						String descCausa=(lista.get(i).substring(32,lista.get(i).length()-1).replace(":", "")); 
						//System.out.println("fiidprodxcausa:" +fiidprodxcausa +" " +"descCausa:"+descCausa);				
						colCausas.add(new catalagoCausasVO(fiidprodxcausa, descCausa));
					    respuestaWs.setListCatCausas(colCausas);
					   }catch (Exception ex) {
			             System.out.println("Exception: Error al parsear el CatalagoCausaObjectJson" +ex.getMessage());
					  }
			       }
			}else{
				respuestaWs.setExito("FAILED");
				respuestaWs.setMensaje("OCURRIO UNA EXCEPCION AL REALIZAR LA CONSULTA");	
				respuestaWs.setCodigoError(Constantes.CODIGO_FAILED_CONSULTA);	
			}        
		}catch(Exception e){		
			respuestaWs.setExito("FAILED");
			respuestaWs.setMensaje("OCURRIO UNA EXCEPCION AL REALIZAR LA CONSULTA");	
			respuestaWs.setCodigoError(Constantes.CODIGO_FAILED_CONSULTA);
		}	
	return respuestaWs;
   }
	
	public static RespuestaGenerica getCatalogoNaturaleza() {
		System.out.println("Entro a consultar getCatalogoNaturaleza()");
		RespuestaGenerica respuestaWs = new RespuestaGenerica();
		JSONArray jsonArray = new JSONArray();
	    try{	 
			jsonArray = CasosReclamoAclCatalagos.getCatalagoNaturalezaObjectJson();
			
			ArrayList<String> lista= new ArrayList<String>();
			ArrayList<catalagoNaturalezaVO> colNatural= new ArrayList<catalagoNaturalezaVO>();
			if (jsonArray != null) {  
			   int len = jsonArray.size();
			    for (int i=0; i<len; i++){ 
			        lista.add(jsonArray.get(i).toString());
					try{									
						int fiidnaturaleza=Integer.parseInt(lista.get(i).substring(18).split(",")[0]);	
						String fcdescripcion=(lista.get(i).substring(36,lista.get(i).length()-1)); 	
						colNatural.add(new catalagoNaturalezaVO(fiidnaturaleza, fcdescripcion));
						System.out.println("fiidnaturaleza:" +fiidnaturaleza +" " +"fcdescripcion:"+fcdescripcion);	
					    respuestaWs.setListCatNaturaleza(colNatural);
					   }catch (Exception ex) {
			             System.out.println("Exception: Error al parsear el CatalagoNaturalezaObjectJson" +ex.getMessage());
					  }
			       }
			}else{
				respuestaWs.setExito("FAILED");
				respuestaWs.setMensaje("OCURRIO UNA EXCEPCION AL REALIZAR LA CONSULTA");	
				respuestaWs.setCodigoError(Constantes.CODIGO_FAILED_CONSULTA);	
			}        
		}catch(Exception e){		
			respuestaWs.setExito("FAILED");
			respuestaWs.setMensaje("OCURRIO UNA EXCEPCION AL REALIZAR LA CONSULTA");	
			respuestaWs.setCodigoError(Constantes.CODIGO_FAILED_CONSULTA);
		}	
	return respuestaWs;
   }


	public static RespuestaGenerica getCatalogoBienCntr() {
		System.out.println("Entro a consultar getCatalogoBienCntr()");
		RespuestaGenerica respuestaWs = new RespuestaGenerica();
		JSONArray jsonArray = new JSONArray();
	    try{	 
			jsonArray = CasosReclamoAclCatalagos.getCatalagoBienCntrObjectJson();
			
			ArrayList<String> lista= new ArrayList<String>();
			ArrayList<catalagoBienCntrVO> colBienCntr= new ArrayList<catalagoBienCntrVO>();
			if (jsonArray != null) {  
			   int len = jsonArray.size();
			    for (int i=0; i<len; i++){ 
			        lista.add(jsonArray.get(i).toString());
					try{									
						int fiidbiencontratado=Integer.parseInt(lista.get(i).substring(22).split(",")[0]);	
						String fcdescripcion=(lista.get(i).substring(40,lista.get(i).length()-1));//.replace(":","").replace((char)34,(char)0));	
						colBienCntr.add(new catalagoBienCntrVO(fiidbiencontratado, fcdescripcion));
						System.out.println("fiidbiencontratado:" +fiidbiencontratado +" " +"fcdescripcion:"+fcdescripcion);	
					    respuestaWs.setListCatBienCntr(colBienCntr);
					   }catch (Exception ex) {
			             System.out.println("Exception: Error al parsear el CatalagoBienCntrObjectJson" +ex.getMessage());
					  }
			       }
			}else{
				respuestaWs.setExito("FAILED");
				respuestaWs.setMensaje("OCURRIO UNA EXCEPCION AL REALIZAR LA CONSULTA");	
				respuestaWs.setCodigoError(Constantes.CODIGO_FAILED_CONSULTA);	
			}        
		}catch(Exception e){		
			respuestaWs.setExito("FAILED");
			respuestaWs.setMensaje("OCURRIO UNA EXCEPCION AL REALIZAR LA CONSULTA");	
			respuestaWs.setCodigoError(Constantes.CODIGO_FAILED_CONSULTA);
		}	
	return respuestaWs;
	}
	
	public static RespuestaGenerica getCatalogoProductos() {
		System.out.println("Entro a consultar getCatalogoProducto()");
		RespuestaGenerica respuestaWs = new RespuestaGenerica();
		JSONArray jsonArray = new JSONArray();
	    try{	 
			jsonArray = CasosReclamoAclCatalagos.getCatalagoProductosObjectJson();
			
			ArrayList<String> lista= new ArrayList<String>();
			ArrayList<catalagoProductoVO> colProductos= new ArrayList<catalagoProductoVO>();
			if (jsonArray != null) {  
			   int len = jsonArray.size();
			    for (int i=0; i<len; i++){ 
			        lista.add(jsonArray.get(i).toString());
					try{									
						int fiidproducto=Integer.parseInt(lista.get(i).substring(16).split(",")[0]);	//PRODUCTOS
						String fcdescripcion=(lista.get(i).substring(34,lista.get(i).length()-1).replace(":",""));	
						colProductos.add(new catalagoProductoVO(fiidproducto, fcdescripcion));
						System.out.println("fiidproducto:" +fiidproducto +" " +"fcdescripcion:"+fcdescripcion);	
					    respuestaWs.setListCatProducto(colProductos);
					   }catch (Exception ex) {
			             System.out.println("Exception: Error al parsear el CatalagoBienCntrObjectJson" +ex.getMessage());
					  }
			       }
			}else{
				respuestaWs.setExito("FAILED");
				respuestaWs.setMensaje("OCURRIO UNA EXCEPCION AL REALIZAR LA CONSULTA");	
				respuestaWs.setCodigoError(Constantes.CODIGO_FAILED_CONSULTA);	
			}        
		}catch(Exception e){		
			respuestaWs.setExito("FAILED");
			respuestaWs.setMensaje("OCURRIO UNA EXCEPCION AL REALIZAR LA CONSULTA");	
			respuestaWs.setCodigoError(Constantes.CODIGO_FAILED_CONSULTA);
		}	
	return respuestaWs;
	}
}
