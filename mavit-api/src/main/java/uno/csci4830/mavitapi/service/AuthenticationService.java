
package uno.csci4830.mavitapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uno.csci4830.mavitapi.enums.UserRoleEnum;
import uno.csci4830.mavitapi.model.Role;
import uno.csci4830.mavitapi.model.User;
import uno.csci4830.mavitapi.payload.request.LoginRequest;
import uno.csci4830.mavitapi.payload.request.SignupRequest;
import uno.csci4830.mavitapi.payload.response.JwtResponse;
import uno.csci4830.mavitapi.payload.response.MessageResponse;
import uno.csci4830.mavitapi.repository.RoleRepository;
import uno.csci4830.mavitapi.repository.UserRepository;
import uno.csci4830.mavitapi.security.jwt.JwtUtils;
import uno.csci4830.mavitapi.security.services.UserDetailsImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthenticationService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
                userDetails.getEmail(), roles);
    }

    public MessageResponse registerUser(SignupRequest signupRequest) {
        User user = new User();
        populatePersonalDetails(user, signupRequest);
        populateSchoolDetails(user, signupRequest);
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName(UserRoleEnum.USER).orElseThrow(
                () -> new RuntimeException("Error: Role Not Found")
        );
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        return new MessageResponse("User registered successfully");
    }

    public boolean checkUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean checkEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public MessageResponse registerMod(SignupRequest signupRequest) {
        return new MessageResponse("Fix");
    }

    private User populatePersonalDetails(User user, SignupRequest signupRequest) {
        user.setEmail(signupRequest.getEmail());
        user.setUsername(signupRequest.getUsername());
        user.setFirstName(signupRequest.getFirstname());
        user.setLastName(signupRequest.getLastname());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        return user;
    }

    private User populateSchoolDetails(User user, SignupRequest signupRequest) {
        user.setStudentId(signupRequest.getStudentId());
        //Add Other Fields
        return user;
    }
}
