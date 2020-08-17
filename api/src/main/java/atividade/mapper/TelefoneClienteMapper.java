package atividade.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import atividade.model.TelefoneCliente;

@Mapper
public interface TelefoneClienteMapper {

	@Select("select id_telefone, cd_cliente, cd_tipo_telefone, nr_telefone, dt_atualizacao"
			+ " from telefone_cliente"
			+ " where id_telefone = #{id_telefone} and cd_cliente = #{cd_cliente}")
	TelefoneCliente selectOne(Long id_telefone, Long cd_cliente);
	
	List<TelefoneCliente> findTelefonesCliente(Long cd_cliente);
	
	int insert(TelefoneCliente cliente);
}
