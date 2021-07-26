import { Injectable } from '@angular/core';
import { Responsavel } from '../models/responsavel.model';
import { Table } from 'primeng';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';
import { Filtro } from '../models/filtro';
import { Page } from 'src/util/page';
import { RequestUtil } from 'src/util/request-util';

@Injectable({
  providedIn: 'root'
})
export class ResponsavelService {

  readonly resourceUrl = `${environment.apiUrl}/responsavel`;

    constructor(private httpClient: HttpClient){ }

    
    pesquisar(filtro: Filtro, datatable: Table): Observable<Page<Responsavel>> {
      return this.httpClient.post<Page<Responsavel>>(`${this.resourceUrl}/pesquisar`, filtro,
        { params: RequestUtil.getRequestParamsTable(datatable) });
    }
}
