package org.sopt.server.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "member_question")
@Entity
public class MemberQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_correct", nullable = false)
    private boolean isCorrect;

    @Column(name = "attempted_date", nullable = false)
    private LocalDate attemptedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    public static MemberQuestion of(final boolean isCorrect, final Member member, final Question question) {
        return MemberQuestion.builder()
                .isCorrect(isCorrect)
                .attemptedDate(question.getDate())
                .member(member)
                .question(question)
                .build();
    }

    @Builder
    private MemberQuestion(final boolean isCorrect, final LocalDate attemptedDate, final Member member, final Question question) {
        this.isCorrect = isCorrect;
        this.attemptedDate = attemptedDate;
        this.member = member;
        this.question = question;
    }
}
