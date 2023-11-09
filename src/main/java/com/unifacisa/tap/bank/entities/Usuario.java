package com.unifacisa.tap.bank.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private String cpf;

    @JsonBackReference
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "contaId", referencedColumnName = "id")
    private Conta conta;

}
