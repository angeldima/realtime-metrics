import { Component, OnInit } from '@angular/core';
import { FilterOptions } from 'src/app/models/filter-options';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {
  selectedMachineIds = [];
  selectedMetrics = [];
  filterOptionsVisible = true;

  constructor() {}

  ngOnInit(): void {}

  setupFilterOptions() {
    this.filterOptionsVisible = !this.filterOptionsVisible;
  }

  onSelectedFilterOptions(resp: FilterOptions) {
    this.selectedMachineIds = resp.machines;
    this.selectedMetrics = resp.metrics;
    this.filterOptionsVisible = !this.filterOptionsVisible;
  }

  onBackButton(resp: boolean) {
    this.filterOptionsVisible = resp;
  }
}
