import {Component, NgModule, OnInit} from '@angular/core';
import {FormControl, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {Observable, of} from 'rxjs';
import {debounceTime, map, startWith, switchMap} from 'rxjs/operators';
import {MatIconModule} from '@angular/material/icon';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatOptionModule } from '@angular/material/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatSelectModule } from '@angular/material/select';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Router } from '@angular/router';
import { ProgressBarService } from 'src/app/core/services/progress-bar/progress-bar.service';
import { ApiService } from 'src/app/core/services/api/api.service';
import { MatButtonModule } from '@angular/material/button';
import { GlobalReloadService } from 'src/app/core/services/global-reload.service';
 
 
 
@Component({
  selector: 'home-app',
  templateUrl: 'home.component.html',
  styleUrls: ['home.component.scss'],
})
export class HomeComponent implements OnInit {
 
 
  constructor(private _apiService: ApiService, private router: Router,private progressBar : ProgressBarService,private globalReload : GlobalReloadService){
 
  }
 
  searchControl = new FormControl('');
  options: any[] = [];
  filteredOptions!: Observable<any[]>;
 
  ngOnInit() {
    this.fetchData();
    this.reloadCheck();
  }
 
 
  fetchData() {
    this.progressBar.isSearchInProgress = true;
    this._apiService.loadData().subscribe({
      next: (response : any) => {
        if (response.status === 'Success')
          this.setUsersData();
      },
      error: (error : any) => {
        console.error('Error fetching data:', error);
      }
    });
  }

  reloadCheck(){
    this.globalReload.currentData.subscribe(data => {
        if(data)
          this.fetchData();
    });
  }
 
  setUsersData(){
    this._apiService.getAllUsers().subscribe({
      next: (response : any) => {
        this.progressBar.isSearchInProgress = false;
        this.options = response;
        this.filterSearch();
 
      },
      error: (error : any) => {
        console.error('Error fetching data:', error);
      }
    });
  }
 
  filterSearch(){
   
    this.filteredOptions = this.searchControl.valueChanges.pipe(
      debounceTime(300),
      startWith(''),
      switchMap(value => (value ? this._apiService.searchUsers(value) : this._apiService.getAllUsers())) // Call API or return empty
    );
  }
 
 
 
  private _filter(name: string): any[] {
    const filterValue = name.toLowerCase();
    return this.options.filter((user : any) =>
      `${user.firstName} ${user.lastName}`.toLowerCase().includes(filterValue)
    );
  }
 
  displayFn(user: any | null): string {
    return user && user.firstName && user.lastName ? `${user.firstName} ${user.lastName}` : '';
  }
 
  onUserSelected(event: any) {
    const selectedUser: any = event.option.value;
    if (selectedUser) {
      this.router.navigate([`/user/${selectedUser.id}`]); // Redirect to user details page
    }
  }
  onReload(){
    this.fetchData();
  }
 
}
@NgModule({
  exports: [HomeComponent],
  declarations: [HomeComponent],
  imports: [BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatSelectModule,
    MatFormFieldModule,
    MatAutocompleteModule,
    MatIconModule,
    MatToolbarModule,
    MatButtonModule,
    MatTooltipModule
  ],
  providers: []
})
export class HomeModule { }