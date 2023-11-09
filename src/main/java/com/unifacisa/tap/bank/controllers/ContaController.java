package com.unifacisa.tap.bank.controllers;

import com.unifacisa.tap.bank.entities.Conta;
import com.unifacisa.tap.bank.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
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

    @PostMapping("/{contaId}/depositar")
    public ResponseEntity<Conta> depositar(@PathVariable UUID contaId, @RequestBody Map<String, Double> requestBody) {
        if (requestBody.containsKey("valor")) {
            double valor = requestBody.get("valor");
            Conta conta = contaService.findById(contaId);
            if (conta == null) {
                return ResponseEntity.notFound().build();
            }
            contaService.depositar(conta, valor);
        }
        return ResponseEntity.ok(contaService.findById(contaId));
    }

    @PostMapping("/{contaId}/sacar")
    public ResponseEntity<Conta> sacar(@PathVariable UUID contaId, @RequestBody Map<String, Double> requestBody) {
        if (requestBody.containsKey("valor")) {
            double valor = requestBody.get("valor");
            Conta conta = contaService.findById(contaId);
            if (conta == null) {
                return ResponseEntity.notFound().build();
            }
            contaService.sacar(conta, valor);
        }
        return ResponseEntity.ok(contaService.findById(contaId));
    }
}
