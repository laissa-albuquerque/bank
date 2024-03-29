package com.unifacisa.tap.bank.controllers;

import com.unifacisa.tap.bank.entities.Usuario;
import com.unifacisa.tap.bank.exceptions.CPFAssociadoException;
import com.unifacisa.tap.bank.services.UsuarioService;
import com.unifacisa.tap.bank.services.dto.UsuarioDto;
import org.springframework.beans.BeanUtils;
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
    public ResponseEntity<List<UsuarioDto>> getAll() {
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UsuarioDto> getUserById(@PathVariable(value = "uuid") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
    }

    @DeleteMapping("/{uuid}")
    public void deleteById(@PathVariable(value = "uuid") UUID id) {
        usuarioService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> save(@RequestBody UsuarioDto usuarioDto) {
        if (usuarioService.existsByCpf(usuarioDto.getCpf())) {
            throw new CPFAssociadoException("Este CPF já possui uma conta associada.");
        }
        UsuarioDto dto = usuarioService.save(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(dto));
    }

}
