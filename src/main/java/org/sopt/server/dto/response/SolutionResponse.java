package org.sopt.server.dto.response;

import org.sopt.server.domain.Attempt;
import org.sopt.server.domain.Question;
import org.sopt.server.domain.QuestionOption;
import org.sopt.server.exception.NotFoundException;
import org.sopt.server.exception.dto.ErrorCode;

import java.util.Optional;

public record SolutionResponse(
        String question,
        String answer,
        String solution
) {

    public static SolutionResponse from(final Attempt attempt) {

        Question question = attempt.getQuestion();

        Optional<QuestionOption> correctOption = question.getQuestionOptions().stream()
                .filter(QuestionOption::isAnswer)
                .findFirst();

        String solution = correctOption.map(QuestionOption::getContent).
                orElseThrow(() -> new NotFoundException(ErrorCode.CORRECT_OPTION_NOT_FOUND));

        return new SolutionResponse(
                question.getQuestion(),
                solution,
                question.getSolution()
        );
    }
}
