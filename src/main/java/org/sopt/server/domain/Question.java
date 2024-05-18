package org.sopt.server.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import org.sopt.server.domain.type.QuestionType;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "questions")
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private LocalDate date;

    @Enumerated(EnumType.ORDINAL)
    private QuestionType questionType;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Attempt> attempts;
}
