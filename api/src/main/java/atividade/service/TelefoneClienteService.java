package atividade.service;

import java.util.List;

import atividade.model.TelefoneCliente;

public interface TelefoneClienteService {

	TelefoneCliente getTelefoneCliente(final Long id_telefone, final Long cd_cliente);
	List<TelefoneCliente> findTelefonesCliente(final Long cd_cliente);
	int createTelefoneCliente(final TelefoneCliente telefoneCliente);
	
}
