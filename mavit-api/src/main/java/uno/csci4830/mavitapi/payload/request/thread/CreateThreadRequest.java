package uno.csci4830.mavitapi.payload.request.thread;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateThreadRequest {

    @NotBlank
    private String title;

    private String description;

    @NotBlank
    private String createUsername;

    //Page
}
