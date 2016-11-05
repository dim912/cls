Angular 2 - https://angular.io/docs/ts/latest/guide/

-> Can use in Typescript, Dert, javascript modes

templates -> are manegd by component classes
app logic -> in sergice class
boxing component and services -> in modules
launch the app by -> bootstraping the top root module

Componets call services to get/publish data
compments publish data on template by property binding
components getCalled by event binding

All  apping is done by MetaData.

Modules ( Angular Modules or NgModuels)
-------------------------------------------
Each app has atleast a one module => root moduel ( conventionally called AppModule)
 NgModule is a class with decarator => @NgModule
 
 
Data Binding => Is between Componet and the Template(part of DOM)

There are 4 type of bindings , binding markup is put on the template HTML(how to connect template, Componet sides)


		    				DOM         Component

{{value}}      				<----------------      oneTime / Interpollation
[property] = "value"        <----------------      property binding -> value of selected at the paranet tempate is passed to property of child componenet
(event) = "handler"         ---------------->      event bining -> calls a method on the componet
[(ng-module)] = proeprty    <--------------->      combie property and event bindig in a single notation using ngModel directive


<input [(ngModel)]="hero.name">

in two way binding => data flows from componet to template. and back to componet when the value at template chanegs.

SO data binding importatn in
	1) tempalte <-> componenet communication
	2) communication between parent and child compnenets
	
Directives
----------

angular templates are dynamic
=> when angular render them, => it trasform the DOM according to the instruction given by directives
	(So directievs are to manupulate DOM)
	
@Directive
export class{
}

@Component is really a directive which is extended with a template feature.


Directive types
	=> structural => alter layout by adding removing DOM elements Ex: ngFor, ngIf
	=> attribute => alter an existing element

Ex : Structural

<li *ngFor="let hero of heroes"></li>
	-> stampout li per hero

<hero-detail *ngIf="selectedHero"></hero-detail>
	-> inclue HeroDetail only if a selected hero exist
	
ngSwitch, ngStyle, ngClass
	
	
Ex : Attribute

ngModel => modify the element(<input>) by setting display value. and responding to chage events.

<input [(ngModel)]="hero.name">


Services
--------
componetns consume services

communicate to server, validate user inputs, log to console -> such tasks should be done by service class.

compnets job is -> enabling the user experiance. NOthing more.
	-> it mediate between applciation logic and the view(render by the template).
	

Angular 2 Dependency Injection Support
----------------------------------------

Most dependencies of components are services
Angular do the dependency injection to provide new components with the services they need.

=> DI supply a new instance of a class with fully-formed dependencies it requires.

In Angular 2
------------
=> the servies needed by the component can be mentinoed on the constructor.

Ex :

constructor(private service : HelloService ) {}

Angular DI mechanism
--------------------

1)  when angular creates an component, it asked for an injector for the services that componennt needs
2) injector maintains  a container of services(lazy loaded), precreated.
3) Injector inject services to the constructor when the componet is created.

4) injectors knows how to created services, from providers => by seeing 'providers'. 
(there should be a registered provider of each service with 
the injector)

registering providers
---------------------
=> at moduels
=> at components

when provider is at rootModule => same instance of service is avilabe everywhere

when the component is at Component => new instance of service is created for every creation of component


Pipes -> services who trasform values to display

price | currency:'USD':true 

here price will be displayed as $42.33.

Router -> navigate from page to page.


Display properties on template
------------------------------

Interpolation
	
	{{name}}
	=> display value on template does not auto change itslef, when the name at component chanegs.
	=> But after an event, like key press => it chanegs


User Inputs
-----------

user inputs trigger DOM events. -> they are listened on event binding, and back updated on the component and models.


Annotations vs Decorators
-------------------------

Annotation
----------
=> creates an annotation array


Decarator
---------
=> is a function, which takes the objectes of annotated class and do modificaitons on it.


Component Router
---------------
How to change views according to user activities.


<base href="/"> => is added as the first element of <head>, of index.html

if the app folder where index.html reside is the root, => <base href="/">


Aapplciation has a one router -> when the url changes, Anular looks at the router to find which component to display.

we should provide 
	=> array of routers to RouterModule.forRoot function.
	
	
	
	








 
	







