package yountaewoo.Board.post.DTO;

public record CreatePostDto(
        String title,
        String content,
        Long id
) {
}
