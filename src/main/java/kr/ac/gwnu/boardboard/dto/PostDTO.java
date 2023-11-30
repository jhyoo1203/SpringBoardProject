package kr.ac.gwnu.boardboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDTO {
    private String title;
    private String content;
}
