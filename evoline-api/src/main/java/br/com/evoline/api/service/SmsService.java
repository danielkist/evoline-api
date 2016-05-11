package br.com.evoline.api.service;

import br.com.evoline.api.model.ApiResponse;
import br.com.evoline.api.model.Authorization;
import br.com.evoline.api.model.SMS;
import br.com.evoline.api.service.base.EvolineBaseService;

public class SmsService extends EvolineBaseService {
	
	public SmsService(Authorization auth) {
		super(auth);
	}

	public ApiResponse send(SMS arg0) {
		String response = super.getHttp().call(super.auth, "/sms", arg0);
		ApiResponse api = super.getGson().fromJson(response, ApiResponse.class);
		return api;
	}

}
