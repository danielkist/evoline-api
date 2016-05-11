package br.com.evoline.api.model;

import java.io.Serializable;

import com.google.gson.internal.LinkedTreeMap;

public class ApiResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	
	private Boolean sucesso;
	
	private Integer motivo;
	
	private String mensagem;
	
	private LinkedTreeMap dados;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getSucesso() {
		return sucesso;
	}

	public void setSucesso(Boolean sucesso) {
		this.sucesso = sucesso;
	}

	public Integer getMotivo() {
		return motivo;
	}

	public void setMotivo(Integer motivo) {
		this.motivo = motivo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public LinkedTreeMap getDados() {
		return dados;
	}

	public void setDados(LinkedTreeMap dados) {
		this.dados = dados;
	}

}
