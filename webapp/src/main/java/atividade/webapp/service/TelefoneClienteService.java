package atividade.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import atividade.webapp.dto.Status;
import atividade.webapp.model.TelefoneCliente;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class TelefoneClienteService extends BaseService {
	
	private static TelefoneClienteService instance;
	
	public static final String ID_TELEFONE = "id_telefone";
	public static final String CD_CLIENTE = "cd_cliente";
	public static final String CD_TIPO_TELEFONE = "cd_tipo_telefone";
	public static final String NR_TELEGONE = "nr_telefone";
	
	public static TelefoneClienteService getInstance() {
		return instance == null ? instance = new TelefoneClienteService() : instance;
	}
	
	public Status insert(TelefoneCliente telefoneCliente) {
		String route = "/telefonecli/add";
		JSONObject json = new JSONObject();
			
		json.put(CD_CLIENTE, telefoneCliente.getCdCliente());
		json.put(CD_TIPO_TELEFONE, telefoneCliente.getCdTipoTelefone());
		json.put(NR_TELEGONE, telefoneCliente.getNrTelefone());
		HttpResponse<String> response = Unirest.post(baseUrl + route)
				  .header("content-type", "application/json")
				  .body(json.toString())
				  .asString();
		String body = response.getBody();
		System.out.println(body);
		Status status = processaRetorno(body);
		return status;
	}
	
	public List<TelefoneCliente> findAllByCliente(Long cdCliente) {
		String route = "/telefonescli/?cd_cliente=" + String.valueOf(cdCliente);
		
		HttpResponse<String> response = Unirest.get(baseUrl + route).asString();
		
		JSONArray array = new JSONArray(response.getBody());
		JSONObject jsonObject;
		List<TelefoneCliente> list = new ArrayList<TelefoneCliente>();
		TelefoneCliente telefoneCliente;
		for (int i = 0; i < array.length(); i++) {
			jsonObject = new JSONObject(array.get(i).toString());
			telefoneCliente = new TelefoneCliente();
			telefoneCliente.setIdTelefone(jsonObject.getLong(ID_TELEFONE));
			telefoneCliente.setCdCliente(jsonObject.getLong(CD_CLIENTE));
			telefoneCliente.setCdTipoTelefone(jsonObject.getLong(CD_TIPO_TELEFONE));
			telefoneCliente.setNrTelefone(jsonObject.getString(NR_TELEGONE));
			list.add(telefoneCliente);
		}
		return list;
	}
	


}
