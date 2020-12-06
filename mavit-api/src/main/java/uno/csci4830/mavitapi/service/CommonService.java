package uno.csci4830.mavitapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uno.csci4830.mavitapi.enums.PageTypeEnum;
import uno.csci4830.mavitapi.model.*;
import uno.csci4830.mavitapi.payload.request.setup.CreateCollegeRequest;
import uno.csci4830.mavitapi.payload.request.setup.CreateMajorRequest;
import uno.csci4830.mavitapi.payload.request.setup.CreateUniversityRequest;
import uno.csci4830.mavitapi.payload.response.MessageResponse;
import uno.csci4830.mavitapi.repository.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CommonService {

    @Autowired
    MajorRepository majorRepository;

    @Autowired
    CollegeRepository collegeRepository;

    @Autowired
    PageRepository pageRepository;

    @Autowired
    PageTypeRepository pageTypeRepository;

    @Autowired
    UniversityRepository universityRepository;

    public MessageResponse createMajor(CreateMajorRequest majorRequest) throws Exception {
        College college = this.collegeRepository.getCollegeByCode(majorRequest.getCollegeCode());
        if (college == null) {
            throw new Exception("Bad College Code");
        }
        Major major = new Major();
        major.setCollege(college);
        major.setName(majorRequest.getName());
        major.setPage(createPage(PageTypeEnum.MAJOR));
        majorRepository.save(major);
        return new MessageResponse("Successfully created major");
    }

    public MessageResponse createCollege(CreateCollegeRequest collegeRequest) throws Exception {
       College college = new College();
        college.setName(collegeRequest.getName());
        college.setCode(collegeRequest.getCollegeCode());
        college.setPage(createPage(PageTypeEnum.COLLEGE));
        collegeRepository.save(college);
        return new MessageResponse("Successfully created major");
    }

    public MessageResponse createUniversity(CreateUniversityRequest universityRequest) throws Exception {
        University university = new University();
        university.setName(universityRequest.getName());
        university.setPage(createPage(PageTypeEnum.UNIVERSITY));
        university.setCode(universityRequest.getUniversityCode());
        universityRepository.save(university);
        return new MessageResponse("Successfully created major");
    }

    public List<College> getAllColleges() {
        return  StreamSupport
                .stream(collegeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Major> getMajorsByCollege(String code) {
        List<Major> list = majorRepository.getMajorsByCollegeCode(code);
         return list;
    }

    private Page createPage(PageTypeEnum pageTypeEnum) {
        Page page = new Page();
        page.setPageType(pageTypeRepository.findByName(pageTypeEnum).orElseThrow(() -> new RuntimeException("Bad Page Type")));
        Integer id = pageRepository.save(page).getId();
        return pageRepository.findById(id).orElseThrow(() -> new RuntimeException("Problem creating new page"));

    }

}
