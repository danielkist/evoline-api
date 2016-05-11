package br.com.evoline.api.model;

import java.io.Serializable;

public class SMS implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String numero_destino;
	
	private String mensagem;
	
	private Boolean resposta_usuario;

	public String getNumeroDestino() {
		return numero_destino;
	}

	public void setNumeroDestino(String numeroDestino) {
		this.numero_destino = numeroDestino;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Boolean getRespostaUsuario() {
		return resposta_usuario;
	}

	public void setRespostaUsuario(Boolean respostaUsuario) {
		this.resposta_usuario = respostaUsuario;
	}

}
