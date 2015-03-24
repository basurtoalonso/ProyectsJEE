
package com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos;

import java.io.Serializable;

public class catalagoCausasVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idprodxcausa;
	private String descCausa;

	public catalagoCausasVO(int idprodxcausa, String descCausa) {
		this.idprodxcausa=idprodxcausa;
		this.descCausa=descCausa;	
	}
	
	public int getIdprodxcausa() {
		return idprodxcausa;
	}

	public void setIdprodxcausa(int idprodxcausa) {
		this.idprodxcausa = idprodxcausa;
	}

	public String getDescCausa() {
		return descCausa;
	}
	
	public void setDescCausa(String descCausa) {
		this.descCausa = descCausa;
	}

	@Override
	public String toString() {
		return "descCausa=" + descCausa + ", idprodxcausa="
				+ idprodxcausa + "]";
	}
}
