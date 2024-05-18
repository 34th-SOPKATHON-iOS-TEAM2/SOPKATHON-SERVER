package org.sopt.server.dto.response;

import org.sopt.server.domain.Member;

public record MemberCreateResponse(
        Long id,
        String name
) {

    public static MemberCreateResponse of(final Member member) {
        return new MemberCreateResponse(member.getId(), member.getName());
    }
}
