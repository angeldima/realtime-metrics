import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2/dist/sweetalert2.js';
import { stringify } from 'querystring';

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
  machineIds = ['Volvo V40', 'Porsche 911', 'Audi A6'];
  tmpSelectedMachineIds = [];
  selectedMachineIds = [];

  constructor() {}

  ngOnInit(): void {}

  setupFilter() {
    Swal.mixin({
      confirmButtonText: 'Next &rarr;',
      showCancelButton: true,
      progressSteps: ['1', '2']
    })
      .queue([
        {
          title: 'Select Machines',
          html: this.prepareSelectElements(this.machineIds),
          preConfirm: () => {
            const machineList = [];
            this.machineIds.forEach(element => {
              if (
                Swal.getPopup().querySelector('#' + element.replace(/\s/g, ''))
                  .checked
              ) {
                machineList.push(element);
              }
            });
            this.tmpSelectedMachineIds = machineList;
            return machineList;
          }
        },
        {
          title: 'Select Metrics',
          input: 'checkbox'
        }
      ])
      .then(result => {
        if (result.value) {
          const answers = JSON.stringify(result.value);
          this.selectedMachineIds = this.tmpSelectedMachineIds;
          console.log(this.selectedMachineIds);
          Swal.fire({
            title: 'All done!',
            html: `
            Your answers:
            <pre><code>${answers}</code></pre>
          `,
            confirmButtonText: 'Lovely!'
          });
        }
      });
  }

  prepareSelectElements(elementList) {
    let htmlString = '';
    elementList.forEach(element => {
      htmlString +=
        '<h3>' +
        element +
        ' <input type="checkbox" id="' +
        element.replace(/\s/g, '') +
        '"  /></h3><p/>';
    });
    return htmlString;
  }

  getSelectedElements() {}
}
