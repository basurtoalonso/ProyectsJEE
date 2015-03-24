
package com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos;

import java.io.Serializable;

public class catalagoBienCntrVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int fiidbiencontratado;
	private String fcdescripcion;

	public catalagoBienCntrVO(int fiidbiencontratado, String fcdescripcion) {
		this.fiidbiencontratado=fiidbiencontratado;
		this.fcdescripcion=fcdescripcion;	
	}

	public int getFiidbiencontratado() {
		return fiidbiencontratado;
	}

	public void setFiidbiencontratado(int fiidbiencontratado) {
		this.fiidbiencontratado = fiidbiencontratado;
	}

	public String getFcdescripcion() {
		return fcdescripcion;
	}

	public void setFcdescripcion(String fcdescripcion) {
		this.fcdescripcion = fcdescripcion;
	}

	@Override
	public String toString() {
		return "catalagoBienCntrVO [fcdescripcion=" + fcdescripcion
				+ ", fiidbiencontratado=" + fiidbiencontratado + "]";
	}

}
