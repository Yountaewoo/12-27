package yountaewoo.Board.post;

import jakarta.persistence.*;
import yountaewoo.Board.board.Board;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Objects;

@Entity
public class Post {

    private String title;

    private String content;

    private List<Comment> comments;

    @ManyToOne
    private Board board;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected Post() {

    }

    public Post(Board board, String content, String title) {
        this.board = board;
        this.content = content;
        this.title = title;
    }

    public Board getBoard() {
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

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
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
