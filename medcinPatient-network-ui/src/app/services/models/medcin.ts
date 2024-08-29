/* tslint:disable */
/* eslint-disable */
import { Addresse } from '../models/addresse';
import { Cabinet } from '../models/cabinet';
import { GrantedAuthority } from '../models/granted-authority';
import { Role } from '../models/role';
import { Specialite } from '../models/specialite';
export interface Medcin {
  accountLocked?: boolean;
  accountNonExpired?: boolean;
  accountNonLocked?: boolean;
  addresse?: Addresse;
  authorities?: Array<GrantedAuthority>;
  cabinet?: Cabinet;
  createdDate?: string;
  credentialsNonExpired?: boolean;
  dateNaiss?: string;
  email?: string;
  enabled?: boolean;
  firstname?: string;
  fullName?: string;
  id?: number;
  lastModifiedDate?: string;
  lastname?: string;
  name?: string;
  password?: string;
  roles?: Array<Role>;
  specialite?: Specialite;
  telephone?: string;
  username?: string;
}
