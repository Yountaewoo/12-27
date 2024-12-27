package yountaewoo.Board.comment;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentRestController {

    private CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }
}
