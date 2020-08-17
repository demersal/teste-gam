package atividade.serviceimpl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import atividade.mapper.ClienteMapper;
import atividade.model.Cliente;
import atividade.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteMapper clienteMapper;
	
	@Override
	public Cliente getCliente(Long cd_cliente) {
		return clienteMapper.selectOne(cd_cliente);
	}

	@Override
	public List<Cliente> getClientes() {
		return clienteMapper.findAll();
	}

	@Override
	public int createCliente(Cliente cliente) {
		validate(cliente);
		cliente.setDt_atualizacao(Calendar.getInstance().getTime());
		return clienteMapper.insert(cliente);
	}

	@Override
	public List<Cliente> getClientesBy(String param) {
		return clienteMapper.findBy(param);
	}

	@Override
	public int updateCliente(Cliente cliente) {
		validate(cliente);
		cliente.setDt_atualizacao(Calendar.getInstance().getTime());
		return clienteMapper.update(cliente);
	}

	
	private void validate(Cliente cliente) {
		Assert.notNull(cliente.getNr_cpf_cliente(), "CPF não pode ser vazio!");
		Assert.notNull(cliente.getNm_cliente(), "Nome não pode ser vazio!");
		Assert.notNull(cliente.getDs_email_cliente(), "Email não pode ser vazio!");
	}
	
}
