import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {
  InjectableRxStompConfig,
  RxStompService,
  rxStompServiceFactory
} from '@stomp/ng2-stompjs';
import { myRxStompConfig } from './my-rx-stomp.config';
import { MessagesComponent } from './messages/messages.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { InfoComponent } from './pages/info/info.component';
import { FooterComponent } from './ui-template/footer/footer.component';
import { HeaderComponent } from './ui-template/header/header.component';
import { LayoutComponent } from './ui-template/layout/layout.component';
import { MachineDashboardComponent } from './components/machine-dashboard/machine-dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    MessagesComponent,
    HomepageComponent,
    InfoComponent,
    FooterComponent,
    HeaderComponent,
    LayoutComponent,
    MachineDashboardComponent
  ],
  imports: [BrowserModule, AppRoutingModule],
  providers: [
    {
      provide: InjectableRxStompConfig,
      useValue: myRxStompConfig
    },
    {
      provide: RxStompService,
      useFactory: rxStompServiceFactory,
      deps: [InjectableRxStompConfig]
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
