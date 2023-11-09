package com.unifacisa.tap.bank.services;

import com.unifacisa.tap.bank.entities.Usuario;
import com.unifacisa.tap.bank.repositories.UsuarioRepository;
import com.unifacisa.tap.bank.services.dto.UsuarioDto;
import com.unifacisa.tap.bank.services.event.UsuarioEvent;
import com.unifacisa.tap.bank.services.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioMapper usuarioMapper;

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    public List<UsuarioDto> getAll() {
        return usuarioRepository.findAll().stream().map(UsuarioMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    public UsuarioDto findById(UUID id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Usuario não encontrado"));
        return usuarioMapper.toDto(usuario);
    }

    public void deleteById(UUID id) {
        findById(id);
        usuarioRepository.deleteById(id);
    }

    public UsuarioDto save(UsuarioDto usuarioDto) {
        Usuario obj = usuarioMapper.toEntity(usuarioDto);
        obj = usuarioRepository.save(obj);
        applicationEventPublisher.publishEvent(new UsuarioEvent(obj.getId()));
        return usuarioMapper.toDto(obj);
    }
    public boolean existsByCpf(String cpf) {
        return usuarioRepository.existsByCpf(cpf);
    }

}
