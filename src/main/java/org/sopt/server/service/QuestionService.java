package org.sopt.server.service;

import lombok.RequiredArgsConstructor;
import org.sopt.server.common.dto.ResponseDto;
import org.sopt.server.domain.Attempt;
import org.sopt.server.domain.Member;
import org.sopt.server.domain.Question;
import org.sopt.server.dto.response.QuestionGetResponse;
import org.sopt.server.dto.response.SolutionResponse;
import org.sopt.server.exception.NotFoundException;
import org.sopt.server.exception.dto.ErrorCode;
import org.sopt.server.repository.AttemptRepository;
import org.sopt.server.repository.MemberRepository;
import org.sopt.server.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;
import org.sopt.server.dto.response.QuestionsResponse;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final MemberRepository memberRepository;
    private final AttemptRepository attemptRepository;

    public QuestionGetResponse getQuestion(Long questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.QUESTION_NOT_FOUND));

        LocalDate questionDate = question.getDate();
        List<Question> questionsOnDate = questionRepository.findAllByDateOrderByIdAsc(questionDate);
        int totalQuestionsOnDate = questionsOnDate.size();
        int currentIndex = questionsOnDate.indexOf(question);
        int nextIndex = currentIndex + 1;
        if (nextIndex == totalQuestionsOnDate) {
            return QuestionGetResponse.of(question, Long.valueOf("0"));
        }
        Long nextQuestionId = questionsOnDate.get(nextIndex).getId();

        return QuestionGetResponse.of(question, nextQuestionId);
    }

    public List<QuestionsResponse> getQuestionList() {
        return QuestionsResponse.listOf(questionRepository.findFirstQuestionsEachDay());
    }

    public SolutionResponse getSolution(Long memberId, Long questionId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.MEMBER_NOT_FOUND));

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.QUESTION_NOT_FOUND));

        Attempt attempt = attemptRepository.findByMemberAndQuestion(member, question)
                .orElseThrow(() -> new NotFoundException(ErrorCode.ATTEMPT_NOT_FOUND));

        return SolutionResponse.from(attempt);
    }
}
