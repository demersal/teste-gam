package atividade.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;
@Accessors(chain = true)
@Data
public class Cliente implements Serializable {

	private static final long serialVersionUID = 6897678282122686207L;
	
	private Long cd_cliente;
	private Long  nr_cpf_cliente;
	private String nm_cliente;
	private String ds_email_cliente;
	private Date dt_atualizacao;
	

}
