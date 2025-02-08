import { Component, EventEmitter, Output } from '@angular/core';
import { ProgressBarService } from './core/services/progress-bar/progress-bar.service';
import { GlobalReloadService } from './core/services/global-reload.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {


  constructor(public progressBar : ProgressBarService,private globleReload : GlobalReloadService){

  }
  onReload() {
    this.globleReload.setReloadStatus(true);
  }
}
 