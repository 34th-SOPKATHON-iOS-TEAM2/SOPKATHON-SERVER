package org.sopt.server.service;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.server.domain.Attempt;
import org.sopt.server.domain.Member;
import org.sopt.server.domain.Question;
import org.sopt.server.dto.request.AttemptRequest;
import org.sopt.server.dto.response.AttemptsResponse;
import org.sopt.server.exception.NotFoundException;
import org.sopt.server.exception.dto.ErrorCode;
import org.sopt.server.repository.AttemptRepository;
import org.sopt.server.repository.MemberRepository;
import org.sopt.server.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AttemptService {

    private final MemberRepository memberRepository;
    private final QuestionRepository questionRepository;
    private final AttemptRepository attemptRepository;

    public void attemptQuestion(Long memberId, AttemptRequest attemptRequest) {
        Member member = memberRepository.findById(memberId).
                orElseThrow(() -> new NotFoundException(ErrorCode.MEMBER_NOT_FOUND));

        Question question = questionRepository.findById(attemptRequest.questionId())
                .orElseThrow(() -> new NotFoundException(ErrorCode.QUESTION_NOT_FOUND));

        attemptRepository.save(Attempt.of(attemptRequest.isCorrect(), member, question));
    }

    @Transactional(readOnly = true)
    public List<AttemptsResponse> getAttemptsByDate(final Long memberId, final LocalDate date) {
        memberRepository.findByIdOrElseThrow(memberId);
        return AttemptsResponse.listOf(attemptRepository.getAttemptsByMemberIdAndDate(memberId, date));
    }
}
