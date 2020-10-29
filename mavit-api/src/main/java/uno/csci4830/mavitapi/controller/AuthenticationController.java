package uno.csci4830.mavitapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uno.csci4830.mavitapi.payload.request.LoginRequest;
import uno.csci4830.mavitapi.payload.request.SignupRequest;
import uno.csci4830.mavitapi.service.AuthenticationService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequets) {
        try {
            return ResponseEntity.ok().body(authenticationService.authenticateUser(loginRequets));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        try {
            if (authenticationService.checkUsername(signupRequest.getUsername())) {
                return ResponseEntity.badRequest().body("Username already in use");
            } else if (authenticationService.checkEmail(signupRequest.getEmail())) {
                return ResponseEntity.badRequest().body("Email already in use");
            } else {
                return ResponseEntity.ok(authenticationService.registerUser(signupRequest));
            }
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
