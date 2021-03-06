import {Component} from '@angular/core';
import {StaffMember} from './staffMember';
@
Component({
    selector: 'staffMember-form',
    templateUrl: 'app/staffMember-form.component.html'
})
export class StaffMembermComponent {
    constructor() {
        console.log("calledddd");
    }
    powers = ['Really Smart', 'Super Flexible',
        'Super Hot', 'Weather Changer'
    ];

    model = new StaffMember('Dimuthu', 'Darshana', 'Senanayaka','872173137V', '2016-01-02', 'Galle', 'Galle', 'Galle', 234234234, 234234234, 'dim912@gmail.com');
    
    submitted = false;
    onSubmit(s:String) {
        JSON.stringify(this.model);

    }
    
    get diagnostic() {
        return JSON.stringify(this.model);
    }
    
    active = true;
    newHero() {
        this.model = new StaffMember('Dimuthu2', 'Darshana2', 'Senanayaka2','872173137V', '2016-01-02', 'Galle', 'Galle', 'Galle', 234234234, 234234234, 'dim912@gmail.com');
            this.active = false;
            setTimeout(() => this.active = true, 0);
        }

    showFormControls(form: any) {
        return form && form.controls['name'] &&
            form.controls['name'].value; // Dr. IQ
    }
    helloClick() {
        this.active = false;
        console.log(this.model.firstName);
        console.log(JSON.stringify(this.model));

    }
}
