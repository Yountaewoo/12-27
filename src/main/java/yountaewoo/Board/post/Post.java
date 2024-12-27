package yountaewoo.Board.post;

import jakarta.persistence.*;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Objects;

@Entity
public class Post {

    private String title;

    private String content;

    private List<Comment> comments;

    @ManyToOne
    private Post board;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Post(Post board, String content, String title) {
        this.board = board;
        this.content = content;
        this.title = title;
    }

    public Post getBoard() {
        return board;
    }

    public String getContent() {
        return content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post board1 = (Post) o;
        return Objects.equals(title, board1.title) && Objects.equals(board, board1.board) && Objects.equals(content, board1.content) && Objects.equals(id, board1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, board, content, id);
    }
}
