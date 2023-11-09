package com.unifacisa.tap.bank.services.dto;

import com.unifacisa.tap.bank.entities.Usuario;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaDto {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String numConta;
    private Double saldo;

    private Usuario usuario;
}
