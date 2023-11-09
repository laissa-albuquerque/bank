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


    @GetMapping("/{uuid}")
    public ResponseEntity<Conta> getContaById(@PathVariable(value = "uuid") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(contaService.findById(id));
    }

    @DeleteMapping("/{uuid}")
    public void deleteById(@PathVariable(value = "uuid") UUID id) {
        contaService.deleteById(id);
    }


}
