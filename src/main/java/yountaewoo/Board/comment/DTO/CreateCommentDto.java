package yountaewoo.Board.comment.DTO;

public record CreateCommentDto(
        String content,
        Long postId
) {
}
