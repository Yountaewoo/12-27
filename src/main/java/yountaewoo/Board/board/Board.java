package yountaewoo.Board.board;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import yountaewoo.Board.post.Post;

import java.util.List;
import java.util.Objects;

@Entity
public class Board {

    private String title;

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

    public void setTitle(String title) {
        this.title = title;
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
