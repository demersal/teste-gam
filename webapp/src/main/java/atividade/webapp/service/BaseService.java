package atividade.webapp.service;

import com.google.gson.Gson;

import atividade.webapp.dto.Status;

public class BaseService {

	protected static String baseUrl;

	static {
		baseUrl = "http://localhost:6699/contato";
	}

	protected Status processaRetorno(String body) {
		Gson g = new Gson();
		Status status = "1".equals(body) ? new Status() : g.fromJson(body, Status.class);
		return status;
	}

}
