package com.unifacisa.tap.bank.controllers;

import com.unifacisa.tap.bank.entities.Usuario;
import com.unifacisa.tap.bank.services.UsuarioService;
import com.unifacisa.tap.bank.services.dto.UsuarioDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAll() {
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Usuario> getUserById(@PathVariable(value = "uuid") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
    }

    @DeleteMapping("/{uuid}")
    public void deleteById(@PathVariable(value = "uuid") UUID id) {
        usuarioService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody UsuarioDto usuarioDto) {
        var usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

}
