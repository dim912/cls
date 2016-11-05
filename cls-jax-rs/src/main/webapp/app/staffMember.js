"use strict";
var StaffMember = (function () {
    function StaffMember(firstName, secondName, surName, nic, dob, homeAddress, city, town, homeTel, mobileTel, email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surName = surName;
        this.nic = nic;
        this.dob = dob;
        this.homeAddress = homeAddress;
        this.city = city;
        this.town = town;
        this.homeTel = homeTel;
        this.mobileTel = mobileTel;
        this.email = email;
    }
    return StaffMember;
}());
exports.StaffMember = StaffMember;
//# sourceMappingURL=staffMember.js.map