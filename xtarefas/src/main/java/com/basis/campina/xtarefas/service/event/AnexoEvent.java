package com.basis.campina.xtarefas.service.event;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AnexoEvent extends DefaultEvent{

    public AnexoEvent(Long id){
        super(id);
    }
}
