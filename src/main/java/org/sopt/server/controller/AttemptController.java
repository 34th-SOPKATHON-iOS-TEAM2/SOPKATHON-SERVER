package org.sopt.server.controller;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.server.common.dto.ResponseDto;
import org.sopt.server.dto.request.AttemptRequest;
import org.sopt.server.dto.response.AttemptsResponse;
import org.sopt.server.service.AttemptService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attempts")
public class AttemptController {

    private final AttemptService attemptService;

    //문제풀이
    @PostMapping
    public ResponseDto<Void> attemptQuestion(
            @RequestHeader(name = "memberId") Long memberId,
            @RequestBody @Valid final AttemptRequest attemptRequest) {
        attemptService.attemptQuestion(memberId, attemptRequest);
        return ResponseDto.success(null);
    }

    @GetMapping
    public ResponseDto<List<AttemptsResponse>> getAttemptsByDate(
            @RequestHeader(name = "memberId") final Long memberId,
            @RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate date
    ) {
        return ResponseDto.success(attemptService.getAttemptsByDate(memberId, date));
    }
}
