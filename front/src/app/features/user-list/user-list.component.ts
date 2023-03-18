import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/core/classes/User';
import { UserService } from 'src/app/core/services/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {
  users: User[] = [];

  constructor(
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.fetchUsers();
  }

  fetchUsers(): void {
    this.userService.getUsers().subscribe({
      next: res => this.users = res,
      error: err => console.error("Error while fetching users : " + err)
    })
  }
}
