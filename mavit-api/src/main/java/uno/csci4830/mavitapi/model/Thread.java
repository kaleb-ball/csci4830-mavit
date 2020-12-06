package uno.csci4830.mavitapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uno.csci4830.mavitapi.payload.request.thread.CreateThreadRequest;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank
    @Size(max=100)
    private String title;

    @Size(max=256)
    private String description;

    @NotBlank
    private String createdBy;

    @NotBlank
    private String editedBy;

    @NotBlank
    private LocalDateTime createdDateTime;

    @NotBlank
    private LocalDateTime editedDateTime;

    @NotBlank
    private Boolean enabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(	name = "thread_page",
            joinColumns = @JoinColumn(name = "thread_id"),
            inverseJoinColumns = @JoinColumn(name = "page_id"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Page page;

}
