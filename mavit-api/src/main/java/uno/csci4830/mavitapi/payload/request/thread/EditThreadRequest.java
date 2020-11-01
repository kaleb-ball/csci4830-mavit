package uno.csci4830.mavitapi.payload.request.thread;

import javax.validation.constraints.NotBlank;

public class EditThreadRequest {

    @NotBlank
    private String title;

    private String description;

    @NotBlank
    private String editUsername;

}
