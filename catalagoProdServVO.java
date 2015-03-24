
package com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos;

import java.io.Serializable;

public class catalagoProdServVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int fiidbienxrec;
	private String fcdescreclamo;

	public catalagoProdServVO() {}
	
	public catalagoProdServVO(int fiidbienxrec, String fcdescreclamo) {
		this.fiidbienxrec=fiidbienxrec;
		this.fcdescreclamo=fcdescreclamo;	
	}

	public int getFiidbienxrec() {
		return fiidbienxrec;
	}

	public void setFiidbienxrec(int fiidbienxrec) {
		this.fiidbienxrec = fiidbienxrec;
	}

	public String getFcdescreclamo() {
		return fcdescreclamo;
	}

	public void setFcdescreclamo(String fcdescreclamo) {
		this.fcdescreclamo = fcdescreclamo;
	}

	@Override
	public String toString() {
		return "catalagoProdServVO [fcdescreclamo=" + fcdescreclamo
				+ ", fiidbienxrec=" + fiidbienxrec + "]";
	}
	
}
