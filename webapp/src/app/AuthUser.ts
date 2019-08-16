export class AuthUser {
  loginId: string;
  authorities: string[];

  constructor(loginId: string) {
    this.loginId = loginId;
  }
}
