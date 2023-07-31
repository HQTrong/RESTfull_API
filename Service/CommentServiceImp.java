package tmdt.tmdt_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tmdt.tmdt_api.Entity.Comment;
import tmdt.tmdt_api.Model.DTO.CommentDTO;
import tmdt.tmdt_api.Model.Mapper.CommetMapper;
import tmdt.tmdt_api.Repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommentServiceImp implements CommentService {
    List<CommentDTO> list = new ArrayList<>();
    @Autowired
    private CommentRepository dao;

    @Override
    public List<CommentDTO> getAllCommentByID() {
        list = CommetMapper.toCommentDTOList(dao.getAllByOrderById());
        return list != null ? list : null;
    }

    @Override
    public CommentDTO addComment(CommentDTO commentDTO) {
        Comment comment = dao.save(CommetMapper.toComment(commentDTO));
        return comment != null ? commentDTO : null;
    }
}
