import { RequestUtil } from './../../util/request-util';
import { Page } from './../../util/page';
import { Injectable } from '@angular/core';
import { Tarefa } from '../models/tarefa.model';
import { Table } from 'primeng';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Filtro } from '../models/filtro';


@Injectable({
  providedIn: 'root'
})
export class TarefaService {

  readonly resourceUrl = `${environment.apiUrl}/tarefa`;

  constructor(private httpClient: HttpClient) { }

  pesquisar(filtro: Filtro, datatable: Table): Observable<Page<Tarefa>> {
    return this.httpClient.post<Page<Tarefa>>(`${this.resourceUrl}/pesquisar`, filtro,
      { params: RequestUtil.getRequestParamsTable(datatable) });
  }

}
