package uno.csci4830.mavitapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uno.csci4830.mavitapi.model.User;
import uno.csci4830.mavitapi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("testPass");
        user.setEmail("testEmail");
        userRepository.save(user);
    }
}
