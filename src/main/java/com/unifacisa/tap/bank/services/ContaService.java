package com.unifacisa.tap.bank.services;

import com.unifacisa.tap.bank.exceptions.SaldoInsuficienteException;
import com.unifacisa.tap.bank.repositories.ContaRepository;
import com.unifacisa.tap.bank.services.dto.ContaDto;
import com.unifacisa.tap.bank.services.mapper.ContaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;
    private ContaMapper contaMapper;

    public ContaDto findById(UUID id) {
        return contaMapper.INSTANCE.toDto(contaRepository.findById(id).get());
    }

    public void deleteById(UUID id) {
        contaRepository.deleteById(id);
    }

    public void depositar(ContaDto conta, double valor) {
        double saldoAtual = conta.getSaldo();
        double novoSaldo = saldoAtual + valor;
        conta.setSaldo(novoSaldo);
        contaRepository.save(contaMapper.INSTANCE.toEntity(conta));

    }

    public void sacar(ContaDto conta, double valor) throws SaldoInsuficienteException {
        double saldoAtual = conta.getSaldo();
        if (saldoAtual >= valor) {
            double novoSaldo = saldoAtual - valor;
            conta.setSaldo(novoSaldo);
            contaRepository.save(contaMapper.INSTANCE.toEntity(conta));
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        }
    }

}
