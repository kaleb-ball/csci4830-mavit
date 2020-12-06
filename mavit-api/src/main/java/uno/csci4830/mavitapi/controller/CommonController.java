package uno.csci4830.mavitapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uno.csci4830.mavitapi.payload.request.setup.CreateCollegeRequest;
import uno.csci4830.mavitapi.payload.request.setup.CreateMajorRequest;
import uno.csci4830.mavitapi.payload.request.setup.CreateUniversityRequest;
import uno.csci4830.mavitapi.payload.response.MessageResponse;
import uno.csci4830.mavitapi.service.CommonService;

@RestController
@RequestMapping("/api/common")
public class CommonController {


    @Autowired
    CommonService commonService;

    @PostMapping("/createMajor")
    public ResponseEntity<?> createMajor(@RequestBody CreateMajorRequest createMajorRequest) {
        try {
            return ResponseEntity.ok(this.commonService.createMajor(createMajorRequest));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new MessageResponse(e.getMessage()));
        }
    }

    @PostMapping("/createCollege")
    public ResponseEntity<?> createCollege(@RequestBody CreateCollegeRequest createCollegeRequest) {
        try {
            return ResponseEntity.ok(this.commonService.createCollege(createCollegeRequest));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new MessageResponse(e.getMessage()));
        }
    }

    @PostMapping("/createUniversity")
    public ResponseEntity<?> createCollege(@RequestBody CreateUniversityRequest universityRequest) {
        try {
            return ResponseEntity.ok(this.commonService.createUniversity(universityRequest));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new MessageResponse(e.getMessage()));
        }
    }


    @GetMapping("/allColleges")
    public ResponseEntity<?> getAllColleges() {
        try {
          return ResponseEntity.ok().body(this.commonService.getAllColleges());
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/majorsByCollege/{code}")
    public ResponseEntity<?> getMajorsByColleges(@PathVariable String code) {
        try {
            return ResponseEntity.ok().body(this.commonService.getMajorsByCollege(code));
        } catch (Exception e ) {
            return ResponseEntity.status(400).body(new MessageResponse(e.getMessage()));
        }
    }

}
