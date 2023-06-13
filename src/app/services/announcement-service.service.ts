import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Announcement } from '../classes/announcement';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AnnouncementServiceService {
  private announcementUrl: string;

  constructor(private http: HttpClient) {
    this.announcementUrl = 'http://localhost:8080/api/quiz/getAll';
  }

  public findAll(): Observable<Announcement[]> {
    return this.http.get<Announcement[]>(this.announcementUrl);
  }
}
