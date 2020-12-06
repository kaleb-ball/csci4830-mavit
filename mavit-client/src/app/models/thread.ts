import { Page } from './page'

export class Thread {

    id : Number
    description : String
    createdBy : String
    editedBy : String
    createdDateTime : Date
    editedDateTime : Date
    enabled: Boolean
    page : Page
}