package com.unifacisa.tap.bank.services.event;

import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class UsuarioEvent extends DefaultEvent{

    public UsuarioEvent(UUID uuid){
        super(uuid);
    }
}
