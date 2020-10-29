package uno.csci4830.mavitapi.model;

import lombok.Getter;
import lombok.Setter;
import uno.csci4830.mavitapi.enums.UserRoleEnum;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private UserRoleEnum name;
}
