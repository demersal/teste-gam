package atividade.webapp.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import atividade.webapp.model.Cliente;
import atividade.webapp.model.TelefoneCliente;
import atividade.webapp.model.TipoTelefone;
import atividade.webapp.service.ClienteService;
import atividade.webapp.service.TelefoneClienteService;
import atividade.webapp.service.TipoTelefoneService;

@ManagedBean
@SessionScoped
public class ClienteBean {
	
	private static final String ROUTE_LISTCLIENTE = "listcliente.xhtml?faces-redirect=true";
	private static final String ROUTE_CADCLIENTE = "cadcliente.xhtml?faces-redirect=true";
	private Cliente cliente;
	private TelefoneCliente telefoneCliente;
	private TipoTelefone tipoTelefone;
	private boolean editing;

	private List<Cliente> clientes;
	private List<TipoTelefone> tipoTelefoneList;
	private String filter;
	
	@PostConstruct
	public void configure() {
	}
	
	public String add() {
		this.cliente = new Cliente();
		return ROUTE_CADCLIENTE;
	}
	
	public String lista() {
		this.clientes = ClienteService.getInstance().findClientes(filter);
		this.editing = false;
		this.filter = null;
		return ROUTE_LISTCLIENTE;
	}
	
	public String salvar() {
		ClienteService.getInstance().insertOrUpdateCliente(cliente);
		cliente = new Cliente();
		this.editing = false;
		return lista();
	}
	
	public String salvarTelefone() {
		this.telefoneCliente.setCdCliente(cliente.getCdCliente());
		TelefoneClienteService.getInstance().insert(telefoneCliente);
		this.telefoneCliente = new TelefoneCliente();
		this.editing = true;
		return editar(cliente);
	}
	
	public String editar(Cliente cliente) {
		this.cliente = cliente;
		this.editing = true;
		this.telefoneCliente = new TelefoneCliente();
		this.cliente.setTelefones(TelefoneClienteService.getInstance().findAllByCliente(cliente.getCdCliente()));
		return ROUTE_CADCLIENTE;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TelefoneCliente getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(TelefoneCliente telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public List<Cliente> getClientes() {
		if (clientes == null) {
			clientes = ClienteService.getInstance().findClientes(this.filter);
		}
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}

	public List<TipoTelefone> getTipoTelefoneList() {
		if (this.tipoTelefoneList == null) {
			this.tipoTelefoneList = TipoTelefoneService.getInstance().findAll();
		}
		return tipoTelefoneList;
	}

	public void setTipoTelefoneList(List<TipoTelefone> tipoTelefoneList) {
		this.tipoTelefoneList = tipoTelefoneList;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

}
