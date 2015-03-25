package com.bancoazteca.sagi.UEAUMex.ws.facade;


import java.util.ArrayList;
import java.util.Iterator;

import com.bancoazteca.sagi.UEAUMex.db.AdministradorDelegate;
import com.bancoazteca.sagi.UEAUMex.db.IAdministrador;
import com.bancoazteca.sagi.UEAUMex.modelo.hibernate.base.TaCaso;
import com.bancoazteca.sagi.UEAUMex.modelo.hibernate.base.TaCatBienXRec;
import com.bancoazteca.sagi.UEAUMex.modelo.hibernate.base.TaProXCau;
import com.bancoazteca.sagi.UEAUMex.utileria.Constantes;
import com.bancoazteca.sagi.UEAUMex.utileria.GestorFechas;
import com.bancoazteca.sagi.UEAUMex.ws.beans.TaCasoWs;
import com.bancoazteca.sagi.UEAUMex.ws.beans.TaCatBienxRecWs;
import com.bancoazteca.sagi.UEAUMex.ws.beans.TaProXCauWs;
import com.bancoazteca.sagi.UEAUMex.ws.respuestaws.RespuestaGenerica;

public class CasoFacade{

	static String idPais;
	
	@SuppressWarnings("static-access")
	public CasoFacade(String idPais){
		this.idPais = idPais;
	}
	
