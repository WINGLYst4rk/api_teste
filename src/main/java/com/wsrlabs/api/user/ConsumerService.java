package com.wsrlabs.api.user;

import java.util.Optional;
import java.util.List;

import com.wsrlabs.api.user.dto.ConsumerDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsumerService {
    
    @Autowired
    private ConsumerRepository repository;// injetando o repositorio para salvar o usuario

    @Autowired
    private ConsumerMapper mapper; // injetando o mapper para criar o dto

    @Transactional
    public ConsumerDTO save(ConsumerDTO dto) {
        Optional<Consumer> optionalConsumer = repository.findByNameAndCpf(dto.getName(), dto.getCpf());
        if (optionalConsumer.isPresent()) { // caso já exista no banco de dados avisar o usuario
            throw new RuntimeException("Usuário já cadastrado!"); // depois criar erro apropriado
        }
        Consumer consumer = mapper.toEntity(dto); // transformando o dto em entidade
        repository.save(consumer);
        return mapper.toDto(consumer); // retornando um dto
    }

    @Transactional
    public ConsumerDTO update(ConsumerDTO dto) { // comentario sobre o transactional
        Optional<Consumer> optionalConsumer = repository.findByConsumerUpdate(dto.getName(), dto.getCpf(), dto.getId());
        if (optionalConsumer.isPresent()) {
            throw new RuntimeException("Usuário já cadastrado");
        }
        Consumer consumer = mapper.toEntity(dto);
        repository.save(consumer);
        return mapper.toDto(consumer);
    }

    @Transactional
    public ConsumerDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow();
    }

    @Transactional
    public ConsumerDTO delete(Long id) {
        ConsumerDTO dto = this.findById(id);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<ConsumerDTO> findAll() {
        return mapper.toDto(repository.findAll());
    }
}
