"use strict";
var router_1 = require('@angular/router'); //router is an optional feature of angular 2. Not build into angular core.
var staff_form_component_1 = require('./staff-form.component');
var test_component_1 = require('./test.component');
var pagenotfound_component_1 = require('./pagenotfound.component');
var classAppRoutes = [
    {
        path: '',
        //redirectTo : 'www.google.com',
        //pathMatch : 'full'
        data: {
            title: 'Heroes List' //ex: page title, read only data.
        },
        component: staff_form_component_1.StaffMembermComponent
    },
    {
        path: 'test',
        //redirectTo : 'www.google.com',
        //pathMatch : 'full'
        component: test_component_1.TestComponent
    },
    {
        path: 'display',
        loadChildren: 'blablabla'
    },
    {
        path: 'hero/:id',
        component: test_component_1.TestComponent //this componet can use the parameter
    },
    {
        path: '**',
        component: pagenotfound_component_1.PageNotFountComponent
    }
];
exports.routing = router_1.RouterModule.forRoot(classAppRoutes);
//# sourceMappingURL=app.routing.js.map