package com.trocajogo.defs;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Mensagem")
public class Retorno {

	private int codResultado;
	private String msgResultado;
	
	public Retorno(){
		this.codResultado = 0;
		this.msgResultado = "";
	}
	
	public Retorno(int codResultado, String msgResultado) {
		super();
		this.codResultado = codResultado;
		this.msgResultado = msgResultado;
	}
	

	public int getCodResultado() {
		return codResultado;
	}

	public void setCodResultado(int codResultado) {
		this.codResultado = codResultado;
	}

	public String getMsgResultado() {
		return msgResultado;
	}

	public void setMsgResultado(String msgResultado) {
		this.msgResultado = msgResultado;
	}

}
