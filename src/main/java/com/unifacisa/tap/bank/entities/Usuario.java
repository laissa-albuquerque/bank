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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;

    @OneToOne(optional = false, cascade=CascadeType.ALL)
    @JoinColumn(name = "contaId", referencedColumnName = "id")
    private Conta conta;

}
