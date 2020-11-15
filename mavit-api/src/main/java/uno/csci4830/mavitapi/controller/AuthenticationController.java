package uno.csci4830.mavitapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import uno.csci4830.mavitapi.payload.request.authentication.LoginRequest;
import uno.csci4830.mavitapi.payload.request.authentication.SignupRequest;
import uno.csci4830.mavitapi.payload.response.MessageResponse;
import uno.csci4830.mavitapi.service.AuthenticationService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequet) {
        try {
            return ResponseEntity.ok().body(authenticationService.authenticateUser(loginRequet));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body(new MessageResponse("Incorrect username or password"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        try {
            if (authenticationService.checkUsername(signupRequest.getUsername())) {
                return ResponseEntity.status(403).body(new MessageResponse("Username already in use"));
            } else if (authenticationService.checkEmail(signupRequest.getEmail())) {
                return ResponseEntity.status(403).body(new MessageResponse("Email already in use"));
            } else {
                return ResponseEntity.ok(authenticationService.registerUser(signupRequest));
            }
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
