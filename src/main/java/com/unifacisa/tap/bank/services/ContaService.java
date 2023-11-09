package com.unifacisa.tap.bank.services;

import com.unifacisa.tap.bank.entities.Conta;
import com.unifacisa.tap.bank.exceptions.SaldoInsuficienteException;
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

    public void depositar(Conta conta, double valor) {
        double saldoAtual = conta.getSaldo();
        double novoSaldo = saldoAtual + valor;
        conta.setSaldo(novoSaldo);
        contaRepository.save(conta);
    }

    public void sacar(Conta conta, double valor) throws SaldoInsuficienteException {
        double saldoAtual = conta.getSaldo();
        if (saldoAtual >= valor) {
            double novoSaldo = saldoAtual - valor;
            conta.setSaldo(novoSaldo);
            contaRepository.save(conta);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        }
    }

}
