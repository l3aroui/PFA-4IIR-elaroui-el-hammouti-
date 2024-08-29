/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Medcin } from '../../models/medcin';

export interface AfficherParSpecialite$Params {
  libelle: string;
}

export function afficherParSpecialite(http: HttpClient, rootUrl: string, params: AfficherParSpecialite$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<Medcin>>> {
  const rb = new RequestBuilder(rootUrl, afficherParSpecialite.PATH, 'get');
  if (params) {
    rb.path('libelle', params.libelle, {});
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

afficherParSpecialite.PATH = '/api/v1/patient/findMedcinBy{libelle}';
