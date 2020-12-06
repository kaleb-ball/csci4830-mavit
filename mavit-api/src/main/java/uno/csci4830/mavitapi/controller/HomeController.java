package uno.csci4830.mavitapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uno.csci4830.mavitapi.service.HomeService;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/config/{username}")
    public ResponseEntity<?> getHomePageConfig(@PathVariable String username) {
        try {
            return ResponseEntity.ok().body(homeService.getHomeConfig(username));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

}
