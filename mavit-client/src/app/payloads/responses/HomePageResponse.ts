import { College } from 'src/app/models/college'
import { Major } from 'src/app/models/major'
import { University } from 'src/app/models/university'

export class HomePageResponse {
    
    universities : University[] = []
    colleges : College[] = []
    majors : Major[] = []
}