package kr.ac.gwnu.boardboard.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.gwnu.boardboard.dto.noticeBoard.NoticeBoardCommentDTO;
import kr.ac.gwnu.boardboard.dto.noticeBoard.NoticeBoardPostDTO;
import kr.ac.gwnu.boardboard.entity.noticeBoard.NoticeBoardComment;
import kr.ac.gwnu.boardboard.entity.noticeBoard.NoticeBoardPost;
import kr.ac.gwnu.boardboard.repository.noticeBoard.NoticeBoardCommentRepository;
import kr.ac.gwnu.boardboard.repository.noticeBoard.NoticeBoardPostRepository;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {
    private final NoticeBoardPostRepository postRepository;
    private final NoticeBoardCommentRepository commentRepository;

    @Autowired
    public NoticeBoardServiceImpl(NoticeBoardPostRepository postRepository, NoticeBoardCommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Optional<NoticeBoardPost> saveNoticeBoardPost(NoticeBoardPostDTO postDTO) {
        NoticeBoardPost post = new NoticeBoardPost();
        // NoticeBoardPostDTO에서 NoticeBoardPost 엔티티로 변환 후 저장하는 로직 추가
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());

        return Optional.ofNullable(postRepository.save(post));
    }

    @Override
    public Optional<NoticeBoardComment> saveNoticeBoardComment(NoticeBoardCommentDTO commentDTO) {
        NoticeBoardComment comment = new NoticeBoardComment();
        // NoticeBoardCommentDTO에서 NoticeBoardComment 엔티티로 변환 후 저장하는 로직 추가
        comment.setContent(commentDTO.getContent());

        return Optional.ofNullable(commentRepository.save(comment));
    }
}