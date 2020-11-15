package uno.csci4830.mavitapi.service;

import uborg.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uno.csci4830.mavitapi.model.Comment;
import uno.csci4830.mavitapi.payload.request.comment.CreateCommentRequest;
import uno.csci4830.mavitapi.payload.response.MessageResponse;
import uno.csci4830.mavitapi.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public MessageResponse createComment(CreateCommentRequest createCommentRequest) {
        Comment comment = new Comment(createCommentRequest);
        commentRepository.save(comment);


        return new MessageResponse("Comment created successfully");
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAllByEnabled(true);
    }

}
