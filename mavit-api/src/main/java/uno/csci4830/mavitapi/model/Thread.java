package uno.csci4830.mavitapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @Size(max=100)
    private String title;

    @Size(max=256)
    private String description;

    //Page

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

}
