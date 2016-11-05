import {Component} from 'angular2/core';

//encapsulate data and logic behind
@Component({
    // Declare the tag name in index.html(host element) to where the component attaches
    selector: 'hello-world',
  
    // Location of the template for this component
    templateUrl: 'src/hello_world.html',
    
    
    //the html to be injected can be configured here
    //template: 'this is'


})
export class HelloWorld {
  
    // Declaring the variable for binding with initial value
    // yourName = 'dd'; typescript can auto detect type, if we do not declare.
    yourName: string = 'dd';


}

