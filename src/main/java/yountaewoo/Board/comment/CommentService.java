package yountaewoo.Board.comment;

import org.springframework.stereotype.Service;
import yountaewoo.Board.comment.DTO.CreateCommentDto;
import yountaewoo.Board.comment.DTO.FindAllCommentResponse;
import yountaewoo.Board.comment.DTO.UpdateCommentDto;
import yountaewoo.Board.post.Post;
import yountaewoo.Board.post.PostRepository;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    // 생성
    public void CreateComment(CreateCommentDto createCommentDto) {
        Post find = postRepository.findById(createCommentDto.postId()).orElseThrow();
        Comment comment = new Comment(createCommentDto.content(), find);
        commentRepository.save(comment);
    }

    //조회
    public List<FindAllCommentResponse> findAll() {
        List<Comment> all = commentRepository.findAll();
        List<FindAllCommentResponse> findAllCommentResponses = all.stream()
                .map(comment -> new FindAllCommentResponse(comment.getContent(), comment.id))
                .toList();
        return findAllCommentResponses;
    }

    //수정
    public void updateComment(UpdateCommentDto updateCommentDto, Long commentId) {
        Comment find = commentRepository.findById(commentId).orElseThrow();
        find.setContent(updateCommentDto.content());
        commentRepository.save(find);
    }

    //삭제
    public void deleteComment(Long commentsId) {
        Comment find = commentRepository.findById(commentsId).orElseThrow();
        commentRepository.delete(find);
    }
}
