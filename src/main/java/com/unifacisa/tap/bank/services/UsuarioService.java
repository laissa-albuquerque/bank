package com.unifacisa.tap.bank.services;

import com.unifacisa.tap.bank.entities.Usuario;
import com.unifacisa.tap.bank.repositories.UsuarioRepository;
import com.unifacisa.tap.bank.services.dto.UsuarioDto;
import com.unifacisa.tap.bank.services.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDto> getAll() {
        return usuarioRepository.findAll().stream().map(UsuarioMapper.INSTANTE::toDto).collect(Collectors.toList());
    }

    public Usuario findById(UUID id) {
        return usuarioRepository.findById(id).get();
    }

    public void deleteById(UUID id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
