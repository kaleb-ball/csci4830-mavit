package uno.csci4830.mavitapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uno.csci4830.mavitapi.model.Comment;
import uno.csci4830.mavitapi.model.Thread;
import uno.csci4830.mavitapi.payload.request.comment.CreateCommentRequest;
import uno.csci4830.mavitapi.payload.response.MessageResponse;
import uno.csci4830.mavitapi.repository.CommentRepository;
import uno.csci4830.mavitapi.repository.ThreadRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ThreadRepository threadRepository;

    public MessageResponse createComment(CreateCommentRequest createCommentRequest) {
        Comment comment = new Comment();
        comment.setDateTime(LocalDateTime.now());
        comment.setEnabled(true);
        comment.setText(createCommentRequest.getText());
        comment.setUser(createCommentRequest.getUser());
        comment.setThread(threadRepository.findById(createCommentRequest.getThreadId()).orElseThrow(
                ()-> new RuntimeException("Bad thread id")
        ));
        commentRepository.save(comment);


        return new MessageResponse("Comment created successfully");
    }

    public List<Comment> getCommentsByThreadId(Integer id) {
        Thread thread = threadRepository.findById(id).orElseThrow(()->new RuntimeException("Bad Thread Id"));
        return commentRepository.findAllByThread(thread);
    }

}
