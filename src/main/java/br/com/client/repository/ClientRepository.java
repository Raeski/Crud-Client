package br.com.client.repository;

import br.com.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface ClientRepository extends JpaRepository<Client, Long> {

  Client findByName (String name);

}
