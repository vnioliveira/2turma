import { Anexo } from './../../models/anexo.model';
import { AnexoService } from './../../service/anexo.service';
import { Component, OnInit } from '@angular/core';
import { Table } from 'primeng';
import { Page } from '../../../util/page';
import { Filtro } from '../../models/filtro'

@Component({
  selector: 'app-anexo',
  templateUrl: './anexo.component.html',
  styleUrls: ['./anexo.component.css']
})
export class AnexoComponent implements OnInit {

  datatable: Table;

  anexos: Page<Anexo> = new Page<Anexo>();

  anexo = new Filtro();

  constructor(
    private servico: AnexoService,) { }

  ngOnInit(): void {
    this.buscarAnexos();
  }

  buscarAnexos(){
    this.servico.pesquisar(this.anexo,this.datatable)
      .subscribe(res => {
        this.anexos = res;
      })
  }

}
