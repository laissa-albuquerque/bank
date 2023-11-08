package com.unifacisa.tap.bank.services;

import com.unifacisa.tap.bank.entities.Conta;
import com.unifacisa.tap.bank.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta findById(UUID id) {
        return contaRepository.findById(id).get();
    }

    public void deleteById(UUID id) {
        contaRepository.deleteById(id);
    }


}
