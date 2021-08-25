package br.com.client.service;

import br.com.client.model.Client;
import br.com.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientService{

  @Autowired
  ClientRepository clientRepository;

  public ResponseEntity<Client> saveClient(Client client){
    return new ResponseEntity(clientRepository.save(client), HttpStatus.CREATED);
  }

  public ResponseEntity<Client> findById(Long id) {
    return new ResponseEntity(clientRepository.findById(id), HttpStatus.OK);
  }

  public String delete(Long id) {
    clientRepository.deleteById(id);
    return "removido com sucesso";
  }




}
