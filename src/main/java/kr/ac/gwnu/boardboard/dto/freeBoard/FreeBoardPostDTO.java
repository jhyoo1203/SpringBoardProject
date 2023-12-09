package kr.ac.gwnu.boardboard.dto.freeBoard;

import kr.ac.gwnu.boardboard.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class FreeBoardPostDTO {
    private Long postId;
    private User user;
    private String title;
    private String content;
    private Timestamp timestamp;
}
