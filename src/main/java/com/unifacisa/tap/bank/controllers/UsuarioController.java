package com.unifacisa.tap.bank.controllers;

import com.unifacisa.tap.bank.entities.Usuario;
import com.unifacisa.tap.bank.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> getUserById(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
    }

    @DeleteMapping("/{usuarioId}")
    public void deleteById(@PathVariable(value = "id") UUID id) {
        usuarioService.deleteById(id);
    }

    @PostMapping
    public void save(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
    }

}
