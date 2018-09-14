import { Injectable } from '@angular/core';

import { RequestOptions, Headers} from '@angular/http';

@Injectable()
export class ApiService {
    
    constructor(){
    }


    getRequestOptions():RequestOptions{
        let headers = new Headers();
        headers.append("Content-Type", "application/json");
        return new RequestOptions({ headers: headers });
    }

}
