package uno.csci4830.mavitapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uno.csci4830.mavitapi.model.User;
import uno.csci4830.mavitapi.payload.response.HomePageResponse;
import uno.csci4830.mavitapi.repository.UserRepository;

import java.util.Optional;

@Service
public class HomeService {
    @Autowired
    UserRepository userRepository;

    public HomePageResponse getHomeConfig(String username) {
        HomePageResponse homePageResponse = new HomePageResponse();
        User user = userRepository.findByUsername(username).orElseThrow(
                ()->new RuntimeException("Error: User not present")
        );
        homePageResponse.setUniversities(user.getUniversities());
        homePageResponse.setColleges(user.getColleges());
        homePageResponse.setMajors(user.getMajors());
        return homePageResponse;
    }

}
