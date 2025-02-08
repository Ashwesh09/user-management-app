import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MAT_AUTOCOMPLETE_SCROLL_STRATEGY_FACTORY_PROVIDER } from "@angular/material/autocomplete";
import { MAT_SELECT_SCROLL_STRATEGY_PROVIDER } from "@angular/material/select";
import { HttpClientModule } from '@angular/common/http';
import { HomeModule } from './components/home/home.component';
import {MatProgressBarModule} from '@angular/material/progress-bar';
 
 
 
@NgModule({
    declarations: [
        AppComponent
    ],
    providers: [MAT_SELECT_SCROLL_STRATEGY_PROVIDER,
        MAT_AUTOCOMPLETE_SCROLL_STRATEGY_FACTORY_PROVIDER],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        HttpClientModule,
        HomeModule,
        MatProgressBarModule
    ]
})
export class AppModule { }
 
 