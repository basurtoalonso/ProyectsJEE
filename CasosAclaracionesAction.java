package com.bancoazteca.ebanking.web.aclaraciones.action;

import java.io.File;
import java.util.StringTokenizer;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bancoazteca.ebanking.web.bean.ws.RespuestaGenerica;
import com.bancoazteca.ebanking.web.bean.ws.TaCasoForm;

import com.bancoazteca.ebanking.web.util.mail.Label;
import com.bancoazteca.ebanking.web.util.mail.MailAcl;
import com.bancoazteca.ebanking.web.util.mail.MailException;
import com.bancoazteca.ebanking.web.util.mail.aclaraciones.MailConfirmacion;

public class CasosAclaracionesAction extends DispatchAction {

	public CasosAclaracionesAction() {}

	private Logger log = Logger.getLogger(CasosAclaracionesAction.class);
	private static final long serialVersionUID = -407759304044487950L;

	public ActionForward setCasoReclamoAcl(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		log.info("Entro a ActionForward setCasoReclamoAcl!");

		RespuestaGenerica responseWS = new RespuestaGenerica();
		HttpSession sesion = request.getSession(false);
		TaCasoForm tacasoForm = (TaCasoForm) form;
		String folio=null;
		
		try {
            String tipoNaturaleza = obtieneNaturaleza(tacasoForm.getNaturalezaCaso() == null ?  -1 
            		: (tacasoForm.getNaturalezaCaso().equals("")) ? -1 : tacasoForm.getNaturalezaCaso());
			
			responseWS = CasosReclamoAclWs.setCasoPeru(tacasoForm);

			if (responseWS != null) {
				System.out.println("entro a responseReclamoWS");
				if(responseWS.getMensaje().indexOf("IDCASO=") == -1){
					
					folio = responseWS.getMensaje().substring(43, responseWS.getMensaje().length()-1);		
					sesion.setAttribute("exito",  "SU " +tipoNaturaleza+" SE REGISTRO CON FOLIO # "+folio+ " Estatus:" +responseWS.getExito());		
					
						try {//Envio de mail
							//String path = getServlet().getServletContext().getRealPath("images")+File.separator+"banners";
							MailAcl mail = new MailConfirmacion(tacasoForm.getEmail());
							//mail.setPathBanners(path);
							mail.addCampo(Label.Nombre_Cliente, tacasoForm.getNombreCompleto());
							
							mail.crearMensaje();
							mail.enviar();		
						}
						catch(MailException ex){
							log.info("Exception del proceso :: ", ex);
						}
					
					return mapping.findForward("successCaso");
				}

				else {
					sesion.setAttribute("errorMensaje", "Estatus:"
							+ responseWS.getExito() + " " + "Message:"
							+ responseWS.getMensaje() + " " + "CodigoError:"
							+ responseWS.getCodigoError());
					return mapping.findForward("errorWS");
				}
			}

		} catch (Exception ex) {
			System.out.println("Entro a cachear el error del WS");
			sesion.setAttribute("errorMensaje", ex.getMessage());
			return mapping.findForward("errorWS");
		}	

		return mapping.findForward("successCaso");

	}

	public ActionForward setCasoConsultaAcl(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		log.info("Entro a ActionForward setCasoConsultaAcl!");

		RespuestaGenerica responseWS = new RespuestaGenerica();
		HttpSession sesion = request.getSession(false);
		TaCasoForm tacasoForm = (TaCasoForm) form;
		String folio =null;

		try {			
            String tipoNaturaleza = obtieneNaturaleza(tacasoForm.getNaturalezaCaso() == null ?  -1 
            		: (tacasoForm.getNaturalezaCaso().equals("")) ? -1 : tacasoForm.getNaturalezaCaso());
            
			responseWS = CasosReclamoAclWs.setCasoPeru(tacasoForm);

			if (responseWS != null) {
				System.out.println("entro a responseConsultaWS");
				if(responseWS.getMensaje().indexOf("IDCASO=") == -1){
					
					folio =  responseWS.getMensaje().substring(43, responseWS.getMensaje().length()-1);			
					sesion.setAttribute("exito",  "SU " +tipoNaturaleza+" SE REGISTRO CON FOLIO # "+folio+ " Estatus:" +responseWS.getExito());
					        
						/*try {//Envio de mail
							String path = getServlet().getServletContext().getRealPath("images")+File.separator+"banners";
							MailAcl mail = new MailConfirmacion(tacasoForm.getEmail());
							mail.setPathBanners(path);
							mail.addCampo(Label.Nombre_Cliente, tacasoForm.getNombreCompleto());
							
							mail.crearMensaje();
							mail.enviar();		
						}
						catch(MailException ex){
							log.info("Exception del proceso :: ", ex);
						}*/
					
					return mapping.findForward("successCaso");
				}

				else {
					sesion.setAttribute("errorMensaje", "Estatus:"
							+ responseWS.getExito() + " " + "Message:"
							+ responseWS.getMensaje() + " " + "CodigoError:"
							+ responseWS.getCodigoError());
					return mapping.findForward("errorWS");
				}
			}

		} catch (Exception ex) {
			System.out.println("Entro a cachear el error del WS");
			sesion.setAttribute("errorMensaje", ex.getMessage());
			return mapping.findForward("errorWS");
		}
		
		return mapping.findForward("successCaso");
	}

