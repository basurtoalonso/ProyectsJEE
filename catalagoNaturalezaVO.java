package com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos;

public class catalagoNaturalezaVO {

	private static final long serialVersionUID = 1L;
	
	private int fiidnaturaleza;
	private String fcdescripcion;

	public catalagoNaturalezaVO(int fiidnaturaleza, String fcdescripcion) {
		this.fiidnaturaleza=fiidnaturaleza;
		this.fcdescripcion=fcdescripcion;	
	}
	
	public int getFiidnaturaleza() {
		return fiidnaturaleza;
	}

	public void setFiidnaturaleza(int fiidnaturaleza) {
		this.fiidnaturaleza = fiidnaturaleza;
	}

	public String getFcdescripcion() {
		return fcdescripcion;
	}

	public void setFcdescripcion(String fcdescripcion) {
		this.fcdescripcion = fcdescripcion;
	}

	@Override
	public String toString() {
		return "catalagoNaturalezaVO [fcdescripcion=" + fcdescripcion
				+ ", fiidnaturaleza=" + fiidnaturaleza + "]";
	}
}
