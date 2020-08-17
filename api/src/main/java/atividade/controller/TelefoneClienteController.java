package atividade.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import atividade.model.TelefoneCliente;
import atividade.service.TelefoneClienteService;

@RestController
public class TelefoneClienteController {
	
	@Autowired
	private TelefoneClienteService telefoneClienteService;
	
	@GetMapping("/telefonecli/id")
	public TelefoneCliente getCliente(@PathParam("id") final Long id, @PathParam("cliente_id") final Long cliente_id) {
		return telefoneClienteService.getTelefoneCliente(id, cliente_id);
	}
	
	@PostMapping("/telefonecli/add")
    public int createTelefoneCliente(@RequestBody final TelefoneCliente telefoneCliente) {
        return telefoneClienteService.createTelefoneCliente(telefoneCliente);
    }
	
	@GetMapping("/telefonescli")
	public List<TelefoneCliente> findTelefonesCliente(@PathParam("cd_cliente") final Long cd_cliente) {
		return telefoneClienteService.findTelefonesCliente(cd_cliente);
	}

}
