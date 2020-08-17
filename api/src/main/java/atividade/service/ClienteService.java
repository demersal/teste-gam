package atividade.service;

import java.util.List;

import atividade.model.Cliente;

public interface ClienteService {

	Cliente getCliente(final Long cd_cliente);
	
	List<Cliente> getClientes();
	
	int createCliente(final Cliente cliente);
	
	int updateCliente(final Cliente cliente);
	
	List<Cliente> getClientesBy(String nm_cliente);
	
	
}
