import { NgModule }      from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { AppComponent }   from './app.component';
import {StaffMembermComponent} from './staff-form.component';
import { routing} from './app.routing'; 


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    routing  //pre configured routing module is imported
  ],
  declarations: [
    AppComponent,
    StaffMembermComponent
      ],
  providers: [
    
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {
}
