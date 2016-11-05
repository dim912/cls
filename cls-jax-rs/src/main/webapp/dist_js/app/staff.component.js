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
var staff_service_1 = require('./staff.service');
var auto_grow_directive_1 = require('./auto-grow.directive');
//encapsulate data and logic behind
var Staff = (function () {
    function Staff(staffService) {
        // Declaring the variable for binding with initial value
        // yourName = 'dd'; typescript can auto detect type, if we do not declare.
        this.name = 'Staff user 1';
        this.contacts = staffService.getContacts();
    }
    Staff = __decorate([
        core_1.Component({
            // Declare the tag name in index.html(host element) to where the component attaches
            selector: 'staff',
            // Location of the template for this component
            //templateUrl: 'src/hello_world.html',
            template: "TEST STAFF {{name}}\n\n    <input type=\"text\" autoGrow />\n    <ul>\n      <li *ngFor = \"#contact of contacts\">\n          {{contact}}\n       </li>\n    </ul>\n    ",
            providers: [staff_service_1.StaffService],
            directives: [auto_grow_directive_1.AutoGrowDirective]
        }), 
        __metadata('design:paramtypes', [staff_service_1.StaffService])
    ], Staff);
    return Staff;
}());
exports.Staff = Staff;
//# sourceMappingURL=staff.component.js.map