package uno.csci4830.mavitapi.model;

import lombok.Getter;
import lombok.Setter;
import uno.csci4830.mavitapi.payload.request.comment.CreateCommentRequest;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String text;

    @NotBlank
    private String user;

    @NotBlank
    private LocalDateTime dateTime;

    @NotBlank
    private Boolean enabled;

    public Comment()
    {

    }

    public Comment(CreateCommentRequest ccr)
    {
        setText(ccr.getText());
        setUser(ccr.getUser());
        setTime(LocalDateTime.now());
        setEnabled(true);
    }

    private void setTime (LocalDateTime currentTime) {
        dateTime = currentTime;
    }

}
