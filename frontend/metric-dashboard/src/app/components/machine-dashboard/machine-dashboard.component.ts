import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { RxStompService } from '@stomp/ng2-stompjs';
import { Subscription } from 'rxjs';
import { Message } from '@stomp/stompjs';
import { ChartDataSets } from 'chart.js';
import { WheelMetric } from 'src/app/models/whellmetric';

@Component({
  selector: 'app-machine-dashboard',
  templateUrl: './machine-dashboard.component.html',
  styleUrls: ['./machine-dashboard.component.scss']
})
export class MachineDashboardComponent implements OnInit, OnDestroy {
  @Input() machineId: string;
  @Input() selectedMetrics: string[];

  private topicSubscription: Subscription;
  // Define parameter to inject in single machine chart
  pressChartTitle = 'Pessure';
  pressLineChartLabels = [];
  pressLineChartData: ChartDataSets[] = [
    { data: [], label: 'front-dx' },
    { data: [], label: 'front-sx' },
    { data: [], label: 'rear-dx' },
    { data: [], label: 'rear-sx' }
  ];

  tempChartTitle = 'Temperature';
  tempLineChartLabels = [];
  tempLineChartData: ChartDataSets[] = [
    { data: [], label: 'front-dx' },
    { data: [], label: 'front-sx' },
    { data: [], label: 'rear-dx' },
    { data: [], label: 'rear-sx' }
  ];

  omegaChartTitle = 'Angular velocity';
  omegaLineChartLabels = [];
  omegaLineChartData: ChartDataSets[] = [
    { data: [], label: 'front-dx' },
    { data: [], label: 'front-sx' },
    { data: [], label: 'rear-dx' },
    { data: [], label: 'rear-sx' }
  ];

  speedChartTitle = 'Speed';
  speedLineChartLabels = [];
  speedLineChartData: ChartDataSets[] = [
    { data: [], label: 'front-dx' },
    { data: [], label: 'front-sx' },
    { data: [], label: 'rear-dx' },
    { data: [], label: 'rear-sx' }
  ];

  constructor(private rxStompService: RxStompService) {}

  ngOnInit(): void {
    this.topicSubscription = this.rxStompService
      .watch('/topic/' + this.machineId)
      .subscribe((message: Message) => {
        console.log(message.body);
        const msg = JSON.parse(message.body);
        this.updateCharts(msg);
        // this.pressLineChartData[0].data.push(msg['Front Rigth'].press);
        // this.pressLineChartLabels.push(msg['Front Rigth'].timestamp);
        // console.log(this.pressLineChartData[0].data);
      });
  }

  ngOnDestroy() {
    this.topicSubscription.unsubscribe();
  }

  updateCharts(msgPayload: Map<string, WheelMetric>) {
    const newTimestamp = msgPayload['Front Rigth'].timestamp.substring(11, 19);
    this.pressLineChartLabels.push(newTimestamp);
    this.tempLineChartLabels.push(newTimestamp);
    this.omegaLineChartLabels.push(newTimestamp);
    this.speedLineChartLabels.push(newTimestamp);

    this.pressLineChartData[0].data.push(msgPayload['Front Rigth'].press);
    this.pressLineChartData[1].data.push(msgPayload['Front Left'].press);
    this.pressLineChartData[2].data.push(msgPayload['Rear Rigth'].press);
    this.pressLineChartData[3].data.push(msgPayload['Rear Left'].press);

    this.tempLineChartData[0].data.push(msgPayload['Front Rigth'].temp);
    this.tempLineChartData[1].data.push(msgPayload['Front Left'].temp);
    this.tempLineChartData[2].data.push(msgPayload['Rear Rigth'].temp);
    this.tempLineChartData[3].data.push(msgPayload['Rear Left'].temp);

    this.omegaLineChartData[0].data.push(msgPayload['Front Rigth'].omega);
    this.omegaLineChartData[1].data.push(msgPayload['Front Left'].omega);
    this.omegaLineChartData[2].data.push(msgPayload['Rear Rigth'].omega);
    this.omegaLineChartData[3].data.push(msgPayload['Rear Left'].omega);

    this.speedLineChartData[0].data.push(msgPayload['Front Rigth'].speed);
    this.speedLineChartData[1].data.push(msgPayload['Front Left'].speed);
    this.speedLineChartData[2].data.push(msgPayload['Rear Rigth'].speed);
    this.speedLineChartData[3].data.push(msgPayload['Rear Left'].speed);
  }

  isSelectedMetric(metric: string) {
    if (this.selectedMetrics.includes(metric)) {
      return true;
    }
    return false;
  }
}
