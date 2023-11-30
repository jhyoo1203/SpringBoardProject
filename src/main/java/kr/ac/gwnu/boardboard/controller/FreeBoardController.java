package kr.ac.gwnu.boardboard.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kr.ac.gwnu.boardboard.dto.freeBoard.FreeBoardCommentDTO;
import kr.ac.gwnu.boardboard.dto.freeBoard.FreeBoardPostDTO;
import kr.ac.gwnu.boardboard.entity.freeBoard.FreeBoardComment;
import kr.ac.gwnu.boardboard.entity.freeBoard.FreeBoardPost;
import kr.ac.gwnu.boardboard.service.FreeBoardService;

@RestController
@RequestMapping("/api/freeboard")
public class FreeBoardController {
    private final FreeBoardService freeBoardService;

    @Autowired
    public FreeBoardController(FreeBoardService freeBoardService) {
        this.freeBoardService = freeBoardService;
    }

    @PostMapping("/post")
    public ResponseEntity<FreeBoardPost> createFreeBoardPost(@RequestBody FreeBoardPostDTO postDTO) {
        return freeBoardService.saveFreeBoardPost(postDTO)
                .map(post -> ResponseEntity.ok().body(post))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping("/comment")
    public ResponseEntity<FreeBoardComment> createFreeBoardComment(@RequestBody FreeBoardCommentDTO commentDTO) {
        return freeBoardService.saveFreeBoardComment(commentDTO)
                .map(comment -> ResponseEntity.ok().body(comment))
                .orElse(ResponseEntity.badRequest().build());
    }
}