System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var StaffService;
    return {
        setters:[],
        execute: function() {
            StaffService = (function () {
                function StaffService() {
                }
                StaffService.prototype.getCoursers = function () {
                    return ["123", "234", "32", "234", "3434"];
                };
                return StaffService;
            }());
            exports_1("StaffService", StaffService);
        }
    }
});
//# sourceMappingURL=course.service.js.map