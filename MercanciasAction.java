	package com.bancoazteca.planlealtadweb.mercancias.action;

	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.OutputStream;
	import java.net.UnknownHostException;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Properties;
	import java.util.StringTokenizer;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.apache.log4j.Logger;
	import org.apache.struts.action.ActionForm;
	import org.apache.struts.action.ActionForward;
	import org.apache.struts.action.ActionMapping;
	import org.apache.struts.actions.DispatchAction;

	import com.bancoazteca.planlealtadweb.mercancias.SambaFile;
	import com.bancoazteca.planlealtadweb.util.PropertiesUtil;

	public class MercanciasAction extends DispatchAction {

		private Logger logger = Logger.getLogger(MercanciasAction.class);

		private static final long serialVersionUID = -407759304044487950L;

		String carpetaB;

		public ActionForward obtenerPdf(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			logger.info("Entro a ActionForward obtenerPdf");
			String folio = "";
			folio = request.getParameter("folio");
			System.out.println("Folio: " + folio);

			Properties properties = null;
			try {
				properties = PropertiesUtil.getProperties("mercancia.properties");
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (properties != null) {
				String host = properties.getProperty("samba.pdf.url");
				String dominio = properties.getProperty("samba.pdf.dominio");
				String usuario = properties.getProperty("samba.pdf.usuario");
				String passwrd = properties.getProperty("samba.pdf.pass");
				System.out.println("Nombre del archivo: " + host + "/" + folio);

				SambaFile file = new SambaFile();
				try {
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition", "inline;filename="+ folio);
					response.setHeader("Cache-Control", "cache, must-revalidate");
					response.setHeader("Pragma", "public");

					InputStream archivo = file.bajarArchivo(host + "/" + carpetaB+ "/" + folio, dominio, usuario, passwrd);
					OutputStream outputStream = response.getOutputStream();
					System.out.println("bajar el archivo....");

					byte bytes[] = new byte[1024];
					int leidos = 0;

					while ((leidos = archivo.read(bytes, 0, 1024)) != -1) 
						outputStream.write(bytes, 0, leidos);
					
					outputStream.flush();
					outputStream.close();
					archivo.close();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (UnknownHostException e) {
					// e.printStackTrace();
				} catch (IllegalStateException e) {
					System.out
							.println("???????????????????????????????????????????");
				} catch (Exception e) {
					// e.printStackTrace();
				}
			}
			folio = "";
			return mapping.findForward("success");
		}

		public ActionForward obtenerPdfD(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			logger.info("+++---+++ en obtener pdfD +++---+++");
			String URL = request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + request.getContextPath();
			logger.info("URL: " + URL);
			carpetaB = request.getSession().getAttribute("carpeta").toString();
			request.getSession().removeAttribute("carpeta");
			logger.info("Carpeta: " + carpetaB);
			Properties properties = null;
			try {
				properties = PropertiesUtil.getProperties("mercancia.properties");
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (properties != null) {
				String host = properties.getProperty("samba.pdf.url");
				String dominio = properties.getProperty("samba.pdf.dominio");
				String usuario = properties.getProperty("samba.pdf.usuario");
				String passwrd = properties.getProperty("samba.pdf.pass");

				String lista = "";
				try {
					lista = SambaFile.listarArchivos(host + "/" + carpetaB + "/",dominio, usuario, passwrd);
					logger.info("Conectando a " + host + "/" + carpetaB + "/");
					logger.info("listarArchivos:" + lista);
					List<String> listaArchivo = new ArrayList<String>();
					String temp = null;
					if (lista != null && lista.length() > 0) {
						StringTokenizer token = new StringTokenizer(lista, "\n");
						while (token.hasMoreTokens()) {

							temp = token.nextToken();
							if (temp.contains(".pdf")) {
								listaArchivo.add(temp);
							}
						}
					}

					Iterator<String> iter = listaArchivo.iterator();
					while (iter.hasNext()) {
						String aux = iter.next();
						logger.info("##### archivo PDF:" + aux);
					}

					String tabla;
					tabla = "<table align='center' width='90%' cellpadding='3px' cellspacing='0'>";
					if (listaArchivo != null && listaArchivo.size() > 0) {
						int index = 0;
						while (index < listaArchivo.size()) {
							String aux = listaArchivo.get(index);
							tabla = tabla
									+ "<tr align='center'><td><img src='"
									+ request.getContextPath()
									+ "/images/pdf.png' width='27' height='32' border='0'>"
									+ "</td><td align='left'><a href='"
									+ URL
									+ "/pdfpublica/PdfAction.do?method=obtenerPdf&folio="
									+ aux + "' target='_blank'>" + aux
									+ "</a></td></tr>";
							index++;
						}
					}
					tabla = tabla + "</table>";
					request.getSession().setAttribute("tabla", tabla);

				} catch (Exception e) {
					logger.info("+++--- excepcion:" + e.getMessage());
					e.printStackTrace();
				}
			}

			if (carpetaB.equals("Reclamos")) {
				return mapping.findForward("successReclamo");
			} else {
				return mapping.findForward("successReclamo");
			}
		}
	}
