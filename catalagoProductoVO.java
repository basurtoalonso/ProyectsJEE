package com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos;

public class catalagoProductoVO {

	private static final long serialVersionUID = 1L;
	
	private int fiidproducto;
	private String fcdescripcion;

	public catalagoProductoVO(int fiidproducto, String fcdescripcion) {
		this.fiidproducto=fiidproducto;
		this.fcdescripcion=fcdescripcion;	
	}

	public int getFiidproducto() {
		return fiidproducto;
	}

	public void setFiidproducto(int fiidproducto) {
		this.fiidproducto = fiidproducto;
	}

	public String getFcdescripcion() {
		return fcdescripcion;
	}

	public void setFcdescripcion(String fcdescripcion) {
		this.fcdescripcion = fcdescripcion;
	}

	@Override
	public String toString() {
		return "catalagoProductoServicioVO [fcdescripcion=" + fcdescripcion
				+ ", fiidproducto=" + fiidproducto + "]";
	}

}
