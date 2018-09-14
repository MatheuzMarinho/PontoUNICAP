import { Component } from '@angular/core';
import { Residente } from './model/Residente';
import { ResidenteService } from './service/ResidenteService';
import { PontoService } from './service/PontoService';
import { Ponto } from './model/Ponto';
import { PontoKey } from './model/PontoKey';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ResidenteService, PontoService]
})
export class AppComponent {
  title = 'app';
  //residentes:Array<Residente>;
  residentes:any
  pontos:any

  constructor(private residenteService: ResidenteService, private pontoService: PontoService) {
  }
  
  ngOnInit() {
    this.buscarResidentes();
    this.buscarPontos();
  }

  public buscarResidentes() {
    this.residenteService.getResidentes().subscribe(
      data => {
        this.residentes = data;
        console.log(this.residentes)
      },
      error => {
        console.log(error);
      }
    )
  }

  public buscarPontos() {
    this.pontoService.getPontos().subscribe(
      data => {
        this.pontos = data;
        console.log(this.pontos)
      },
      error => {
        console.log(error);
      }
    )
  }


  public entrar(matricula:String){
    let p:Ponto = new Ponto();
    let id:PontoKey = new PontoKey();
    let residente:Residente = new Residente();
    residente.matricula = matricula;
    id.residente = residente;
    p.id = id;
    this.pontoService.postAddEntrada(p).subscribe(
      data => {
        alert("Você entrou na residência!")
      },
      error => {
        console.log(error);
        alert("Erro! " + error._body)
      }
    )
  }

  public sair(matricula:String){
    let p:Ponto = new Ponto();
    let id:PontoKey = new PontoKey();
    let residente:Residente = new Residente();
    residente.matricula = matricula;
    id.residente = residente;
    p.id = id;
    this.pontoService.putSaida(p).subscribe(
      data => {
        alert("Você saiu da residência!")
      },
      error => {
        console.log(error);
        alert("Erro! " + error._body)
      }
    )
  }

  public cadastrar(nome:String, matricula:String){
    let residente:Residente = new Residente();
    residente.matricula = matricula;
    residente.nome = nome;
    this.residenteService.postResidente(residente).subscribe(
      data => {
        alert("Cadastrador com Sucesso!")
      },
      error => {
        console.log(error);
        alert("Erro ao cadastrar! " + error._body)
      }
    )
  }
    

}
