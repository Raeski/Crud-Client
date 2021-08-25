package br.com.client.model;

import java.util.Date;

public class Client {

  private String nome;

  private String cpg;

  private String email;

  private Date nascimento;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpg() {
    return cpg;
  }

  public void setCpg(String cpg) {
    this.cpg = cpg;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getNascimento() {
    return nascimento;
  }

  public void setNascimento(Date nascimento) {
    this.nascimento = nascimento;
  }


}
