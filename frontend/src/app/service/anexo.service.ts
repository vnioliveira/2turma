import { Injectable } from '@angular/core';
import { Anexo } from '../models/anexo.model';
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
export class AnexoService {

  readonly resourceUrl = `${environment.apiUrl}/anexo`;

    constructor(private httpClient: HttpClient){ }

    pesquisar(filtro: Filtro, datatable: Table): Observable<Page<Anexo>> {
      return this.httpClient.post<Page<Anexo>>(`${this.resourceUrl}/pesquisar`, filtro,
        { params: RequestUtil.getRequestParamsTable(datatable) });
    }
}
