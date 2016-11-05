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
var staffMember_1 = require('./staffMember');
var StaffMembermComponent = (function () {
    function StaffMembermComponent() {
        this.powers = ['Really Smart', 'Super Flexible',
            'Super Hot', 'Weather Changer'
        ];
        this.model = new staffMember_1.StaffMember('Dimuthu', 'Darshana', 'Senanayaka', '872173137V', '2016-01-02', 'Galle', 'Galle', 'Galle', 234234234, 234234234, 'dim912@gmail.com');
        this.submitted = false;
        this.active = true;
        console.log("calledddd");
    }
    StaffMembermComponent.prototype.onSubmit = function (s) {
        JSON.stringify(this.model);
    };
    Object.defineProperty(StaffMembermComponent.prototype, "diagnostic", {
        get: function () {
            return JSON.stringify(this.model);
        },
        enumerable: true,
        configurable: true
    });
    StaffMembermComponent.prototype.newHero = function () {
        var _this = this;
        this.model = new staffMember_1.StaffMember('Dimuthu2', 'Darshana2', 'Senanayaka2', '872173137V', '2016-01-02', 'Galle', 'Galle', 'Galle', 234234234, 234234234, 'dim912@gmail.com');
        this.active = false;
        setTimeout(function () { return _this.active = true; }, 0);
    };
    StaffMembermComponent.prototype.showFormControls = function (form) {
        return form && form.controls['name'] &&
            form.controls['name'].value; // Dr. IQ
    };
    StaffMembermComponent.prototype.helloClick = function () {
        this.active = false;
        console.log(this.model.firstName);
        console.log(JSON.stringify(this.model));
    };
    StaffMembermComponent = __decorate([
        core_1.Component({
            selector: 'staffMember-form',
            templateUrl: 'app/staffMember-form.component.html'
        }), 
        __metadata('design:paramtypes', [])
    ], StaffMembermComponent);
    return StaffMembermComponent;
}());
exports.StaffMembermComponent = StaffMembermComponent;
//# sourceMappingURL=staff-form.component.js.map