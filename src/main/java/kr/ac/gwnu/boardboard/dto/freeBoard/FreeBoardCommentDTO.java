package kr.ac.gwnu.boardboard.dto.freeBoard;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FreeBoardCommentDTO {
    private Long postId;
    private String content;
}
