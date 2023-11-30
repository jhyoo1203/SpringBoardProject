package kr.ac.gwnu.boardboard.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kr.ac.gwnu.boardboard.dto.noticeBoard.NoticeBoardCommentDTO;
import kr.ac.gwnu.boardboard.dto.noticeBoard.NoticeBoardPostDTO;
import kr.ac.gwnu.boardboard.entity.noticeBoard.NoticeBoardComment;
import kr.ac.gwnu.boardboard.entity.noticeBoard.NoticeBoardPost;
import kr.ac.gwnu.boardboard.service.NoticeBoardService;

@RestController
@RequestMapping("/api/noticeboard")
public class NoticeBoardController {
    private final NoticeBoardService noticeBoardService;

    @Autowired
    public NoticeBoardController(NoticeBoardService noticeBoardService) {
        this.noticeBoardService = noticeBoardService;
    }

    @PostMapping("/post")
    public ResponseEntity<NoticeBoardPost> createNoticeBoardPost(@RequestBody NoticeBoardPostDTO postDTO) {
        return noticeBoardService.saveNoticeBoardPost(postDTO)
                .map(post -> ResponseEntity.ok().body(post))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping("/comment")
    public ResponseEntity<NoticeBoardComment> createNoticeBoardComment(@RequestBody NoticeBoardCommentDTO commentDTO) {
        return noticeBoardService.saveNoticeBoardComment(commentDTO)
                .map(comment -> ResponseEntity.ok().body(comment))
                .orElse(ResponseEntity.badRequest().build());
    }

    // 다른 컨트롤러 메서드들을 필요에 따라 추가
}