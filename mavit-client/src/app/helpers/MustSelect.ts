import { FormGroup } from '@angular/forms';

export function MustSelect(controlName: string) {
    return (formGroup: FormGroup) => {
        const control = formGroup.controls[controlName];
        //const matchingControl = formGroup.controls[matchingControlName];

        if(control.value === "Choose...") {
            control.setErrors({mustSelect:true})
        } else {
            control.setErrors(null)
        }
    }
}