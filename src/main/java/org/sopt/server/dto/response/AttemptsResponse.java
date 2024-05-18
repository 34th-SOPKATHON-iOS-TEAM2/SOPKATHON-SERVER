package org.sopt.server.dto.response;

import java.util.List;
import org.sopt.server.domain.Attempt;

public record AttemptsResponse(
        Long questionId,
        String question,
        Boolean isCorrect
) {

    public static List<AttemptsResponse> listOf(final List<Attempt> attempts) {
        return attempts.stream()
                .map(AttemptsResponse::from)
                .toList();
    }

    private static AttemptsResponse from(final Attempt attempt) {
        return new AttemptsResponse(
                attempt.getQuestion().getId(),
                attempt.getQuestion().getQuestion(),
                attempt.isCorrect()
        );
    }
}
