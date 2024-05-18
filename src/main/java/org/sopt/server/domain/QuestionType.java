package org.sopt.server.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum QuestionType {

    MULTIPLE_CHOICE,
    EITHER_OR,
    ;
}
