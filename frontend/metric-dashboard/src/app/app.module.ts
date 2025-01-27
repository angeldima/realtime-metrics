import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {
  InjectableRxStompConfig,
  RxStompService,
  rxStompServiceFactory
} from '@stomp/ng2-stompjs';
import { ChartsModule } from 'ng2-charts';
import { myRxStompConfig } from './my-rx-stomp.config';
import { MessagesComponent } from './messages/messages.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { InfoComponent } from './pages/info/info.component';
import { FooterComponent } from './ui-template/footer/footer.component';
import { HeaderComponent } from './ui-template/header/header.component';
import { LayoutComponent } from './ui-template/layout/layout.component';
import { MachineDashboardComponent } from './components/machine-dashboard/machine-dashboard.component';
import { LineChartComponent } from './components/line-chart/line-chart.component';
import { FilterOptionsComponent } from './components/filter-options/filter-options.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    MessagesComponent,
    HomepageComponent,
    InfoComponent,
    FooterComponent,
    HeaderComponent,
    LayoutComponent,
    MachineDashboardComponent,
    LineChartComponent,
    FilterOptionsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ChartsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
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
