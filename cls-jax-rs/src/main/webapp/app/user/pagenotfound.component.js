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
var PageNotFountComponent = (function () {
    function PageNotFountComponent() {
    }
    PageNotFountComponent = __decorate([
        core_1.Component({
            selector: 'pageNotFound',
            template: 'Hello Sorry page is not found',
        }), 
        __metadata('design:paramtypes', [])
    ], PageNotFountComponent);
    return PageNotFountComponent;
}());
exports.PageNotFountComponent = PageNotFountComponent;
//# sourceMappingURL=pagenotfound.component.js.map