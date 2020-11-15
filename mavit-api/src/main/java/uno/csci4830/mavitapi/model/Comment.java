package uno.csci4830.mavitapi.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;
import uno.csci4830.mavitapi.payload.request.comment.CreateCommentRequest;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

import uno.csci4830.mavitapi.payload.request.comment.CreateCommentRequest;

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
        setLocalDateTime(LocalDateTime.now());
        setEnabled(true);
    }
    public void setText(String inputText)
    {
        text = inputText;
    }
    public void setUser(String inputUser)
    {
        user = inputUser;
    }
    public void setLocalDateTime(LocalDateTime currentTime)
    {
        dateTime = currentTime;
    }
    public void setEnabled(Boolean isEnabled)
    {
        enabled = isEnabled;
    }


}
