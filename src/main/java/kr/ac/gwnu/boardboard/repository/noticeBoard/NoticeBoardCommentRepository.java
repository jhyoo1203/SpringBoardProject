package kr.ac.gwnu.boardboard.repository.noticeBoard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.gwnu.boardboard.entity.noticeBoard.NoticeBoardComment;

@Repository
public interface NoticeBoardCommentRepository extends JpaRepository<NoticeBoardComment, Long> {
    
}