import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpModule } from '@angular/http';
import { ApiService } from './service/ApiService';
import { ResidenteService } from './service/ResidenteService';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
  ],
  providers: [ApiService,ResidenteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
