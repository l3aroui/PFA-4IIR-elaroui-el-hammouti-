/* tslint:disable */
/* eslint-disable */
import { Disponibilite } from '../models/disponibilite';
import { Medcin } from '../models/medcin';
export interface Cabinet {
  disponibilites?: Array<Disponibilite>;
  id?: number;
  localisation?: string;
  med?: Medcin;
}
