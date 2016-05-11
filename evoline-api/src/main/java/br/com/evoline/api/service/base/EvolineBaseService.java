package br.com.evoline.api.service.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.evoline.api.http.BaseHttp;
import br.com.evoline.api.http.BaseHttpBuilder;
import br.com.evoline.api.model.Authorization;

public abstract class EvolineBaseService {
	
	protected final Authorization auth;
	
	private final Gson gson  = new GsonBuilder().create();
	
	private final BaseHttp http = new BaseHttpBuilder();
	
	public EvolineBaseService(Authorization auth) {
		this.auth = auth;
	}
	
	protected BaseHttp getHttp() {
		return this.http;
	}
	
	protected Gson getGson() {
		return this.gson;
	}

}
