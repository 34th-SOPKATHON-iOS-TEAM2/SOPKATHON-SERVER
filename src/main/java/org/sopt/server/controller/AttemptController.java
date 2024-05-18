package org.sopt.server.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.server.common.dto.ResponseDto;
import org.sopt.server.dto.request.AttemptRequest;
import org.sopt.server.service.AttemptService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attempts")
public class AttemptController {

    private final AttemptService attemptService;

    //문제풀이
    @PostMapping
    public ResponseDto<Void> attemptQuestion(
            @RequestHeader Long memberId,
            @RequestBody @Valid final AttemptRequest attemptRequest) {
        attemptService.attemptQuestion(memberId, attemptRequest);
        return ResponseDto.success(null);
    }
}
