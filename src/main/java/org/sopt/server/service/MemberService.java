package org.sopt.server.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.sopt.server.domain.Member;
import org.sopt.server.dto.request.MemberCreateRequest;
import org.sopt.server.dto.response.MemberCreateResponse;
import org.sopt.server.exception.CommonException;
import org.sopt.server.exception.dto.ErrorCode;
import org.sopt.server.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberCreateResponse saveMember(final MemberCreateRequest memberCreateRequest) {
        Optional<Member> opMember = memberRepository.findByName(memberCreateRequest.name());
        if (opMember.isPresent()) {
            return MemberCreateResponse.of(false, memberRepository.save(Member.from(memberCreateRequest)));
        }
        return MemberCreateResponse.of(true, memberRepository.save(Member.from(memberCreateRequest)));
    }
}
