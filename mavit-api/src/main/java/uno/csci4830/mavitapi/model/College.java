package uno.csci4830.mavitapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class College {

    @Id
    private int id;

    private String name;

    private String abbreviation;

}