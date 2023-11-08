package com.unifacisa.tap.bank.services;

import com.unifacisa.tap.bank.entities.Usuario;
import com.unifacisa.tap.bank.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(UUID id) {
        return usuarioRepository.findById(id).get();
    }

    public void deleteById(UUID id) {
        usuarioRepository.deleteById(id);
    }

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
