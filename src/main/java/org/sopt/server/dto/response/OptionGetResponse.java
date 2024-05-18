package org.sopt.server.dto.response;

import org.sopt.server.domain.QuestionOption;

import java.util.List;

public record OptionGetResponse(

        String option,
        Boolean isAnswer
) {
    public static List<OptionGetResponse> listOf(List<QuestionOption> options) {
        return options
                .stream()
                .map(option -> new OptionGetResponse(
                        option.getContent(),
                        option.isAnswer()
                )).toList();
    }
}
