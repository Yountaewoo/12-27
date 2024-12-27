package yountaewoo.Board.post;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostRestController {

    private PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }
}
