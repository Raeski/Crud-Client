package br.com.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "GUSTAVO", name = "client" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String cpf;

  private String email;

  private Date birth;


}
