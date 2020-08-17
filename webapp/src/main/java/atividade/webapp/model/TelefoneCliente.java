package atividade.webapp.model;

import java.io.Serializable;
import java.util.Date;

public class TelefoneCliente implements Serializable {

	private static final long serialVersionUID = 6897678282122686207L;

	private Long idTelefone;
	private Long cdCliente;
	private Long cdTipoTelefone;
	private String nrTelefone;
	private Date dtAtualizacao;

	public Long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public Long getCdCliente() {
		return cdCliente;
	}

	public void setCdCliente(Long cdCliente) {
		this.cdCliente = cdCliente;
	}

	public Long getCdTipoTelefone() {
		return cdTipoTelefone;
	}

	public void setCdTipoTelefone(Long cdTipoTelefone) {
		this.cdTipoTelefone = cdTipoTelefone;
	}

	public String getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public Date getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(Date dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}
	
	public String getDsTipoTelefone() {
		return this.cdTipoTelefone == 1l ? TipoTelefone.TIPO_FIXO : TipoTelefone.TIPO_CELULAR;  
	}

}
