package com.bancoazteca.ebanking.web.bean.ws;

public class entityBeanGenerico {

	String mensaje;
	String exito;
	String codigoError;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getExito() {
		return exito;
	}

	public void setExito(String exito) {
		this.exito = exito;
	}

	public String getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}
}
