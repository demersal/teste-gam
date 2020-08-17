package atividade.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;
@Accessors(chain = true)
@Data
public class TelefoneCliente implements Serializable {

	private static final long serialVersionUID = 6897678282122686207L;
	
	private Long id_telefone;
	private Long cd_cliente;
	private Long cd_tipo_telefone;
	private String nr_telefone;
	private Date dt_atualizacao;
	

}
