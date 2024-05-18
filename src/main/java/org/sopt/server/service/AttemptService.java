package org.sopt.server.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.server.domain.Attempt;
import org.sopt.server.domain.Member;
import org.sopt.server.domain.Question;
import org.sopt.server.dto.request.AttemptRequest;
import org.sopt.server.dto.response.AttemptLogsResponse;
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
        return AttemptsResponse.listOf(attemptRepository.findAttemptsByMemberIdAndDate(memberId, date));
    }

    @Transactional(readOnly = true)
    public List<AttemptLogsResponse> getAttemptsByMonth(final Long memberId) {
        LocalDate currentDate = LocalDate.now();
        memberRepository.findByIdOrElseThrow(memberId);

        List<Attempt> attemptsByMember = attemptRepository.findAttemptsByMemberId(memberId);
        List<Attempt> attemptsInSameMonth = new ArrayList<>();
        for (Attempt attempt : attemptsByMember) {
            if (attempt.getAttemptedDate().getMonth().equals(currentDate.getMonth())) {
                attemptsInSameMonth.add(attempt);
            }
        }

        Map<LocalDate, List<Attempt>> attemptsByDate = attemptsInSameMonth.stream()
                .collect(Collectors.groupingBy(Attempt::getAttemptedDate));

        List<AttemptLogsResponse> attemptLogsResponses = attemptsByDate.entrySet().stream()
                .map(entry -> {
                    long correctCount = entry.getValue().stream()
                            .filter(Attempt::isCorrect)
                            .count();
                    long totalCount = entry.getValue().stream()
                            .count();
                    return AttemptLogsResponse.from(entry.getKey(), correctCount == totalCount);
                })
                .collect(Collectors.toList());

        return attemptLogsResponses;
    }
}
