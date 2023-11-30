package kr.ac.gwnu.boardboard.entity.freeBoard;

import java.sql.Timestamp;

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
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "postId")
    private FreeBoardPost post;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private String content;
    private Timestamp timestamp;
}
