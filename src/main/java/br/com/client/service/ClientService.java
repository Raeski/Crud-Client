package br.com.client.service;

import br.com.client.exception.BadRequestException;
import br.com.client.model.Client;
import br.com.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService{

  @Autowired
  ClientRepository clientRepository;

  public Client saveClient(Client client){
    try {
      return clientRepository.save(client);
    } catch (BadRequestException e) {
      throw new BadRequestException( "Falha ao salvar cliente", e.getCause() );
    }
  }

  public Client findById(Long id) {
    return clientRepository.findById(id)
            .orElseThrow(() -> new BadRequestException("Cliente não encontrado!"));
  }

  public String delete(Long id) {
    try {
      clientRepository.deleteById(id);
      return "removido com sucesso";
    } catch (BadRequestException e) {
      throw new BadRequestException( "Falha ao deletar cliente!", e.getCause());
    }

  }

  public Client replace(Client client){
    try {
      Client clientId = findById(client.getId());
      client.setId(clientId.getId());
      return clientRepository.save(client);
    } catch (BadRequestException e) {
      throw new BadRequestException( "Falha ao atualizar cliente!", e.getCause());
    }

  }




}
