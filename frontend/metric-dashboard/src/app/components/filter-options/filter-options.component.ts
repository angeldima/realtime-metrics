import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { FilterOptions } from 'src/app/models/filter-options';
import { MachineService } from 'src/app/services/machine.service';

@Component({
  selector: 'app-filter-options',
  templateUrl: './filter-options.component.html',
  styleUrls: ['./filter-options.component.scss']
})
export class FilterOptionsComponent implements OnInit {
  @Output() selectedFilterOptions = new EventEmitter<FilterOptions>();
  // Add API call to get allMachines list
  allMachines = [];
  selectedMachines = [];
  selectedMetrics = [];

  machineFormGroup: FormGroup = new FormGroup({});

  metricFormGroup = new FormGroup({
    press: new FormControl(true),
    temp: new FormControl(true),
    omega: new FormControl(true),
    speed: new FormControl(true)
  });

  constructor(private machineService: MachineService) {}

  ngOnInit(): void {
    this.machineService.findAll().subscribe(resp => {
      const group = {};
      resp.forEach(m => {
        group[this.prepareFormControlName(m)] = new FormControl(true);
      });
      console.log(group);
      this.machineFormGroup = new FormGroup(group);
      this.allMachines = resp;
    });
  }

  prepareFormControlName(name: string) {
    return name.toLowerCase().replace(/\s/g, '');
  }

  onSubmit() {
    // TODO - Dinamicizzare
    // Filter selected machines
    if (this.machineFormGroup.get('volvov40').value) {
      this.selectedMachines.push('Volvo V40');
    }
    if (this.machineFormGroup.get('porsche911').value) {
      this.selectedMachines.push('Porsche 911');
    }
    if (this.machineFormGroup.get('audia6').value) {
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
