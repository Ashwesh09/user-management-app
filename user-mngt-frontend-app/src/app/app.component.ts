import { Component } from '@angular/core';
import { ProgressBarService } from './core/services/progress-bar/progress-bar.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(public progressBar : ProgressBarService){

  }

  fetchData() {
    console.log("Reloading data...");
    // Add logic to fetch or refresh data
  }
  title = 'user-management-app';
}
 