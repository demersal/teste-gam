package atividade.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import atividade.model.Cliente;

@Mapper
public interface ClienteMapper {

	@Select("select cd_cliente, nr_cpf_cliente, nm_cliente, ds_email_cliente, dt_atualizacao from cliente where cd_cliente = #{cd_cliente}")
	Cliente selectOne(Long cd_cliente);
	
	List<Cliente> findAll();
	
	int insert(Cliente cliente);
	
	List<Cliente> findBy(String nome);
	
	int update(Cliente cliente);
}
