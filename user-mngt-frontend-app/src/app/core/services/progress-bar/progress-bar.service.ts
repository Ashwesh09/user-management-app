import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProgressBarService {

  isSearchInProgress = false;

  constructor() { }
}
