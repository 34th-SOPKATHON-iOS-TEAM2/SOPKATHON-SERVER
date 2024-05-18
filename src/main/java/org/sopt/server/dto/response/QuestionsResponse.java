package org.sopt.server.dto.response;

import java.util.List;
import org.sopt.server.domain.Question;

public record QuestionsResponse(
        Long questionId,
        String question
) {

    public static List<QuestionsResponse> listOf(List<Question> questions) {
        return questions.stream().map(q -> QuestionsResponse.from(q)).toList();
    }

    private static QuestionsResponse from(final Question question) {
        return new QuestionsResponse(question.getId(), question.getQuestion());
    }
}
