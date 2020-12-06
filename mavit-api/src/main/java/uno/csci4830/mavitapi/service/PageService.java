package uno.csci4830.mavitapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uno.csci4830.mavitapi.enums.PageTypeEnum;
import uno.csci4830.mavitapi.model.Page;
import uno.csci4830.mavitapi.payload.response.PageResponse;
import uno.csci4830.mavitapi.repository.CollegeRepository;
import uno.csci4830.mavitapi.repository.MajorRepository;
import uno.csci4830.mavitapi.repository.PageRepository;
import uno.csci4830.mavitapi.repository.UniversityRepository;

@Service
public class PageService {
    @Autowired
    PageRepository pageRepository;

    @Autowired
    MajorRepository majorRepository;

    @Autowired
    CollegeRepository collegeRepository;

    @Autowired
    UniversityRepository universityRepository;


    public PageResponse getPageById(Integer id) {
        Page page = pageRepository.findById(id).orElseThrow(() -> new RuntimeException("No Page Found"));
        PageTypeEnum pageTypeName = page.getPageType().getName();
        PageResponse pageResponse = new PageResponse();
        if (pageTypeName.equals(PageTypeEnum.UNIVERSITY)) {
            pageResponse.setId(page.getId());
            pageResponse.setTitle(universityRepository.findFirstByPage(page).getName());
        } else if (pageTypeName.equals(PageTypeEnum.COLLEGE)) {
            pageResponse.setId(page.getId());
            pageResponse.setTitle(collegeRepository.findFirstByPage(page).getName());
        } else if (pageTypeName.equals(PageTypeEnum.MAJOR)) {
            pageResponse.setId(page.getId());
            pageResponse.setTitle(majorRepository.findFirstByPage(page).getName());
        }

        return pageResponse;

    }

}
