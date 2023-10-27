package tmdt.tmdt_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tmdt.tmdt_api.Model.DTO.CommentDTO;
import tmdt.tmdt_api.Service.CommentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    List<CommentDTO> list = new ArrayList<>();
    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public ResponseEntity<?> getAllComment() {
        list = commentService.getAllCommentByID();
        return ResponseEntity.ok(list);
    }

    @PostMapping("")
    public ResponseEntity<?> addComment(@RequestBody CommentDTO commentDTO) {
        CommentDTO comment = commentService.addComment(commentDTO);
        return ResponseEntity.ok(comment);
    }
}
