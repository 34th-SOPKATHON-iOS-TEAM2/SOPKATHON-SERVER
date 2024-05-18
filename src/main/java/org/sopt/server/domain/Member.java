package org.sopt.server.domain;

import org.sopt.server.dto.MemberCreateDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "members")
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "correct_count", nullable = false)
    private Integer correctCount;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Attempt> attempts;

    public Integer increaseCorrectCount() {
        this.correctCount += 1;
        return this.correctCount;
    }

    public void resetCorrectCount() {
        this.correctCount = 0;
    }

    public static Member from(final MemberCreateDto memberCreateDto) {
        return Member.builder()
                .name(memberCreateDto.name())
                .build();
    }

    @Builder
    private Member(final String name) {
        this.name = name;
        this.correctCount = 0;
    }
}
