package yountaewoo.Board.board;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import yountaewoo.Board.post.Post;

import java.util.List;
import java.util.Objects;

public class Board {

    private String title;

    private List<Post> posts;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected Board() {

    }

    public Board(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(title, board.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
