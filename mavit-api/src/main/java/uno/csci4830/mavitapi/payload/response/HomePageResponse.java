package uno.csci4830.mavitapi.payload.response;

import lombok.Getter;
import lombok.Setter;
import uno.csci4830.mavitapi.model.College;
import uno.csci4830.mavitapi.model.Major;
import uno.csci4830.mavitapi.model.University;

import java.util.Set;

@Getter
@Setter
public class HomePageResponse {

    private Set<University> universities;
    private Set<College> colleges;
    private Set<Major> majors;

}
