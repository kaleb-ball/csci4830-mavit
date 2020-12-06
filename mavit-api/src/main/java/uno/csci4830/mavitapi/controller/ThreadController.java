package uno.csci4830.mavitapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uno.csci4830.mavitapi.payload.request.thread.CreateThreadRequest;
import uno.csci4830.mavitapi.payload.request.thread.EditThreadRequest;
import uno.csci4830.mavitapi.service.ThreadService;

import static uno.csci4830.mavitapi.AuthUtils.canEdit;

@RestController
@RequestMapping("/api/thread")
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateThreadRequest createThreadRequest) {
        try {
            return ResponseEntity.ok().body(threadService.createThread(createThreadRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody EditThreadRequest editThreadRequest) {
        try {
            if (canEdit()) {
                return ResponseEntity.ok().body(threadService.editThread(editThreadRequest));
            } else {
                return ResponseEntity.status(403).body("User does not have permission to edit threads");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/threadsByPageId/{id}")
    public ResponseEntity<?> getThreads(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok().body(threadService.getThreadsByPageId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/threadById/{id}")
    public ResponseEntity<?> getThread(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok().body(threadService.getThreadById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




}
