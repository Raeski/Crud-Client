package br.com.client.service;

import br.com.client.exception.BadRequestException;
import br.com.client.model.Client;
import br.com.client.repository.ClientRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService{


  private final ClientRepository clientRepository;

  public Client saveClient(Client client){
    try {
      return clientRepository.save(client);
    } catch (BadRequestException e) {
      throw new BadRequestException( "Fail to save Client", e.getCause() );
    }
  }

  public Client findById(Long id) throws NotFoundException {
    return clientRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Fail to find Client!"));
  }

  public void delete(Long id) throws NotFoundException {
    Client byId = findById(id);

    clientRepository.deleteById(byId.getId());

  }

  public Client replace(Client client){
    try {
      Client clientId = findById(client.getId());
      client.setId(clientId.getId());
      return clientRepository.save(client);
    } catch (BadRequestException | NotFoundException e) {
      throw new BadRequestException( "Fail to update Client!", e.getCause());
    }

  }

}
