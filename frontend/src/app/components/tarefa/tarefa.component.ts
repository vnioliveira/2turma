import { Page } from '../../../util/page';
import { Component, OnInit } from '@angular/core';
import { Tarefa } from 'src/app/models/tarefa.model';
import { TarefaService } from '../../service/tarefa.service'
import { Filtro } from '../../models/filtro'
import { Table } from 'primeng';
@Component({
  selector: 'app-table',
  templateUrl: './tarefa.component.html',
  styleUrls: ['./tarefa.component.css']
})
export class TableComponent implements OnInit {
  datatable: Table;

  tarefas: Page<Tarefa> = new Page<Tarefa>();

  tarefa = new Filtro();

  constructor(
    private servico: TarefaService,
  ) { }

  ngOnInit(): void {
    this.buscarTarefas();
  }

   buscarTarefas() {
    this.servico.pesquisar(this.tarefa,this.datatable)
      .subscribe(res => {
        this.tarefas = res;
      })
  }


}