	public RespuestaGenerica insertaCasoPeru(TaCasoWs casows)throws Exception{
		
		RespuestaGenerica respuestaWs = new RespuestaGenerica();
		TaCaso caso = null;
		int idCaso = Constantes.DEFAULT_INT;
				
		try{
			IAdministrador objNegocio = AdministradorDelegate.getInstance(idPais);
		
			caso = new TaCaso();
			
			//Datos del servicio
			caso.setFcnumtarjeta(casows.getFcnumtarjeta());
			caso.setFcnumcuenta(casows.getFcnumcuenta());
			caso.setFcnombretutor(casows.getFcnombretutor());
			caso.setFcdireccion(casows.getFcdireccion());
			caso.setFitelefono(casows.getFctelefono());
			caso.setFccorreoelectronico(casows.getFccorreoelectronico());
			caso.setFcidentidad(casows.getFcidentidad());
			caso.setFiiddept(casows.getFiiddept());
			caso.setFiidcanal(casows.getFiidcanal());
			caso.setFiidorganismo(casows.getFiidorganismo());
			caso.setFiidmediorespuesta(casows.getFiidmediorespuesta());
			caso.setFcdescripcion(casows.getFcdescripcion());
			caso.setFiidBien(casows.getFiidbiencontratado());
			caso.setFiidBienXRec(casows.getFiidbienxrec());
			caso.setFiidproxcau(casows.getFiidprodxcausa());
		    caso.setFiidnaturaleza(casows.getFiidnaturaleza());
			caso.setFimontoreclamado(casows.getFimontoreclamado());
			caso.setFcpedido(casows.getFcpedido());
			
			String clienteUnico = casows.getPaisCU() + "-" + casows.getCanalCU() + "-" + casows.getSucursalCU() + "-" + casows.getFolioCU();			
			caso.setFcnumcliente(clienteUnico);
			
			String nombreCliente = casows.getFcnombre() + "|" + casows.getApePat() + "|" + casows.getApeMat();
			caso.setFcnombre(nombreCliente);
			
			String descSucursal = Constantes.DEFAULT_STRING;			
			if(casows.getFiidsucursal() == Constantes.DEFAULT_INT){				
				descSucursal = objNegocio.obtieneSucursal(9999);				
			}else{				
				descSucursal = objNegocio.obtieneSucursal(casows.getFiidsucursal());
			}			
			caso.setFcdescsucursal(descSucursal);
			caso.setFinumsucursal(casows.getFiidsucursal());

			
			//Datos con valores por default
			caso.setTipoOperacion(Constantes.OPCION_UNO);
			caso.setCommitEnbd(Constantes.OPCION_UNO);
			caso.setFiidcaso(0);
			caso.setFcassignado("-1");
			caso.setFiidestatus(new Integer(Constantes.UEAUMEXPERU_Nuevo));
			caso.setFcexpediente(Constantes.DEFAULT_STRING);
			caso.setFiidproxcauxtip(-1);
			caso.setFcreferencia("");
			caso.setFdfechacreacion(GestorFechas.obtenFechaConHoraSTD(GestorFechas.obtenFechaEstandar()));
			caso.setFdfechareclamo(GestorFechas.obtenFechaConHoraSTD(GestorFechas.obtenFechaEstandar()));
			caso.setFdfechaingreso(GestorFechas.obtenFechaConHoraSTD(GestorFechas.obtenFechaEstandar()));
			caso.setFiidconclusion(-1);
			caso.setFiidestatusregistro(1L);
			caso.setFdfechacierre(Constantes.DEFAULT_STRING);
			caso.setFifolioaclaraciones(Constantes.DEFAULT_STRING);
			caso.setFcusuariomodifica("720075");
			caso.setFiestatusaclaracion(Constantes.DEFAULT_INT);
			caso.setFcusuariocreacion("720075");
			caso.setFccomentario(Constantes.DEFAULT_STRING);
			caso.setFcrespuesta(Constantes.DEFAULT_STRING);
			caso.setFdfechaComunicaRespuesta(Constantes.DEFAULT_STRING);
			caso.setFdfechaPlazoRespuesta(GestorFechas.obtenFechaSTD(GestorFechas.sumaAFechaDias(GestorFechas.obtenFechaEstandar(), 30)));
			caso.setFcdocumentosSoporte(Constantes.DEFAULT_STRING);			
			
			////////Guardando Caso//////////
			try{
				idCaso = objNegocio.invocaCasoDAO(caso, Constantes.OPCION_UNO);	
			}catch(Exception e){
				e.printStackTrace();
			}			
	        
			////////Creamos objeto de respuesta/////
			if(idCaso != Constantes.DEFAULT_INT){	
				respuestaWs.setExito(Constantes.ESTATUS_OK);
				respuestaWs.setMensaje(Constantes.MENSAJE_OK_INVOCA_CASO_DAO + idCaso);
			
			}else{
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
	
	public ArrayList<Object> obtenerCatalogoBienxRec(Long idBien){
		
		ArrayList<Object> catalogoReclamos = null;
		ArrayList<Object> arrReclamo = null;		
		RespuestaGenerica response = new RespuestaGenerica();	
		
		try{
			catalogoReclamos = new ArrayList<Object>();
			arrReclamo = new ArrayList<Object>();			
			IAdministrador objNegocio = AdministradorDelegate.getInstance(idPais);
			
			arrReclamo = objNegocio.obtieneListaReclamos(idBien);
			
			Iterator<Object> itRec = arrReclamo.iterator();
			
			while(itRec.hasNext()){
				
				TaCatBienXRec reclamo = (TaCatBienXRec) itRec.next();
				TaCatBienxRecWs reclamows = new TaCatBienxRecWs();
				
				reclamows.setFcdescreclamo(reclamo.getFcdescreclamo());
				reclamows.setFiidbienxrec(reclamo.getFiidbienxrec());
				catalogoReclamos.add(reclamows);				
			}
				
			response.setExito("OK");
			response.setMensaje("CONSULTA REALIZADA CORRECTAMENTE");						
			catalogoReclamos.add(response);
										
		}catch(Exception e){
			
			response.setExito("FAILED");
			response.setMensaje("OCURRIO UNA EXCEPCION AL REALIZAR LA CONSULTA");	
			response.setCodigoError(Constantes.CODIGO_FAILED_CONSULTA);
			catalogoReclamos.add(response);
			
		}
		
		return catalogoReclamos;
	}
	
	public ArrayList<Object> obtenerCatalogoCausa(Long idProducto)throws Exception{
		
		ArrayList<Object> catalogoCausa = new ArrayList<Object>();
		ArrayList<Object> arrCausas = new ArrayList<Object>();		
		RespuestaGenerica response = new RespuestaGenerica();	
		
		try{
			IAdministrador objNegocio = AdministradorDelegate.getInstance(idPais);
			
			arrCausas = objNegocio.obtieneListaCausasL2(idProducto);
			
			Iterator<Object> itCausa = arrCausas.iterator();
			
			while(itCausa.hasNext()){
				
				TaProXCau causa =(TaProXCau) itCausa.next();
				
				TaProXCauWs causaws = new TaProXCauWs();
				causaws.setFiidprodxcausa(causa.getFiidprodxcausa());
				causaws.setDescCausa(causa.getDescCausa());
			
				catalogoCausa.add(causaws);
			}
			
			response.setExito("OK");
			response.setMensaje("CONSULTA REALIZADA CORRECTAMENTE");						
			catalogoCausa.add(response);
			
			
		}catch(Exception e){
			
			response.setExito("FAILED");
			response.setMensaje("OCURRIO UNA EXCEPCION AL REALIZAR LA CONSULTA");	
			response.setCodigoError(Constantes.CODIGO_FAILED_CONSULTA);
			catalogoCausa.add(response);
		}
		
		return catalogoCausa;
	}
	
}
