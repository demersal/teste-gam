package atividade.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import atividade.model.Cliente;
import atividade.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/cliente/id")
	public Cliente getCliente(@PathParam("id") final Long id) {
		return clienteService.getCliente(id);
	}
	
	@PostMapping("/cliente/add")
    public int createCliente(@RequestBody final Cliente cliente) {
        return clienteService.createCliente(cliente);
    }
	
	@PostMapping("/cliente/modify")
	public int updateCliente(@RequestBody final Cliente cliente) {
		return clienteService.updateCliente(cliente);
	}
	
	@GetMapping("/clientes")
	public List<Cliente> findAll() {
		return clienteService.getClientes();
	}
	
	@GetMapping("/clientes/{param}")
	public List<Cliente> findAllBy(@PathVariable final String param) {
		return clienteService.getClientesBy(param);
	}
	

}
