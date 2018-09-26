import { Headers } from '@angular/http';

export class Wrapper {
  constructor(
    public headers: Headers,
    public json: any,
    public status: number
  ) { }
}
