package br.com.evoline.api.http;

import br.com.evoline.api.model.Authorization;

public interface BaseHttp {
	
	/**
	 * HTTP Get
	 * @param authorization
	 * @param endpoint
	 * @return
	 */
	public String call(Authorization authorization, String endpoint);
	
	/**
	 * HTTP Get  => param == null
	 * HTTP Post => param != null
	 * @param authorization
	 * @param endpoint
	 * @param param
	 * @return
	 */
	public String call(Authorization authorization, String endpoint, Object param);

}
