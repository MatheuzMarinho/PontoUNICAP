import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { ApiService } from './ApiService';
import 'rxjs/add/operator/map';
import { Ponto } from '../model/Ponto';

@Injectable()
export class PontoService {
    constructor(private http: Http,
        private apiService: ApiService) {
    }

    postAddEntrada(ponto:Ponto) {
        return this.http.post("http://localhost:8080/ponto",JSON.stringify(ponto), this.apiService.getRequestOptions())
            .map(res => res.json());
    }

    putSaida(ponto:Ponto) {
        return this.http.put("http://localhost:8080/ponto",JSON.stringify(ponto), this.apiService.getRequestOptions())
            .map(res => res.json());
    }

    getPontos() {
        return this.http.get("http://localhost:8080/ponto/pontos", this.apiService.getRequestOptions())
            .map(res => res.json());
    }
}