package com.unifacisa.tap.bank.controllers;

import com.unifacisa.tap.bank.entities.Conta;
import com.unifacisa.tap.bank.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;


    @GetMapping("/{contaId}")
    public ResponseEntity<Conta> getContaById(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(contaService.findById(id));
    }

    @DeleteMapping("/{contaId}")
    public void deleteById(@PathVariable(value = "id") UUID id) {
        contaService.deleteById(id);
    }


}
