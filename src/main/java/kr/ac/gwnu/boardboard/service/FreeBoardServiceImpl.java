package kr.ac.gwnu.boardboard.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.gwnu.boardboard.dto.freeBoard.FreeBoardCommentDTO;
import kr.ac.gwnu.boardboard.dto.freeBoard.FreeBoardPostDTO;
import kr.ac.gwnu.boardboard.entity.freeBoard.FreeBoardComment;
import kr.ac.gwnu.boardboard.entity.freeBoard.FreeBoardPost;
import kr.ac.gwnu.boardboard.repository.freeBoard.FreeBoardCommentRepository;
import kr.ac.gwnu.boardboard.repository.freeBoard.FreeBoardPostRepository;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {
    private final FreeBoardPostRepository postRepository;
    private final FreeBoardCommentRepository commentRepository;

    @Autowired
    public FreeBoardServiceImpl(FreeBoardPostRepository postRepository, FreeBoardCommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Optional<FreeBoardPost> saveFreeBoardPost(FreeBoardPostDTO postDTO) {
        FreeBoardPost post = new FreeBoardPost();
        // FreeBoardPostDTO에서 FreeBoardPost 엔티티로 변환 후 저장하는 로직 추가
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());

        return Optional.ofNullable(postRepository.save(post));
    }

    @Override
    public Optional<FreeBoardComment> saveFreeBoardComment(FreeBoardCommentDTO commentDTO) {
        FreeBoardComment comment = new FreeBoardComment();
        // FreeBoardCommentDTO에서 FreeBoardComment 엔티티로 변환 후 저장하는 로직 추가
        comment.setContent(commentDTO.getContent());

        return Optional.ofNullable(commentRepository.save(comment));
    }

}