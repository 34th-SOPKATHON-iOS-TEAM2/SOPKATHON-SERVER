package org.sopt.server.service;

import lombok.RequiredArgsConstructor;
import org.sopt.server.domain.Member;
import org.sopt.server.dto.request.MemberCreateRequest;
import org.sopt.server.dto.response.MemberCreateResponse;
import org.sopt.server.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberCreateResponse saveMember(final MemberCreateRequest memberCreateRequest) {
        return MemberCreateResponse.of(memberRepository.save(Member.from(memberCreateRequest)));
    }
}