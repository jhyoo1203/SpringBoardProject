package kr.ac.gwnu.boardboard.service;

import java.util.List;
import java.util.Optional;

import kr.ac.gwnu.boardboard.dto.freeBoard.FreeBoardCommentDTO;
import kr.ac.gwnu.boardboard.dto.freeBoard.FreeBoardPostDTO;
import kr.ac.gwnu.boardboard.entity.freeBoard.FreeBoardComment;
import kr.ac.gwnu.boardboard.entity.freeBoard.FreeBoardPost;

public interface FreeBoardService {
    Optional<FreeBoardPost> saveFreeBoardPost(FreeBoardPostDTO postDTO);
    Optional<FreeBoardComment> saveFreeBoardComment(FreeBoardCommentDTO commentDTO);
    Optional<List<FreeBoardPost>> getLatestFreeBoardPosts(int count);
    Optional<FreeBoardPost> getFreeBoardPostById(Long postId);

}
