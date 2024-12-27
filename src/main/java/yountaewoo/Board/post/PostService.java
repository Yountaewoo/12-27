package yountaewoo.Board.post;

import org.springframework.stereotype.Service;
import yountaewoo.Board.board.Board;
import yountaewoo.Board.board.BoardRepository;
import yountaewoo.Board.post.DTO.CreatePostDto;
import yountaewoo.Board.post.DTO.FindPostResponse;
import yountaewoo.Board.post.DTO.UpdatePostRequestDto;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    public PostService(PostRepository postRepository, BoardRepository boardRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
    }

    //생성
    public void createPost(CreatePostDto createPostDto) {
        Board findBoard = boardRepository.findById(createPostDto.id()).orElseThrow();
        Post post = new Post(findBoard, createPostDto.content(), createPostDto.title());
        postRepository.save(post);
    }

    //조회
    public List<FindPostResponse> findAll() {
        List<Post> finds = postRepository.findAll();
        List<FindPostResponse> findPostResponse = finds.stream()
                .map(find -> new FindPostResponse(find.getTitle(), find.getId(), find.getContent()))
                .toList();
        return findPostResponse;
    }

    //수정
    public void updatePost(UpdatePostRequestDto updatePostRequestDto, Long postId) {
        Post find = postRepository.findById(postId).orElseThrow();
        find.setContent(updatePostRequestDto.content());
        find.setTitle(updatePostRequestDto.title());
        postRepository.save(find);
    }

    //삭제
    public void deletePost(Long postId) {
        Post find = postRepository.findById(postId).orElseThrow();
        postRepository.delete(find);
    }
}
