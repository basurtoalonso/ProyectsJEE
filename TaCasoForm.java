
package com.bancoazteca.ebanking.web.bean.ws;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class TaCasoForm extends ActionForm implements Serializable{

	private static final long serialVersionUID = 1L;

	private String metodo;
	private String opcion;
	
	private String nombre;
	private String apePat;
	private String apeMat;
	private String nombreTutor;
	private String email;
	private String direccion;
	private String telefono;
	private String identidad;
	private String descripcionReclamo;
	
	private Long bienContratado;
	private Long idBienXRec;
	private Long idProdXCausa;
	private Long naturalezaCaso;
	private int tipoProdServ;
	
	private Double montoReclamo;
	private String pedido;
	
	
	public int getTipoProdServ() {
		return tipoProdServ;
	}

	public void setTipoProdServ(int tipoProdServ) {
		this.tipoProdServ = tipoProdServ;
	}

	public Long getIdProdXCausa() {
		return idProdXCausa;
	}

	public void setIdProdXCausa(Long idProdXCausa) {
		this.idProdXCausa = idProdXCausa;
	}

	public Long getIdBienXRec() {
		return idBienXRec;
	}

	public void setIdBienXRec(Long idBienXRec) {
		this.idBienXRec = idBienXRec;
	}

	public String getIdentidad() {
		return identidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setIdentidad(String identidad) {
		this.identidad = identidad;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApePat() {
		return apePat;
	}

	public void setApePat(String apePat) {
		this.apePat = apePat;
	}

	public String getApeMat() {
		return apeMat;
	}

	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}

	public String getNombreTutor() {
		return nombreTutor;
	}

	public void setNombreTutor(String nombreTutor) {
		this.nombreTutor = nombreTutor;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDescripcionReclamo() {
		return descripcionReclamo;
	}

	public void setDescripcionReclamo(String descripcionReclamo) {
		this.descripcionReclamo = descripcionReclamo;
	}

	public Long getBienContratado() {
		return bienContratado;
	}

	public void setBienContratado(Long bienContratado) {
		this.bienContratado = bienContratado;
	}

	public Long getNaturalezaCaso() {
		return naturalezaCaso;
	}

	public void setNaturalezaCaso(Long naturalezaCaso) {
		this.naturalezaCaso = naturalezaCaso;
	}

	public Double getMontoReclamo() {
		return montoReclamo;
	}

	public void setMontoReclamo(Double montoReclamo) {
		this.montoReclamo = montoReclamo;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	
	public String getNombreCompleto() {
		StringBuffer buffer = new StringBuffer();
		if( nombre != null ) buffer.append(nombre.trim());
		if( apePat != null ) {
			if( buffer.length() != 0 ) buffer.append(" ");
			buffer.append(apePat.trim() );
			if( buffer.length() != 0 ) {
				buffer.append(" ");
				if(apeMat != null )
					buffer.append(apeMat.trim() );
			}
		}
		return buffer.toString();
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		nombre = null;
		apePat = null;
		apeMat = null;;
		nombreTutor = null;
		email = null;
		direccion = null;
		telefono = null;
	}

	
   /* public String toString() {
	String res= String.format("fcnombre:%s,apePat:%s,apeMat:%s,fcdescripcion:%s,fcdireccion:%s", fcnombre, apePat, apeMat, fcdescripcion, fcdireccion);
    return res;
   }*/
	
}
