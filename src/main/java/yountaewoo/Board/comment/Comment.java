package yountaewoo.Board.comment;

import jakarta.persistence.*;
import yountaewoo.Board.post.Post;

import java.util.Objects;

@Entity
public class Comment {

    private String content;

    @ManyToOne
    private Post post;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }

    public String getContent() {
        return content;
    }

    public Long getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(content, comment.content) && Objects.equals(post, comment.post) && Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, post, id);
    }
}
