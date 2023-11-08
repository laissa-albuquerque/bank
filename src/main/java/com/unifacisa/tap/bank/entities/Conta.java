package com.unifacisa.tap.bank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String numConta;
    private Double saldo;

    @OneToOne(mappedBy = "conta")
    private Usuario usuario;

}
