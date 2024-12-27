package yountaewoo.Board.post.DTO;

public record FindPostResponse(
        String title,
        Long postId,
        String content
) {
}
