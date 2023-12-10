package kr.ac.gwnu.boardboard.service;

import java.util.List;
import java.util.Optional;

import kr.ac.gwnu.boardboard.dto.noticeBoard.NoticeBoardCommentDTO;
import kr.ac.gwnu.boardboard.dto.noticeBoard.NoticeBoardPostDTO;
import kr.ac.gwnu.boardboard.entity.noticeBoard.NoticeBoardComment;
import kr.ac.gwnu.boardboard.entity.noticeBoard.NoticeBoardPost;



public interface NoticeBoardService {
    Optional<NoticeBoardPost> saveNoticeBoardPost(NoticeBoardPostDTO postDTO);
    Optional<NoticeBoardComment> saveNoticeBoardComment(NoticeBoardCommentDTO commentDTO);
    Optional<List<NoticeBoardPost>> getLatestNoticeBoardPosts(int count);
}
