import {Routes, RouterModule } from '@angular/router'; //router is an optional feature of angular 2. Not build into angular core.
import {StaffMembermComponent} from './staff-form.component';
import {TestComponent} from './test.component';
import {PageNotFountComponent} from './pagenotfound.component';


const classAppRoutes : Routes = [ //URL path to componenet mapping
{
		path : '', //no leading slashes

		//redirectTo : 'www.google.com',
		//pathMatch : 'full'

		data: { //store abitary data associated with each specific route. accessible within each active route.
      		 title: 'Heroes List'  //ex: page title, read only data.
      		},
      		component : StaffMembermComponent

      	},
      	{
      		path : 'test',
		//redirectTo : 'www.google.com',
		//pathMatch : 'full'
			component : TestComponent

		},
		{
			path : 'display',
			loadChildren : 'blablabla'
		},
		{ 
			path: 'hero/:id',  //router parameter /hero/42
			component: TestComponent //this componet can use the parameter
		},
		
		{ 
			path: '**', 
			component: PageNotFountComponent 
		} 
	] ; 



	export const routing = RouterModule.forRoot(classAppRoutes);