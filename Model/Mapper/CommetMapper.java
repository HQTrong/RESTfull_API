package tmdt.tmdt_api.Model.Mapper;

import tmdt.tmdt_api.Entity.Account;
import tmdt.tmdt_api.Entity.Comment;
import tmdt.tmdt_api.Model.DTO.CommentDTO;

import java.util.ArrayList;
import java.util.List;

public class CommetMapper {
    public static Comment toComment(CommentDTO commentDTO) {
        Comment tmp = new Comment();
        tmp.setId(commentDTO.getId());
        tmp.setPhone(commentDTO.getPhone());
        tmp.setComment(commentDTO.getComment());
        tmp.setUsername(new Account(commentDTO.getUsername(), 0, null, null, null));
        return tmp;
    }

    public static List<CommentDTO> toCommentDTOList(List<Comment> comments) {
        List<CommentDTO> list = new ArrayList<>();
        for (Comment comment : comments) {
            CommentDTO tmp = new CommentDTO();
            tmp.setId(comment.getId());
            tmp.setPhone(comment.getPhone());
            tmp.setComment(comment.getComment());
            tmp.setUsername(comment.getUsername().getUsername());
            list.add(tmp);
        }
        return list;
    }
}
