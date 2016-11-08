"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
//import {Staff} from './staff.component';
//decorator is @Component
var AppComponent = (function () {
    function AppComponent() {
        this.name = 'Dimuthu';
        console.log("called AppComponent");
    }
    AppComponent = __decorate([
        core_1.Component({
            selector: 'cls-app',
            templateUrl: 'app/app.component.html',
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
            styleUrls: [
                '/dist/css/bootstrap.min.css" rel="stylesheet',
                '/dist/css/style.css" rel="stylesheet',
                '/dist/css/custom.css" rel="stylesheet'
            ]
        }), 
        __metadata('design:paramtypes', [])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map