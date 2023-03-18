import { Component } from '@angular/core';
import { User } from 'src/app/core/classes/User';
import { UserService } from 'src/app/core/services/user.service';

@Component({
  selector: 'app-user-description',
  templateUrl: './user-description.component.html',
  styleUrls: ['./user-description.component.scss']
})
export class UserDescriptionComponent {

  searchForm: number = 0;
  user: User | undefined;

  constructor(
    private userService: UserService
  ) {}

  submit(): void {
    this.userService.getUserById(this.searchForm).subscribe({
      next: res => this.user = res,
      error: err => console.error("No user found")
    })
  }

}
