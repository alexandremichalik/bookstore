import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookListComponent } from './features/book-list/book-list.component';
import { BookDescriptionComponent } from './features/book-description/book-description.component';
import { UserListComponent } from './features/user-list/user-list.component';
import { UserDescriptionComponent } from './features/user-description/user-description.component';

const routes: Routes = [
  {
    path: 'getbooks',
    component: BookListComponent
  },
  {
    path: 'getbook',
    component: BookDescriptionComponent
  },
  {
    path: '',
    component: BookListComponent
  },
  {
    path: 'getusers',
    component: UserListComponent
  },
  {
    path: 'getuser',
    component: UserDescriptionComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
