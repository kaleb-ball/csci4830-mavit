package uno.csci4830.mavitapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uno.csci4830.mavitapi.model.Page;
import uno.csci4830.mavitapi.model.Thread;
import uno.csci4830.mavitapi.payload.request.thread.CreateThreadRequest;
import uno.csci4830.mavitapi.payload.request.thread.EditThreadRequest;
import uno.csci4830.mavitapi.payload.response.MessageResponse;
import uno.csci4830.mavitapi.repository.PageRepository;
import uno.csci4830.mavitapi.repository.ThreadRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ThreadService {

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private PageRepository pageRepository;

    public MessageResponse createThread(CreateThreadRequest createThreadRequest) {
       Thread thread = new Thread();
       LocalDateTime now = LocalDateTime.now();
       Page page = pageRepository.findById(createThreadRequest.getPageId()).orElseThrow(
               ()->new RuntimeException("Bad Page Number"));
       thread.setTitle(createThreadRequest.getTitle());
       thread.setDescription(createThreadRequest.getDescription());
       thread.setCreatedBy(createThreadRequest.getCreateUsername());
       thread.setEditedBy(createThreadRequest.getCreateUsername());
       thread.setCreatedDateTime(now);
       thread.setEditedDateTime(now);
       thread.setEnabled(true);
       thread.setPage(page);
       threadRepository.save(thread);
       return new MessageResponse("Thread created successfully");
    }

    public MessageResponse editThread(EditThreadRequest editThreadRequest) {
        return new MessageResponse("Thread edited successfully");
    }

    public MessageResponse deleteThread() {
        return new MessageResponse("Thread deleted successfully");
    }

    public List<Thread> getThreadsByPageId(Integer id) {
        Page page = pageRepository.findById(id).orElseThrow(()-> new RuntimeException("Bad Page Number"));
        return this.threadRepository.findAllByPage(page);
    }

    public Thread getThreadById(Integer id) {
        return this.threadRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Bad Thread Id"));
    }

}
