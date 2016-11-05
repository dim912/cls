import {Component} from '@angular/core';
//import {Staff} from './staff.component';

//decorator is @Component
@Component({
    selector: 'cls-app',
    
    templateUrl : 'app/app.component.html',

    //Routing Component -> angular component with router-outlet
    //Angular router maintain the routing history -> back button of the browser work normally.


    /*template : ` 

     <nav>
    	<a routerLink="/test" routerLinkActive="active">Crisis Center</a>
  	</nav>
wwwwww
		<router-outlet></router-outlet>

wwwww

		asdf
    `, //the botom of the page is to be found by the component router
    //so router outlet is a component which is being assigned by the router.
    //what ever above the router outlet goes to the top of the page
    //routerout let is where router should display values

    /*
	ROUTER LINKS(RouterLink )
	-------------
	Does not change on the view given by the router. 
	can be used to navigate inside router
	-> one time bining to router links are fine, since they are not dynamic
	-> works only inside templates of components. But not in index.html

	ROUTER LINK ACTIVE(RouterLinkActive)
	-------------------------------------
	directive to each router tag to add or remove css classes, when router link is active.


    */
    styleUrls : [
		'/dist/css/bootstrap.min.css" rel="stylesheet',
		'/dist/css/style.css" rel="stylesheet',
		'/dist/css/custom.css" rel="stylesheet'
    ]
})
export class AppComponent { 

constructor(){
	console.log("called AppComponent");
}
	name = 'Dimuthu';

}