package lt.viko.eif.api.service;

import lt.viko.eif.api.models.Comment;
import lt.viko.eif.api.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class manages comments
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * This method adds a comment
     *
     * @param comment Comment
     */
    @Override
    public void add(Comment comment) {
        commentRepository.save(comment);
    }
}
