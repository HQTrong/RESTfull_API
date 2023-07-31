package tmdt.tmdt_api.Service;

import org.springframework.stereotype.Service;
import tmdt.tmdt_api.Model.DTO.CommentDTO;

import java.util.List;

@Service
public interface CommentService {
    List<CommentDTO> getAllCommentByID();

    CommentDTO addComment(CommentDTO commentDTO);
}
