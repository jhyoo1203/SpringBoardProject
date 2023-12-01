package kr.ac.gwnu.boardboard.entity.freeBoard;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kr.ac.gwnu.boardboard.entity.User;
import lombok.Data;

@Entity
@Data
public class FreeBoardComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CommentID")
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "PostID")
    private FreeBoardPost post;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "Content")
    private String content;

    @Column(name = "Timestamp")
    private Timestamp timestamp;
}
