package br.com.client.repository;

import br.com.client.model.Client;
import br.com.client.util.ClientCreator;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("Tests for Client Repository")
@Slf4j
class ClientRepositoryTest {

  @Autowired
  private ClientRepository clientRepository;

  @Test
  @DisplayName("Save persist client when successful")
  void save_PersistClient_WhenSuccessful() {
    Client clientToBeSaved = ClientCreator.createClientToBeSaved();

    Client savedClient = this.clientRepository.save(clientToBeSaved);
    Assertions.assertThat(savedClient).isNotNull();
    Assertions.assertThat(savedClient.getId()).isNotNull();
    Assertions.assertThat(savedClient.getName()).isEqualTo(clientToBeSaved.getName());

  }

  @Test
  @DisplayName("Save updates client when successful")
  void save_UpdatesClient_WhenSuccessful() {
    Client clientToBeSaved = ClientCreator.createClientToBeSaved();

    Client savedClient = this.clientRepository.save(clientToBeSaved);

    savedClient.setName("Nome atualizado");

    Client clientUpdated = this.clientRepository.save(savedClient);

    log.info(clientUpdated.getName());

    Assertions.assertThat(clientUpdated).isNotNull();
    Assertions.assertThat(clientUpdated.getId()).isNotNull();
    Assertions.assertThat(clientUpdated.getName()).isEqualTo(savedClient.getName());

  }


  @Test
  @DisplayName("Delete removes client when successful")
  void delete_RemovesClient_WhenSuccessful() {
    Client clientToBeSaved = ClientCreator.createClientToBeSaved();

    Client savedClient = this.clientRepository.save(clientToBeSaved);

    this.clientRepository.delete(savedClient);

    Optional<Client> clientOptional = this.clientRepository.findById(savedClient.getId());

    Assertions.assertThat(clientOptional).isEmpty();

  }

  @Test
  @DisplayName("Find By id client when successful")
  void findById_ReturnClient_WhenSuccessful() {
    Client clientToBeSaved = ClientCreator.createClientToBeSaved();

    Client savedClient = this.clientRepository.save(clientToBeSaved);

    Optional<Client> clientOptional = this.clientRepository.findById(savedClient.getId());

    Assertions.assertThat(clientOptional.get().getName()).isEqualTo(savedClient.getName());
    Assertions.assertThat(clientOptional.get().getId()).isEqualTo(savedClient.getId());
    Assertions.assertThat(clientOptional.isEmpty()).isFalse();
  }

  @Test
  @DisplayName("Return error message NotFoundException client when not found")
  void findById_ReturnNotFoundClient_WhenClientNotFound() {
    Client clientToBeSaved = ClientCreator.createClientToBeSaved();

    Client savedClient = this.clientRepository.save(clientToBeSaved);

    savedClient.setId(10l);

    Optional<Client> clientOptional = this.clientRepository.findById(savedClient.getId());

    Assertions.assertThat(clientOptional).overridingErrorMessage(() -> String.valueOf(new NotFoundException("Not found client!")));
  }


}

