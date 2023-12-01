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
public class FreeBoardPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PostID")
    private Long postId;
    
    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "Title")
    private String title;

    @Column(name = "Content")
    private String content;

    @Column(name = "Timestamp")
    private Timestamp timestamp;
}
