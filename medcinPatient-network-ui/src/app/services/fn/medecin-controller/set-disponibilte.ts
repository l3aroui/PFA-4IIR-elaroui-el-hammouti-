/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Disponibilite } from '../../models/disponibilite';

export interface SetDisponibilte$Params {
  disponibilte: Disponibilite;
}

export function setDisponibilte(http: HttpClient, rootUrl: string, params: SetDisponibilte$Params, context?: HttpContext): Observable<StrictHttpResponse<{
}>> {
  const rb = new RequestBuilder(rootUrl, setDisponibilte.PATH, 'post');
  if (params) {
    rb.query('disponibilte', params.disponibilte, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<{
      }>;
    })
  );
}

setDisponibilte.PATH = '/medecin/cabinet/disponibilite/set';
