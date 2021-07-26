import { ResponsavelService } from './../../service/responsavel.service';
import { Responsavel } from './../../models/responsavel.model';
import { Component, OnInit } from '@angular/core';
import { Table } from 'primeng';
import { Filtro } from '../../models/filtro'
import { Page } from '../../../util/page';

@Component({
  selector: 'app-responsavel',
  templateUrl: './responsavel.component.html',
  styleUrls: ['./responsavel.component.css']
})
export class ResponsavelComponent implements OnInit {

  constructor(private servico: ResponsavelService,) { }

  datatable: Table;

  responsaveis: Page<Responsavel> = new Page<Responsavel>();

  responsavel = new Filtro();

  ngOnInit(): void {
    this.buscarResponsaveis();
  }

  buscarResponsaveis() {
    this.servico.pesquisar(this.responsavel, this.datatable)
      .subscribe(res => {
        this.responsaveis = res;
        console.log(res);
        
      })
  }

}
