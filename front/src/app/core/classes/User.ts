export class User {
  id: number;
  title: string;
  lastname: string;
  firstname: string;
  email: string;

  constructor(
    id: number,
    title: string,
    lastname: string,
    firstname: string,
    email: string
  ) {
    this.id = id;
    this.title = title;
    this.lastname = lastname;
    this.firstname = firstname;
    this.email = email;
  }
}
