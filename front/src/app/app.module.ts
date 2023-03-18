import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookListComponent } from './features/book-list/book-list.component';
import { HttpClientModule } from '@angular/common/http';
import { NgxSpinnerModule } from 'ngx-spinner';
import { HeaderComponent } from './core/header/header.component';
import { BookDescriptionComponent } from './features/book-description/book-description.component';
import { FormsModule } from '@angular/forms';
import { UserListComponent } from './features/user-list/user-list.component';
import { UserDescriptionComponent } from './features/user-description/user-description.component';

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    HeaderComponent,
    BookDescriptionComponent,
    UserListComponent,
    UserDescriptionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxSpinnerModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
