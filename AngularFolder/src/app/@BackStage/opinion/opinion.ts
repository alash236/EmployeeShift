import { Component} from '@angular/core';
import { HttpClientService } from '../../@Service/HttpClientService';


@Component({
  selector: 'app-back-opinion',
  imports: [],
  templateUrl: './opinion.html',
  styleUrl: './opinion.scss'
})
export class BackOpinion {

  constructor(
    private http:HttpClientService
  ){}

  ngOnInit(): void {


  }
}
