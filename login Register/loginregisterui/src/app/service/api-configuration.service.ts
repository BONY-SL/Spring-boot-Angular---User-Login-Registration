import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiConfigurationService {

  rootUrl: string = 'http://localhost:8088/api/v1';
  constructor() { }
}
export interface ApiConfigurationParams {
  rootUrl?: string;
}
