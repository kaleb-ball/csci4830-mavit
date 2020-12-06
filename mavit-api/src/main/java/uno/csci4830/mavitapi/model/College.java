package uno.csci4830.mavitapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "name"),
        @UniqueConstraint(columnNames = "code")
})
public class College {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(	name = "college_page",
            joinColumns = @JoinColumn(name = "college_id"),
            inverseJoinColumns = @JoinColumn(name = "page_id"))
    private Page page;

    private String name;

    private String code;


}
