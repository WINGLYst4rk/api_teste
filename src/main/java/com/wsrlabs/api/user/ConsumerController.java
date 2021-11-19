package com.wsrlabs.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

import com.wsrlabs.api.user.dto.ConsumerDTO;

@CrossOrigin
@RestController
@RequestMapping
public class ConsumerController {

    @Autowired
    private ConsumerService service;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConsumerDTO>> all() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsumerDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(value = "/user",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsumerDTO> save(@Valid @RequestBody ConsumerDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(value = "/user/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) // usando idepotencia
    public ResponseEntity<ConsumerDTO> update(@Valid @RequestBody ConsumerDTO dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<ConsumerDTO> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
