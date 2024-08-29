/* tslint:disable */
/* eslint-disable */
import { Cabinet } from '../models/cabinet';
export interface Disponibilite {
  HeureFermeture?: string;
  HeureOuverture?: string;
  cabinets?: Array<Cabinet>;
  dateOuverture?: string;
  heureFermeture?: string;
  heureOuverture?: string;
  id?: number;
}
