package br.com.client.util;

import br.com.client.model.Client;

import java.sql.Timestamp;

public class ClientCreator {

  public static Client createClientToBeSaved() {
    return Client.builder()
      .name("Gustavo")
      .cpf("1111111111")
      .birth(Timestamp.valueOf("2020-10-10 11:11:11"))
      .email("gustavo@teste.com.br")
      .build();
  }

  public static Client createValidClient() {
    return Client.builder()
      .id(1L)
      .name("Gustavo")
      .cpf("1111111111")
      .birth(Timestamp.valueOf("2020-10-10 11:11:11"))
      .email("gustavo@teste.com.br")
      .build();
  }

  public static Client createValidUpdateClient() {
    return Client.builder()
      .id(1L)
      .name("Gustavo 2")
      .cpf("1111111111")
      .birth(Timestamp.valueOf("2020-10-10 11:11:11"))
      .email("gustavo@teste.com.br")
      .build();
  }
}
