package atividade.webapp.model;

import java.io.Serializable;
import java.util.Date;

public class TipoTelefone implements Serializable {

	private static final long serialVersionUID = 6897678282122686207L;
	
	public static final String TIPO_FIXO = "Fixo";
	public static final String TIPO_CELULAR = "Celular";
	
	private Long cdTipoTelefone;
	private String dsTipoTelefone;
	private Date dtAtualizacao;

	public Long getCdTipoTelefone() {
		return cdTipoTelefone;
	}

	public void setCdTipoTelefone(Long cdTipoTelefone) {
		this.cdTipoTelefone = cdTipoTelefone;
	}

	public String getDsTipoTelefone() {
		return dsTipoTelefone;
	}

	public void setDsTipoTelefone(String dsTipoTelefone) {
		this.dsTipoTelefone = dsTipoTelefone;
	}

	public Date getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(Date dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

}
