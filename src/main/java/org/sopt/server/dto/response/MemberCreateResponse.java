package org.sopt.server.dto.response;

import org.sopt.server.domain.Member;

public record MemberCreateResponse(
        Boolean success,
        Long id,
        String name
) {

    public static MemberCreateResponse of(Boolean success, final Member member) {
        return new MemberCreateResponse(success, member.getId(), member.getName());
    }
}
