import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {
  // machineName = 'Volvo V40';
  machineId1 = 'Volvo V40';
  machineId2 = 'Porsche 911';
  machineId3 = 'Audi A6';

  constructor() {}

  ngOnInit(): void {}
}
