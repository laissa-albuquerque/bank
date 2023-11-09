package com.unifacisa.tap.bank.services.dto;

import com.unifacisa.tap.bank.entities.Usuario;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ContaDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String numConta;
    private Double saldo;

    private Usuario usuario;
}
