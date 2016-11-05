import {Component} from '@angular/core';
//import {Staff} from './staff.component';

//decorator is @Component
@Component({
    selector: 'test-component',
    template : 'test hahaha'
})
export class TestComponent { 

constructor(){
	console.log("TestComponent");
}
	name = 'Dimuthu';

}