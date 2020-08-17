package atividade.webapp.dto;

import org.json.JSONPropertyName;

import atividade.webapp.service.ClienteService;

public class ClienteDto {

	private Long cd_cliente;
	private Long nr_cpf_cliente;
	private String nm_cliente;
	private String ds_email_cliente;

	public Long getCd_cliente() {
		return cd_cliente;
	}

	@JSONPropertyName(ClienteService.CD_CLIENTE)
	public void setCd_cliente(Long cd_cliente) {
		this.cd_cliente = cd_cliente;
	}

	public Long getNr_cpf_cliente() {
		return nr_cpf_cliente;
	}

	@JSONPropertyName(ClienteService.NR_CPF_CLIENTE)
	public void setNr_cpf_cliente(Long nr_cpf_cliente) {
		this.nr_cpf_cliente = nr_cpf_cliente;
	}

	public String getNm_cliente() {
		return nm_cliente;
	}

	@JSONPropertyName(ClienteService.NM_CLIENTE)
	public void setNm_cliente(String nm_cliente) {
		this.nm_cliente = nm_cliente;
	}

	public String getDs_email_cliente() {
		return ds_email_cliente;
	}

	@JSONPropertyName(ClienteService.DS_EMAIL_CLIENTE)
	public void setDs_email_cliente(String ds_email_cliente) {
		this.ds_email_cliente = ds_email_cliente;
	}

}
