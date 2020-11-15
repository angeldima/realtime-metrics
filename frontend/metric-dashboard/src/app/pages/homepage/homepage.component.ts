import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2/dist/sweetalert2.js';

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

  setupFilter() {
    Swal.mixin({
      input: 'text',
      confirmButtonText: 'Next &rarr;',
      showCancelButton: true,
      progressSteps: ['1', '2', '3']
    })
      .queue([
        {
          title: 'Question 1',
          text: 'Chaining swal2 modals is easy'
        },
        'Question 2',
        'Question 3'
      ])
      .then(result => {
        if (result.value) {
          const answers = JSON.stringify(result.value);
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
}
