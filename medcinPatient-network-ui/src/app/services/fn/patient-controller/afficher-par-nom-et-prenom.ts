/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Medcin } from '../../models/medcin';

export interface AfficherParNomEtPrenom$Params {
  nom: string;
  prenom: string;
}

export function afficherParNomEtPrenom(http: HttpClient, rootUrl: string, params: AfficherParNomEtPrenom$Params, context?: HttpContext): Observable<StrictHttpResponse<Medcin>> {
  const rb = new RequestBuilder(rootUrl, afficherParNomEtPrenom.PATH, 'get');
  if (params) {
    rb.query('nom', params.nom, {});
    rb.query('prenom', params.prenom, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Medcin>;
    })
  );
}

afficherParNomEtPrenom.PATH = '/api/v1/patient/findMedcinByFullName';
