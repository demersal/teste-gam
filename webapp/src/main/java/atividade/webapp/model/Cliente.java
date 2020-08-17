package atividade.webapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 6897678282122686207L;

	private Long cdCliente;
	private Long nrCpfCliente;
	private String nmCliente;
	private String dsEmailCliente;
	private Date dtAtualizacao;

	private List<TelefoneCliente> telefones;

	public Long getCdCliente() {
		return cdCliente;
	}

	public void setCdCliente(Long cdCliente) {
		this.cdCliente = cdCliente;
	}

	public Long getNrCpfCliente() {
		return nrCpfCliente;
	}

	public void setNrCpfCliente(Long nrCpfCliente) {
		this.nrCpfCliente = nrCpfCliente;
	}

	public String getNmCliente() {
		return nmCliente;
	}

	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}

	public String getDsEmailCliente() {
		return dsEmailCliente;
	}

	public void setDsEmailCliente(String dsEmailCliente) {
		this.dsEmailCliente = dsEmailCliente;
	}

	public Date getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(Date dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

	public List<TelefoneCliente> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneCliente> telefones) {
		this.telefones = telefones;
	}

}
