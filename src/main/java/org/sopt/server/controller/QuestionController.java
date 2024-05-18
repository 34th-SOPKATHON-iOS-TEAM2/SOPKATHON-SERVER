package org.sopt.server.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.server.common.dto.ResponseDto;
import org.sopt.server.dto.response.QuestionGetResponse;
import org.sopt.server.dto.response.QuestionsResponse;
import org.sopt.server.dto.response.SolutionResponse;
import org.sopt.server.service.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/questions")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/{questionId}")
    public ResponseDto<QuestionGetResponse> getQuestion(
            @PathVariable Long questionId) {
        return ResponseDto.success(questionService.getQuestion(questionId));
    }

    @GetMapping
    public ResponseDto<List<QuestionsResponse>> getQuestionList() {
        return ResponseDto.success(questionService.getQuestionList());
    }

    @GetMapping("/{questionId}/solution")
    public ResponseDto<SolutionResponse> getSolution(
            @RequestHeader(name = "memberId") Long memberId,
            @PathVariable Long questionId) {
        return ResponseDto.success(questionService.getSolution(memberId, questionId));
    }
}
