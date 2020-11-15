package uno.csci4830.mavitapi.payload.request.comment;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateCommentRequest {
    @NotBlank
    private String text;

    @NotBlank
    private String user;

    //Add Thread Forgien key later

}

