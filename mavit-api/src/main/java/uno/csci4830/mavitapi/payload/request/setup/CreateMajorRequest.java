package uno.csci4830.mavitapi.payload.request.setup;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateMajorRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String collegeCode;

}
