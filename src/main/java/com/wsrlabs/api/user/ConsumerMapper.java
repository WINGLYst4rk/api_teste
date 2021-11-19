package com.wsrlabs.api.user;

import java.util.List;
import java.util.stream.Collectors;

import com.wsrlabs.api.user.dto.ConsumerDTO;

import org.springframework.stereotype.Component;

@Component
public class ConsumerMapper {
    
    public Consumer toEntity(ConsumerDTO dto) {
        Consumer user = new Consumer();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setCpf(dto.getCpf());
        user.setEmail(dto.getEmail());
        return user;
    }

    public ConsumerDTO toDto(Consumer user) {
        ConsumerDTO dto = new ConsumerDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setCpf(user.getCpf());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public List<ConsumerDTO> toDto(List<Consumer> listClient) {
        return listClient.stream().map(this::toDto).collect(Collectors.toList());
    }

}
