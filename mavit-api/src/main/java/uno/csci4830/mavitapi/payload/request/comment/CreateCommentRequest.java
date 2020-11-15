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

    public void setText(String comment_string)
    {
        text = comment_string;
    }

    public void setUser(String user_string)
    {
        user = user_string;
    }

    public String getText()
    {
        return text;
    }
    public String getUser()
    {
        return user;
    }

    //Add Thread Forgien key later

}
