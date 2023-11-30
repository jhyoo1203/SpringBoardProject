package kr.ac.gwnu.boardboard.repository.freeBoard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.gwnu.boardboard.entity.freeBoard.FreeBoardComment;

@Repository
public interface FreeBoardCommentRepository extends JpaRepository<FreeBoardComment, Long> {
    
}