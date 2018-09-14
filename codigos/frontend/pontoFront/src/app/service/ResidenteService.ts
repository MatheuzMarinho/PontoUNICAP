import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { ApiService } from './ApiService';
import 'rxjs/add/operator/map';
import { Residente } from '../model/Residente';

@Injectable()
export class ResidenteService {
    constructor(private http: Http,
        private apiService: ApiService) {
    }

    getResidentes() {
        return this.http.get("http://localhost:8080/residente/residentes", this.apiService.getRequestOptions())
            .map(res => res.json());
    }

    postResidente(residente:Residente) {
        return this.http.post("http://localhost:8080/residente",JSON.stringify(residente), this.apiService.getRequestOptions())
            .map(res => res);
    }
}