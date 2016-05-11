package br.com.evoline.api.model;

import java.io.Serializable;

public class Authorization implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String token;
	
	public static Authorization getInstance(String token) {
		Authorization inst = new Authorization();
		inst.setToken(token);
		return inst;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
}
