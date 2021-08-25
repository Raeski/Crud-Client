package br.com.client.controller;

import br.com.client.model.Client;
import br.com.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/client")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @PostMapping
  public ResponseEntity<Client> save(@RequestBody Client client) {
    return new ResponseEntity(clientService.saveClient(client), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Client> findById(@PathVariable("id") Long id ){
    return new ResponseEntity(clientService.findById(id),HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable("id") Long id) {
    return clientService.delete(id);
  }

  @PostMapping("/replace")
  public ResponseEntity<Client> updateClient(@RequestBody Client client) {
    return new ResponseEntity(clientService.replace(client), HttpStatus.OK);
  }

}
