import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ApiConfigurationService} from "./api-configuration.service";

@Injectable({
  providedIn: 'root'
})
export class BaseServiceService {

  constructor(
    protected config: ApiConfigurationService,
    protected http: HttpClient
  ) {}

  private _rootUrl?: string;

  get rootUrl(): string {
    return this._rootUrl || this.config.rootUrl;
  }

  set rootUrl(rootUrl: string) {
    this._rootUrl = rootUrl;
  }

}
