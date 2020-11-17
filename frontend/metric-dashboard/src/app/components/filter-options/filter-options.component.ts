import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { FilterOptions } from 'src/app/models/filter-options';

@Component({
  selector: 'app-filter-options',
  templateUrl: './filter-options.component.html',
  styleUrls: ['./filter-options.component.scss']
})
export class FilterOptionsComponent implements OnInit {
  @Output() selectedFilterOptions = new EventEmitter<FilterOptions>();
  // Add API call to get allMachines list
  selectedMachines = [];
  selectedMetrics = [];

  machineFormGroup = new FormGroup({
    volvoV40: new FormControl(true),
    porsche911: new FormControl(true),
    audiA6: new FormControl(true)
  });

  metricFormGroup = new FormGroup({
    press: new FormControl(true),
    temp: new FormControl(true),
    omega: new FormControl(true),
    speed: new FormControl(true)
  });

  constructor() {}

  ngOnInit(): void {}

  onSubmit() {
    // Filter selected machines
    if (this.machineFormGroup.get('volvoV40').value) {
      this.selectedMachines.push('Volvo V40');
    }
    if (this.machineFormGroup.get('porsche911').value) {
      this.selectedMachines.push('Porsche 911');
    }
    if (this.machineFormGroup.get('audiA6').value) {
      this.selectedMachines.push('Audi A6');
    }

    // Filter selected metrics
    if (this.metricFormGroup.get('press').value) {
      this.selectedMetrics.push('press');
    }
    if (this.metricFormGroup.get('temp').value) {
      this.selectedMetrics.push('temp');
    }
    if (this.metricFormGroup.get('omega').value) {
      this.selectedMetrics.push('omega');
    }
    if (this.metricFormGroup.get('speed').value) {
      this.selectedMetrics.push('speed');
    }

    this.selectedFilterOptions.emit({
      machines: this.selectedMachines,
      metrics: this.selectedMetrics
    });
  }
}