	public String obtieneBienCntr(HttpServletRequest request) throws Exception {//NO SE OCUPA POR DEFAULT Combo: Producto/Servicio
		System.out.println("entro a obtieneBienCntr()");
		RespuestaGenerica respuestaCatobtieneBienCntr = new RespuestaGenerica();
		StringBuffer cadena = new StringBuffer();
		String resultado = "";

		try {
			respuestaCatobtieneBienCntr = CasosReclamoAclWs.getCatalogoBienCntr();
			if (respuestaCatobtieneBienCntr != null) {
				cadena = cadena.append(respuestaCatobtieneBienCntr.getListCatBienCntr());
				cadena.deleteCharAt(cadena.length() - 1);
				resultado = cadena.toString();
			} else {
				cadena = cadena.append("Error! Por el momento no podemos atender su petición, INTENTE MAS TARDE");
				resultado = cadena.toString();
			}
		} catch (Exception ex) {
			System.out.println("Exception: Error al consultar getCatalogoBienCntr()!"+ ex.getMessage());
		}

		return resultado.toLowerCase();
	}
	
	public String obtieneProdServ(int idBienContratado, HttpServletRequest request) throws Exception {
		System.out.println("entro a obtieneProdServ()");
		RespuestaGenerica respuestaCatProdServ = new RespuestaGenerica();
		StringBuffer cadena = new StringBuffer();
		String resultado = "";
		System.out.println("idBienContratado: " + idBienContratado);

		try {
			respuestaCatProdServ = CasosReclamoAclWs.getCatalogoProdServ(idBienContratado);					
			
			if (respuestaCatProdServ != null) {
				cadena = cadena.append(respuestaCatProdServ.getListCatProdServ());
				cadena.deleteCharAt(cadena.length() - 1);
				resultado = cadena.toString();
			} else {
				cadena = cadena.append("Error al consultar el WS! INTENTE MAS TARDE");
			}
		} catch (Exception ex) {
			System.out.println("Exception: Error al consultar getCatalogoProdServ()!"+ ex.getMessage());
		}
		
		return resultado.toLowerCase();
	}
	
	public String obtieneNaturaleza(HttpServletRequest request)throws Exception {
		System.out.println("entro a obtieneNaturaleza()");
		RespuestaGenerica respuestaCatNaturaleza = new RespuestaGenerica();
		StringBuffer cadena = new StringBuffer();
		String resultado = "";

		try {
			respuestaCatNaturaleza = CasosReclamoAclWs.getCatalogoNaturaleza();
			if (respuestaCatNaturaleza != null) {
				cadena = cadena.append(respuestaCatNaturaleza.getListCatNaturaleza());
				cadena.deleteCharAt(cadena.length() - 1);
				resultado = cadena.toString();
			} else {
				cadena = cadena.append("Error! Por el momento no podemos atender su petición, INTENTE MAS TARDE");
				resultado = cadena.toString();
			}
		} catch (Exception ex) {
			System.out.println("Exception: Error al consultar getCatalogoNaturaleza()!"+ ex.getMessage());
		}

	return resultado.toLowerCase();
 }

	public String obtieneCausas(int idProducto, HttpServletRequest request) throws Exception {
		System.out.println("entro a obtieneCausas()");
		RespuestaGenerica respuestaCatCausas = new RespuestaGenerica();
		StringBuffer cadena = new StringBuffer();
		String resultado = "";

		try {
			respuestaCatCausas = CasosReclamoAclWs.getCatalogoCausa(idProducto);
			if (respuestaCatCausas != null) {
				System.out.println("jsonArray CAUSA: " +respuestaCatCausas.toString());			
				StringTokenizer st;
				String[] datos = null;
				st = new StringTokenizer(respuestaCatCausas.toString(), "]");
			    int nDatos=st.countTokens();
			    datos=new String[nDatos];
				int i=0;
					  while(st.hasMoreTokens()) {
						  String str=st.nextToken();
						  datos[i] = str.replace((char)34,(char)0); 					  				  
						  cadena = cadena.append(datos[i]).append('#');
				          i++;
					   }					
					resultado = cadena.toString();
					System.out.println("resultado: " +resultado);
			} else {
				cadena = cadena.append("Error! Por el momento no podemos atender su petición, INTENTE MAS TARDE");
				resultado = cadena.toString();
			}
		} catch (Exception ex) {
			System.out.println("Exception: Error al consultar getCatalogoProdServ()!"+ ex.getMessage());
		}

		return resultado.toLowerCase();
	}
	
	public String obtieneProducto(HttpServletRequest request) throws Exception {
		System.out.println("entro a obtieneProducto()");
		RespuestaGenerica respuestaCatobtieneProducto = new RespuestaGenerica();
		StringBuffer cadena = new StringBuffer();
		String resultado = "";

		try {
			respuestaCatobtieneProducto = CasosReclamoAclWs.getCatalogoProductos();
			if (respuestaCatobtieneProducto != null) {
				cadena = cadena.append(respuestaCatobtieneProducto.getListCatProducto());
				cadena.deleteCharAt(cadena.length() - 1);
				resultado = cadena.toString();
			} else {
				cadena = cadena.append("Error! Por el momento no podemos atender su petición, INTENTE MAS TARDE");
				resultado = cadena.toString();
			}
		} catch (Exception ex) {
			System.out.println("Exception: Error al consultar getCatalogoProducto()!"+ ex.getMessage());
		}

		return resultado.toLowerCase();
	}
	
	public static String obtieneNaturaleza(Long naturaleza){
		if(naturaleza==1){
			return "DENUNCIA";
		}else if(naturaleza==2){
			return "RECLAMO";
		}else if(naturaleza==6){
			return "QUEJA";
		}else{
		return "CONSULTA";	
		}	
	}
}
