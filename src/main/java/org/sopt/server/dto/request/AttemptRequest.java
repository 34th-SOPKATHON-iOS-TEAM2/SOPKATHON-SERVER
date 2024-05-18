package org.sopt.server.dto.request;

import jakarta.validation.constraints.NotNull;

public record AttemptRequest(

        @NotNull(message = "questionId는 필수 사항입니다.")
        Long questionId,
        @NotNull(message = "정답 여부는 필수 사항입니다.")
        Boolean isCorrect
) {
}
