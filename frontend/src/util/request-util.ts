import { HttpRequest, HttpParams } from '@angular/common/http';
import { Table } from 'primeng';
import { Pageable } from '../util/pageable';
export class RequestUtil {

    static createRequestOption = (req?: any): HttpRequest<any> => {

        if (req) {
            const params: HttpParams = new HttpParams();
            params.set('page', req.page);
            params.set('size', req.size);
            if (req.sort) {
                params.set('sort', req.sort);
            }
            params.set('query', req.query);

            return req.clone({ 'params': params });
        }

        return req;
    };


    static getRequestParamsTable = (datatable: Table): HttpParams => {
        let params: HttpParams = new HttpParams();
        if (datatable == null) {
            params = params.append('size', '10');
            return params;
        }

        params = params.append('page', Math.round(datatable.first / datatable.rows).toString());
        params = params.append('size', datatable.rows == null ? '10' : datatable.rows.toString());

        const direction = datatable.sortOrder === 1 ? 'ASC' : 'DESC';
        params = params.append('sort', datatable.sortField == null ? '' : datatable.sortField + ',' + direction);

        return params;
    }

    static getRequestParams = (pageable?: Pageable): HttpParams => {
        let params = new HttpParams();
        if (pageable) {
            if (pageable.page) {
                params = params.append('page', pageable.page.toString());
            }
            if (pageable.size) {
                params = params.append('size', pageable.size.toString());
            }
            if (pageable.sort) {
                params = params.append('sort', pageable.sort.toString());
            }
        }
        return params;
    }
}
