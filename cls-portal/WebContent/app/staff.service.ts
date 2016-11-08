import {Injectable} from '@angular/core';

@Injectable()
export class StaffService {


    getContacts(): String[] {

        return ["123", "234", "32", "234", "34345"];
    }

}