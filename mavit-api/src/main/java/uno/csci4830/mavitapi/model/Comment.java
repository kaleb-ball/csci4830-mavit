package uno.csci4830.mavitapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uno.csci4830.mavitapi.payload.request.comment.CreateCommentRequest;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "comment")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(	name = "comment_thread",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "thread_id"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Thread thread;


}
