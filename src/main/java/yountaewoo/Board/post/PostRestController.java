package yountaewoo.Board.post;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import yountaewoo.Board.board.DTO.CreateBoardDto;
import yountaewoo.Board.post.DTO.CreatePostDto;
import yountaewoo.Board.post.DTO.FindPostResponse;
import yountaewoo.Board.post.DTO.UpdatePostRequestDto;

import java.util.List;

@RestController
public class PostRestController {

    private PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    //생성
    @PostMapping("/posts")
    public void createPost(@Valid @RequestBody CreatePostDto createPostDto) {
        postService.createPost(createPostDto);
    }

    //조회
    @GetMapping("/posts")
    public List<FindPostResponse> findAll() {
        return postService.findAll();
    }

    //수정
    @PutMapping("/posts/{postId}")
    public void updatePost(@Valid @RequestBody UpdatePostRequestDto updatePostRequestDto, @PathVariable Long postId) {
        postService.updatePost(updatePostRequestDto, postId);
    }

    //삭제
    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }
}
