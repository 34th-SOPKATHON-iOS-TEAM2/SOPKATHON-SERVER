package org.sopt.server.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.server.common.dto.ResponseDto;
import org.sopt.server.dto.response.QuestionGetResponse;
import org.sopt.server.service.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")

public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/questions/{questionId}")
    public ResponseDto<QuestionGetResponse> getQuestion(
            @PathVariable Long questionId) {
        return ResponseDto.success(questionService.getQuestion(questionId));
    }

}
