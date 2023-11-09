package com.unifacisa.tap.bank.services.dto;

import com.unifacisa.tap.bank.entities.Conta;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String cpf;
    private Conta conta;
}
