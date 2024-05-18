package org.sopt.server.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.server.common.dto.ResponseDto;
import org.sopt.server.dto.response.QuestionsResponse;
import org.sopt.server.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/questions")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public ResponseDto<List<QuestionsResponse>> getQuestionList() {
        return ResponseDto.success(questionService.getQuestionList());
    }
}
