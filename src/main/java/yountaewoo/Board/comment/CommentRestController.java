package yountaewoo.Board.comment;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import yountaewoo.Board.comment.DTO.CreateCommentDto;
import yountaewoo.Board.comment.DTO.FindAllCommentResponse;
import yountaewoo.Board.comment.DTO.UpdateCommentDto;

import java.util.List;

@RestController
public class CommentRestController {

    private CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    //생성
    @PostMapping("/comments")
    public void createComment(@Valid @RequestBody CreateCommentDto createCommentDto) {
        commentService.CreateComment(createCommentDto);
    }

    //조회
    @GetMapping("/comments")
    public List<FindAllCommentResponse> findAll() {
        return commentService.findAll();
    }

    //수정
    @PutMapping("/comments/{commentId}")
    public void updateComment(@Valid @RequestBody UpdateCommentDto updateCommentDto, @PathVariable Long commentId) {
        commentService.updateComment(updateCommentDto, commentId);
    }

    //삭제
    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}
