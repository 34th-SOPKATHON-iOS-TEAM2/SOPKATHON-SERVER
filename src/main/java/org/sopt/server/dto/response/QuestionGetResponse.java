package org.sopt.server.dto.response;

import org.sopt.server.domain.Question;
import org.sopt.server.domain.type.QuestionType;

import java.util.List;

public record QuestionGetResponse(

        QuestionType type,
        String question,
        List<OptionGetResponse> options,
        Long nextQuestionId

) {
    public static QuestionGetResponse of(Question question, Long nextQuestionId) {
        return new QuestionGetResponse(
                question.getQuestionType(),
                question.getQuestion(),
                OptionGetResponse.listOf(question.getQuestionOptions()),
                nextQuestionId
        );
    }
}
