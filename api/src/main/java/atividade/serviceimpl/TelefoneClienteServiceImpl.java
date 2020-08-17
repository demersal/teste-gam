package atividade.serviceimpl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atividade.mapper.TelefoneClienteMapper;
import atividade.model.TelefoneCliente;
import atividade.service.TelefoneClienteService;

@Service
public class TelefoneClienteServiceImpl implements TelefoneClienteService {

	@Autowired
	private TelefoneClienteMapper telefoneClienteMapper;

	@Override
	public TelefoneCliente getTelefoneCliente(Long id_telefone, Long cd_cliente) {
		return telefoneClienteMapper.selectOne(id_telefone, cd_cliente);
	}

	@Override
	public List<TelefoneCliente> findTelefonesCliente(Long cd_cliente) {
		return telefoneClienteMapper.findTelefonesCliente(cd_cliente);
	}

	@Override
	public int createTelefoneCliente(TelefoneCliente telefoneCliente) {
		telefoneCliente.setDt_atualizacao(Calendar.getInstance().getTime());
		return telefoneClienteMapper.insert(telefoneCliente);
	}
	

}
