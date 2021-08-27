package br.com.client.controller;

import br.com.client.model.Client;
import br.com.client.service.ClientService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
  public ResponseEntity<Client> findById(@PathVariable("id") Long id ) throws NotFoundException {
    return new ResponseEntity(clientService.findById(id),HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws NotFoundException {
    clientService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/replace")
  public ResponseEntity<Client> updateClient(@RequestBody Client client) {
    return new ResponseEntity(clientService.replace(client), HttpStatus.OK);
  }

}
