package uno.csci4830.mavitapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class TestController {

    @GetMapping("test")
    public String test() {
        return "Test";
    }
}
