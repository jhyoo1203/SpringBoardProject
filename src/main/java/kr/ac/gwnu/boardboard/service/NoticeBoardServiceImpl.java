package kr.ac.gwnu.boardboard.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.gwnu.boardboard.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    private final UserService userService;
    private final HttpServletRequest request;

    // 의존성 주입
    @Autowired
    public NoticeBoardServiceImpl(
            NoticeBoardPostRepository postRepository,
            NoticeBoardCommentRepository commentRepository,
            UserService userService,
            HttpServletRequest request) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.request = request;
    }

    @Override
    public Optional<NoticeBoardPost> saveNoticeBoardPost(NoticeBoardPostDTO postDTO) {
        NoticeBoardPost post = new NoticeBoardPost();
        // NoticeBoardPostDTO에서 NoticeBoardPost 엔티티로 변환 후 저장하는 로직 추가
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());

        // 현재 시간을 Timestamp로 생성
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        post.setTimestamp(timestamp);

        // 세션에서 현재 로그인한 사용자 정보 가져오기
        User user = getCurrentUserFromSession();
        post.setUser(user);

        return Optional.ofNullable(postRepository.save(post));
    }

    private User getCurrentUserFromSession() {
        HttpSession session = request.getSession(false);
        // 세션에 사용자 정보가 없으면 예외 처리 또는 기본값 반환
        if (session != null) {
            String nickname = (String) session.getAttribute("user");
            if (nickname != null) {
                return userService.getUserByNickname(nickname);
            }
        }
        return null;
    }

    @Override
    public Optional<NoticeBoardComment> saveNoticeBoardComment(NoticeBoardCommentDTO commentDTO) {
        NoticeBoardComment comment = new NoticeBoardComment();
        // NoticeBoardCommentDTO에서 NoticeBoardComment 엔티티로 변환 후 저장하는 로직 추가
        comment.setContent(commentDTO.getContent());

        return Optional.ofNullable(commentRepository.save(comment));
    }

    @Override
    public Optional<List<NoticeBoardPost>> getLatestNoticeBoardPosts(int count) {
        // 최신 글을 count 개수만큼 가져오는 로직
        Sort sort = Sort.by(Sort.Direction.DESC, "timestamp");
        Pageable pageable = PageRequest.of(0, count, sort);

        List<NoticeBoardPost> latestPosts = postRepository.findAll(pageable).getContent();

        return Optional.ofNullable(latestPosts.isEmpty() ? null : latestPosts);
    }
}