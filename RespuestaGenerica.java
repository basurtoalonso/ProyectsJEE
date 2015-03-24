package com.bancoazteca.ebanking.web.bean.ws;

import java.io.Serializable;
import java.util.ArrayList;

import com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos.catalagoBienCntrVO;
import com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos.catalagoCausasVO;
import com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos.catalagoNaturalezaVO;
import com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos.catalagoProdServVO;
import com.bancoazteca.ebanking.web.aclaraciones.Wscatalagos.catalagoProductoVO;

public class RespuestaGenerica extends entityBeanGenerico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	ArrayList<catalagoProdServVO> listCatProdServ;
	ArrayList<catalagoCausasVO> listCatCausas;
	ArrayList<catalagoNaturalezaVO> listCatNaturaleza;
	ArrayList<catalagoProductoVO> listCatProducto;
	
	ArrayList<catalagoBienCntrVO> listCatBienCntr;

	public ArrayList<catalagoProdServVO> getListCatProdServ() {
		return listCatProdServ;
	}
	public void setListCatProdServ(ArrayList<catalagoProdServVO> listCatProdServ) {
		this.listCatProdServ = listCatProdServ;
	}
	
	public ArrayList<catalagoCausasVO> getListCatCausas() {
		return listCatCausas;
	}
	public void setListCatCausas(ArrayList<catalagoCausasVO> listCatCausas) {
		this.listCatCausas = listCatCausas;
	}
	
	public ArrayList<catalagoNaturalezaVO> getListCatNaturaleza() {
		return listCatNaturaleza;
	}
	public void setListCatNaturaleza(ArrayList<catalagoNaturalezaVO> listCatNaturaleza) {
		this.listCatNaturaleza = listCatNaturaleza;
	}

	public ArrayList<catalagoBienCntrVO> getListCatBienCntr() {
		return listCatBienCntr;
	}

	public void setListCatBienCntr(ArrayList<catalagoBienCntrVO> listCatBienCntr) {
		this.listCatBienCntr = listCatBienCntr;
	}

	public ArrayList<catalagoProductoVO> getListCatProducto() {
		return listCatProducto;
	}
	
	public void setListCatProducto(ArrayList<catalagoProductoVO> listCatProducto) {
		this.listCatProducto = listCatProducto;
	}

	@Override
	public String toString() {
		return listCatCausas +"";
	}
	
	
}
