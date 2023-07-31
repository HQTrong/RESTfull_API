package tmdt.tmdt_api.Repository;

import org.springframework.data.repository.CrudRepository;
import tmdt.tmdt_api.Entity.Comment;

import java.util.List;
import java.util.concurrent.CompletionException;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> getAllByOrderById();

    Comment save(Comment comment);
}
