package com.basis.campina.xtarefas.service.event;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TarefaEvent extends DefaultEvent{

    public TarefaEvent(Long id){
        super(id);
    }
}
