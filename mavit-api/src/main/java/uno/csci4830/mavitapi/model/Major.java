
package uno.csci4830.mavitapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Major {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(	name = "major_college",
            joinColumns = @JoinColumn(name = "major_id"),
            inverseJoinColumns = @JoinColumn(name = "college_id"))
    private College college;

    @OneToOne( fetch = FetchType.EAGER)
    @JoinTable(	name = "major_page",
            joinColumns = @JoinColumn(name = "major_id"),
            inverseJoinColumns = @JoinColumn(name = "page_id"))
    private Page page;

}
