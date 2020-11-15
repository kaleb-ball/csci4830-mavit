package uno.csci4830.mavitapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uno.csci4830.mavitapi.model.Thread;
import uno.csci4830.mavitapi.payload.request.thread.CreateThreadRequest;
import uno.csci4830.mavitapi.payload.request.thread.EditThreadRequest;
import uno.csci4830.mavitapi.payload.response.MessageResponse;
import uno.csci4830.mavitapi.repository.ThreadRepository;

import java.util.List;

@Service
public class ThreadService {

    @Autowired
    private ThreadRepository threadRepository;

    public MessageResponse createThread(CreateThreadRequest createThreadRequest) {
       Thread thread = new Thread(createThreadRequest);
       threadRepository.save(thread);
        return new MessageResponse("Thread created successfully");
    }

    public MessageResponse editThread(EditThreadRequest editThreadRequest) {
        return new MessageResponse("Thread edited successfully");
    }

    public MessageResponse deleteThread() {
        return new MessageResponse("Thread deleted successfully");
    }

    public List<Thread> getAllThreads() {
        return this.threadRepository.findAllByEnabled(true);
    }



}
