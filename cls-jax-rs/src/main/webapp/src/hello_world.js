var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") return Reflect.decorate(decorators, target, key, desc);
    switch (arguments.length) {
        case 2: return decorators.reduceRight(function(o, d) { return (d && d(o)) || o; }, target);
        case 3: return decorators.reduceRight(function(o, d) { return (d && d(target, key)), void 0; }, void 0);
        case 4: return decorators.reduceRight(function(o, d) { return (d && d(target, key, o)) || o; }, desc);
    }
};
var core_1 = require('angular2/core');
//encapsulate data and logic behind
var HelloWorld = (function () {
    function HelloWorld() {
        // Declaring the variable for binding with initial value
        // yourName = 'dd'; typescript can auto detect type, if we do not declare.
        this.yourName = 'dd';
    }
    HelloWorld = __decorate([
        core_1.Component({
            // Declare the tag name in index.html(host element) to where the component attaches
            selector: 'hello-world',
            // Location of the template for this component
            templateUrl: 'src/hello_world.html',
        })
    ], HelloWorld);
    return HelloWorld;
})();
exports.HelloWorld = HelloWorld;
//# sourceMappingURL=hello_world.js.map