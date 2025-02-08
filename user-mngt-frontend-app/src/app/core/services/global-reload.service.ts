import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GlobalReloadService {

  private dataSource = new BehaviorSubject<boolean>(false); 
  currentData = this.dataSource.asObservable(); 

  constructor() {}

  setReloadStatus(newData: boolean) {
    this.dataSource.next(newData); 
  }
}
