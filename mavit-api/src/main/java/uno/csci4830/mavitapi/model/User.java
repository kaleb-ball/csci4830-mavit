package uno.csci4830.mavitapi.model;

import lombok.Getter;
import lombok.Setter;
import uno.csci4830.mavitapi.enums.UserRoleEnum;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = {
            @UniqueConstraint(columnNames = "username"),
            @UniqueConstraint(columnNames = "email")
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max=50)
    private String firstName;

    @NotBlank
    @Size(max=50)
    private String lastName;

    @NotBlank
    @Size(max=50)
    private String username;

    @NotBlank
    @Size(max=50)
    @Email
    private String email;

    @NotBlank
    @Size(max=50)
    private String password;

    @NotBlank
    @Size(max=8)
    private String studentId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserRole> role = new HashSet<>();

}
