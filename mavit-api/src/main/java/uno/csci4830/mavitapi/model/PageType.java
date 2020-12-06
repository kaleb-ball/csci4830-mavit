package uno.csci4830.mavitapi.model;

import lombok.Getter;
import lombok.Setter;
import uno.csci4830.mavitapi.enums.PageTypeEnum;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="page_type",uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class PageType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private PageTypeEnum name;

}
