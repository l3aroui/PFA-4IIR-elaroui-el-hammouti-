/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { DashboardDto } from '../models/dashboard-dto';
import { getAllDisponibilites } from '../fn/medecin-controller/get-all-disponibilites';
import { GetAllDisponibilites$Params } from '../fn/medecin-controller/get-all-disponibilites';
import { getCabinet } from '../fn/medecin-controller/get-cabinet';
import { GetCabinet$Params } from '../fn/medecin-controller/get-cabinet';
import { getDashboard } from '../fn/medecin-controller/get-dashboard';
import { GetDashboard$Params } from '../fn/medecin-controller/get-dashboard';
import { setDisponibilte } from '../fn/medecin-controller/set-disponibilte';
import { SetDisponibilte$Params } from '../fn/medecin-controller/set-disponibilte';

@Injectable({ providedIn: 'root' })
export class MedecinControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `getAllDisponibilites()` */
  static readonly GetAllDisponibilitesPath = '/medecin/cabinet/disponibilite';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllDisponibilites()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllDisponibilites$Response(params?: GetAllDisponibilites$Params, context?: HttpContext): Observable<StrictHttpResponse<{
}>> {
    return getAllDisponibilites(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllDisponibilites$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllDisponibilites(params?: GetAllDisponibilites$Params, context?: HttpContext): Observable<{
}> {
    return this.getAllDisponibilites$Response(params, context).pipe(
      map((r: StrictHttpResponse<{
}>): {
} => r.body)
    );
  }

  /** Path part for operation `setDisponibilte()` */
  static readonly SetDisponibiltePath = '/medecin/cabinet/disponibilite/set';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `setDisponibilte()` instead.
   *
   * This method doesn't expect any request body.
   */
  setDisponibilte$Response(params: SetDisponibilte$Params, context?: HttpContext): Observable<StrictHttpResponse<{
}>> {
    return setDisponibilte(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `setDisponibilte$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  setDisponibilte(params: SetDisponibilte$Params, context?: HttpContext): Observable<{
}> {
    return this.setDisponibilte$Response(params, context).pipe(
      map((r: StrictHttpResponse<{
}>): {
} => r.body)
    );
  }

  /** Path part for operation `getDashboard()` */
  static readonly GetDashboardPath = '/medecin/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getDashboard()` instead.
   *
   * This method doesn't expect any request body.
   */
  getDashboard$Response(params: GetDashboard$Params, context?: HttpContext): Observable<StrictHttpResponse<DashboardDto>> {
    return getDashboard(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getDashboard$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getDashboard(params: GetDashboard$Params, context?: HttpContext): Observable<DashboardDto> {
    return this.getDashboard$Response(params, context).pipe(
      map((r: StrictHttpResponse<DashboardDto>): DashboardDto => r.body)
    );
  }

  /** Path part for operation `getCabinet()` */
  static readonly GetCabinetPath = '/medecin/cabinet';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getCabinet()` instead.
   *
   * This method doesn't expect any request body.
   */
  getCabinet$Response(params?: GetCabinet$Params, context?: HttpContext): Observable<StrictHttpResponse<{
}>> {
    return getCabinet(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getCabinet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getCabinet(params?: GetCabinet$Params, context?: HttpContext): Observable<{
}> {
    return this.getCabinet$Response(params, context).pipe(
      map((r: StrictHttpResponse<{
}>): {
} => r.body)
    );
  }

}
