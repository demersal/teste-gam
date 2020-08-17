package atividade.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import atividade.webapp.dto.Status;
import atividade.webapp.model.Cliente;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class ClienteService extends BaseService {

	private static ClienteService instance;

	public static final String NR_CPF_CLIENTE = "nr_cpf_cliente";
	public static final String NM_CLIENTE = "nm_cliente";
	public static final String DS_EMAIL_CLIENTE = "ds_email_cliente";
	public static final String CD_CLIENTE = "cd_cliente";

	public static ClienteService getInstance() {
		return instance == null ? instance = new ClienteService() : instance;
	}

	public Cliente findClienteById(String id) {
		HttpResponse<String> response = Unirest.get(baseUrl + "/cliente/id?id=" + id).asString();
		JSONObject jsonObject = new JSONObject(response.getBody());

		Cliente cliente = new Cliente();
		cliente.setCdCliente(jsonObject.getLong(CD_CLIENTE));
		cliente.setNrCpfCliente(jsonObject.getLong(NR_CPF_CLIENTE));
		cliente.setNmCliente(jsonObject.getString(NM_CLIENTE));
		cliente.setDsEmailCliente(jsonObject.getString(DS_EMAIL_CLIENTE));

		return cliente;
	}

	public Status insertOrUpdateCliente(Cliente cliente) {
		String route = "/cliente/add";
		JSONObject json = new JSONObject();
		if (cliente.getCdCliente() != null) {
			route = "/cliente/modify";
			json.put(CD_CLIENTE, cliente.getCdCliente());
		}

		json.put(NR_CPF_CLIENTE, cliente.getNrCpfCliente());
		json.put(NM_CLIENTE, cliente.getNmCliente());
		json.put(DS_EMAIL_CLIENTE, cliente.getDsEmailCliente());
		HttpResponse<String> response = Unirest.post(baseUrl + route).header("content-type", "application/json")
				.body(json.toString()).asString();
		String body = response.getBody();
		System.out.println(body);
		Status status = processaRetorno(body);
		return status;
	}

	public List<Cliente> findClientes(String param) {
		String route = "/clientes";
		route += param != null ? "/" + param : "";
		HttpResponse<String> response = Unirest.get(baseUrl + route).asString();
		JSONArray array = new JSONArray(response.getBody());
		JSONObject jsonObject;
		List<Cliente> list = new ArrayList<Cliente>();
		Cliente cliente;
		for (int i = 0; i < array.length(); i++) {
			jsonObject = new JSONObject(array.get(i).toString());
			cliente = new Cliente();
			cliente.setCdCliente(jsonObject.getLong(CD_CLIENTE));
			cliente.setNrCpfCliente(jsonObject.getLong(NR_CPF_CLIENTE));
			cliente.setNmCliente(jsonObject.getString(NM_CLIENTE));
			cliente.setDsEmailCliente(jsonObject.getString(DS_EMAIL_CLIENTE));
			cliente.setTelefones(TelefoneClienteService.getInstance().findAllByCliente(cliente.getCdCliente()));
			list.add(cliente);
		}
		return list;
	}

}
