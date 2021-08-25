package br.com.client.service;

import br.com.client.model.Client;
import br.com.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService{

  @Autowired
  ClientRepository clientRepository;

  public Client saveClient(Client client){
    return clientRepository.save(client);
  }

  public Optional<Client> findById(Long id) {
    return clientRepository.findById(id);
  }

  public String delete(Long id) {
    clientRepository.deleteById(id);
    return "removido com sucesso";
  }

  public Client replace(Client client){
    Optional<Client> byId = findById(client.getId());
    client.setId(byId.get().getId());
    return clientRepository.save(client);
  }




}
