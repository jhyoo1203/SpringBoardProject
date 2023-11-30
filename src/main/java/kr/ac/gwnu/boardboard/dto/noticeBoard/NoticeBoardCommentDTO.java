package kr.ac.gwnu.boardboard.dto.noticeBoard;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeBoardCommentDTO {
    private Long postId;
    private String content;
}
