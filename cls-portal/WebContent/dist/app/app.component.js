System.register(['angular2/core', './staff.component'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, staff_component_1;
    var AppComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (staff_component_1_1) {
                staff_component_1 = staff_component_1_1;
            }],
        execute: function() {
            //decorator is @Component
            AppComponent = (function () {
                function AppComponent() {
                    this.name = 'Dimuthu';
                    console.log("called");
                }
                AppComponent = __decorate([
                    core_1.Component({
                        selector: 'cls-app',
                        templateUrl: '/app/test.html',
                        styleUrls: [
                            '/dist/css/bootstrap.min.css" rel="stylesheet',
                            '/dist/css/style.css" rel="stylesheet',
                            '/dist/css/custom.css" rel="stylesheet'
                        ],
                        directives: [staff_component_1.Staff]
                    }), 
                    __metadata('design:paramtypes', [])
                ], AppComponent);
                return AppComponent;
            }());
            exports_1("AppComponent", AppComponent);
        }
    }
});
//# sourceMappingURL=app.component.js.map