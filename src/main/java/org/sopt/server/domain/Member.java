package org.sopt.server.domain;

import dto.MemberCreateDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.DynamicInsert;

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
    private List<MemberQuestion> memberQuestions;

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
