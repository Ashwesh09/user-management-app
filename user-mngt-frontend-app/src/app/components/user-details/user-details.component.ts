import { Component, NgModule, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {MatCardModule} from '@angular/material/card';
import {MatDividerModule} from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';
import { ProgressBarService } from 'src/app/core/services/progress-bar/progress-bar.service';
import { ApiService } from 'src/app/core/services/api/api.service';
 
 
@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {
  user: any;
 
  constructor(public route: ActivatedRoute, private _apiService : ApiService,private _router : Router,private progressBar : ProgressBarService) {}
 
  ngOnInit() {
    const userId = this.route.snapshot.paramMap.get('id');
    if (userId) {
      this.progressBar.isSearchInProgress = true;
      this._apiService.getUserById(userId).subscribe(data => {
        this.progressBar.isSearchInProgress = false;
        this.user = data;
        console.log('User Details:', this.user);
      });
    }
  }
 
  redirectToHome(){
    this._router.navigate(['']);
  }
}
@NgModule({
  exports: [UserDetailsComponent],
  declarations: [UserDetailsComponent],
  imports: [MatCardModule, MatDividerModule, MatButtonModule],
})
export class UserDetailsModule { }