import {Component, OnInit, Inject} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

export interface DialogData {
  animal: string;
  name: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements OnInit {
  public title: any = 'MovieGo';
  public movies: any = [];
  public movie: any = {};

  constructor(
    private http: HttpClient,
    public dialog: MatDialog) {

  }

  ngOnInit() {
    this.http.get<any>('http://localhost:8080/api/movies/popular').toPromise().then((response) => {
      this.movies = response;
    }, (error) => {
      console.log('Error');
    });
  }

  onSearchChange(searchValue: string) {
    this.http.get<any>(' http://localhost:8080/api/movies/search?query=' + searchValue).toPromise().then((response) => {
      this.movies = response;
    }, (error) => {
      console.log('Error');
    });
  }

  openDialog(id: string): void {
    this.http.get<any>('http://localhost:8080/api/movies/search/' + id).toPromise().then((response) => {
      const dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
        minWidth: '320px',
        maxWidth: '548px',
        data: response
      });
    }, (error) => {
      console.log('Error');
    });
  }
}


@Component({
  templateUrl: 'dialog.html',
})

export class DialogOverviewExampleDialog {
  constructor(
    public dialogRef: MatDialogRef<DialogOverviewExampleDialog>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {
  }

  closeDialog(): void {
    this.dialogRef.close();
  }
}
