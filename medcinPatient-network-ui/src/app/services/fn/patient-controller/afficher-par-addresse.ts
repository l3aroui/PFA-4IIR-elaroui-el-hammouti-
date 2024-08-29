/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Medcin } from '../../models/medcin';

export interface AfficherParAddresse$Params {
  city: string;
  country: string;
  codePostal: number;
}

export function afficherParAddresse(http: HttpClient, rootUrl: string, params: AfficherParAddresse$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<Medcin>>> {
  const rb = new RequestBuilder(rootUrl, afficherParAddresse.PATH, 'get');
  if (params) {
    rb.query('city', params.city, {});
    rb.query('country', params.country, {});
    rb.query('codePostal', params.codePostal, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<Medcin>>;
    })
  );
}

afficherParAddresse.PATH = '/api/v1/patient/byAddress';
