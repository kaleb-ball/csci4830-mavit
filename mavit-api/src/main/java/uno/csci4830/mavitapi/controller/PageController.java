package uno.csci4830.mavitapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uno.csci4830.mavitapi.repository.CollegeRepository;
import uno.csci4830.mavitapi.repository.MajorRepository;
import uno.csci4830.mavitapi.repository.PageRepository;
import uno.csci4830.mavitapi.repository.UniversityRepository;
import uno.csci4830.mavitapi.service.PageService;

@RestController
@RequestMapping("/api/page")
public class PageController {

    @Autowired
    PageService pageService;


    @GetMapping("/{id}")
    ResponseEntity<?> getPageById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok().body(pageService.getPageById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
