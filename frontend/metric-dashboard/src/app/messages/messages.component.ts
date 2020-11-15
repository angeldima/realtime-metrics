import { Component, OnInit, OnDestroy, Input } from '@angular/core';
import { RxStompService } from '@stomp/ng2-stompjs';
import { Message } from '@stomp/stompjs';
import { Subscription } from 'rxjs';
import { WheelMetric } from '../models/whellmetric';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.scss']
})
export class MessagesComponent implements OnInit, OnDestroy {
  @Input() machineName: string;

  public receivedMessages: WheelMetric[] = [];
  private topicSubscription: Subscription;

  constructor(private rxStompService: RxStompService) {}

  ngOnInit() {
    this.topicSubscription = this.rxStompService
      .watch('/topic/demo')
      .subscribe((message: Message) => {
        console.log(message.body);
        let msg = JSON.parse(message.body);
        this.receivedMessages.push(msg['Front Rigth']);
      });
  }

  ngOnDestroy() {
    this.topicSubscription.unsubscribe();
  }

  onSendMessage() {
    const message = `Message generated at ${new Date()}`;
    this.rxStompService.publish({
      destination: '/app/chosemachine',
      body: message
    });
  }
}
