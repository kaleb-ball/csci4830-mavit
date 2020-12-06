import { College } from 'src/app/models/college';
import { Major } from 'src/app/models/major';

export class SignupRequest {
    firstname : string;
    lastname : string;
    username : string;
    password : string;
    email : string;
    studentId : string;
    colleges : String[] = [];
    majors : String[] = []
}