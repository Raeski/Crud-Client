package br.com.client.controller;

import br.com.client.model.Client;
import br.com.client.service.ClientService;
import br.com.client.util.ClientCreator;
import javassist.NotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ClientControllerTest {

  @InjectMocks
  private ClientController clientController;


  @Mock
  private ClientService clientServiceMock;

  @BeforeEach
  void setUp() throws NotFoundException {
    BDDMockito.when(clientServiceMock.findById(ArgumentMatchers.anyLong()))
      .thenReturn(ClientCreator.createValidClient());
    BDDMockito.when(clientServiceMock.saveClient(ArgumentMatchers.any(Client.class)))
      .thenReturn(ClientCreator.createValidClient());
    BDDMockito.when(clientServiceMock.replace(ArgumentMatchers.any(Client.class)))
      .thenReturn(ClientCreator.createClientToBeSaved());
    BDDMockito.doNothing().when(clientServiceMock).delete(ArgumentMatchers.anyLong());
  }


  @Test
  @DisplayName("Return client save when successful")
  void save_ReturnClient_WhenSuccessful() {

    ResponseEntity<Client> client = clientController.save(ClientCreator.createClientToBeSaved());

    Assertions.assertThat(client).isNotNull();

    Assertions.assertThat(client.getBody().getName()).isEqualTo(ClientCreator.createClientToBeSaved().getName());
  }

  @Test
  @DisplayName("findById return client when successful")
  void findById_ReturnsClient_WhenSuccessful() throws NotFoundException {
    Long expectedId = ClientCreator.createValidClient().getId();

    Client client = clientController.findById(1l).getBody();

    Assertions.assertThat(client).isNotNull();

    Assertions.assertThat(client.getId()).isNotNull().isEqualTo(expectedId);

  }

  @Test
  @DisplayName("delete removes client when successful")
  void delete_RemoveClient_WhenSuccessful() throws NotFoundException {

    Assertions.assertThatCode(() -> clientController.delete(1l))
            .doesNotThrowAnyException();

    ResponseEntity<Void> delete = clientController.delete(1l);

    Assertions.assertThat(delete).isNotNull();

    Assertions.assertThat(delete.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);


  }

  @Test
  @DisplayName("Return client update when successful")
  void updateClient() {
    ResponseEntity<Client> client = clientController.updateClient(ClientCreator.createValidUpdateClient());

    Assertions.assertThat(client).isNotNull();
  }
}
