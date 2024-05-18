package org.sopt.server.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.sopt.server.common.dto.ResponseDto;
import org.sopt.server.dto.request.MemberCreateRequest;
import org.sopt.server.dto.response.MemberCreateResponse;
import org.sopt.server.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseDto<MemberCreateResponse> postMember(@RequestBody @Valid final MemberCreateRequest memberCreateRequest) {
        return ResponseDto.success(memberService.saveMember(memberCreateRequest));
    }
}
