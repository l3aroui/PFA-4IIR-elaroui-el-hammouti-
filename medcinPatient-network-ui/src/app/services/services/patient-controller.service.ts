/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { afficherLesMedcin } from '../fn/patient-controller/afficher-les-medcin';
import { AfficherLesMedcin$Params } from '../fn/patient-controller/afficher-les-medcin';
import { afficherParAddresse } from '../fn/patient-controller/afficher-par-addresse';
import { AfficherParAddresse$Params } from '../fn/patient-controller/afficher-par-addresse';
import { afficherParNomEtPrenom } from '../fn/patient-controller/afficher-par-nom-et-prenom';
import { AfficherParNomEtPrenom$Params } from '../fn/patient-controller/afficher-par-nom-et-prenom';
import { afficherParSpecialite } from '../fn/patient-controller/afficher-par-specialite';
import { AfficherParSpecialite$Params } from '../fn/patient-controller/afficher-par-specialite';
import { Medcin } from '../models/medcin';

@Injectable({ providedIn: 'root' })
export class PatientControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `afficherParSpecialite()` */
  static readonly AfficherParSpecialitePath = '/api/v1/patient/findMedcinBy{libelle}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `afficherParSpecialite()` instead.
   *
   * This method doesn't expect any request body.
   */
  afficherParSpecialite$Response(params: AfficherParSpecialite$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<Medcin>>> {
    return afficherParSpecialite(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `afficherParSpecialite$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  afficherParSpecialite(params: AfficherParSpecialite$Params, context?: HttpContext): Observable<Array<Medcin>> {
    return this.afficherParSpecialite$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<Medcin>>): Array<Medcin> => r.body)
    );
  }

  /** Path part for operation `afficherParNomEtPrenom()` */
  static readonly AfficherParNomEtPrenomPath = '/api/v1/patient/findMedcinByFullName';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `afficherParNomEtPrenom()` instead.
   *
   * This method doesn't expect any request body.
   */
  afficherParNomEtPrenom$Response(params: AfficherParNomEtPrenom$Params, context?: HttpContext): Observable<StrictHttpResponse<Medcin>> {
    return afficherParNomEtPrenom(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `afficherParNomEtPrenom$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  afficherParNomEtPrenom(params: AfficherParNomEtPrenom$Params, context?: HttpContext): Observable<Medcin> {
    return this.afficherParNomEtPrenom$Response(params, context).pipe(
      map((r: StrictHttpResponse<Medcin>): Medcin => r.body)
    );
  }

  /** Path part for operation `afficherParAddresse()` */
  static readonly AfficherParAddressePath = '/api/v1/patient/byAddress';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `afficherParAddresse()` instead.
   *
   * This method doesn't expect any request body.
   */
  afficherParAddresse$Response(params: AfficherParAddresse$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<Medcin>>> {
    return afficherParAddresse(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `afficherParAddresse$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  afficherParAddresse(params: AfficherParAddresse$Params, context?: HttpContext): Observable<Array<Medcin>> {
    return this.afficherParAddresse$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<Medcin>>): Array<Medcin> => r.body)
    );
  }

  /** Path part for operation `afficherLesMedcin()` */
  static readonly AfficherLesMedcinPath = '/api/v1/patient/allMedcin';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `afficherLesMedcin()` instead.
   *
   * This method doesn't expect any request body.
   */
  afficherLesMedcin$Response(params?: AfficherLesMedcin$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<Medcin>>> {
    return afficherLesMedcin(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `afficherLesMedcin$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  afficherLesMedcin(params?: AfficherLesMedcin$Params, context?: HttpContext): Observable<Array<Medcin>> {
    return this.afficherLesMedcin$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<Medcin>>): Array<Medcin> => r.body)
    );
  }

}
