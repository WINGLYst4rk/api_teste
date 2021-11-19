package com.wsrlabs.api.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

    // @Query("SELECT consumer FROM Consumer consumer WHERE cosumer.name = :name AND consumer.cpf = :cpf")
    Optional<Consumer> findByNameAndCpf(String name, String cpf);

    @Query("SELECT consumer FROM Consumer consumer WHERE consumer.name = :name AND consumer.cpf = :cpf AND consumer.id <> :id")
    Optional<Consumer> findByConsumerUpdate(String name, String cpf, Long id);

    // @Query("SELECT user FROM Client client WHERE client.id <> :id")
    // Optional<Client> findById(Long id);
    
}
