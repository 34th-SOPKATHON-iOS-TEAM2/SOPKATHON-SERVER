package org.sopt.server.repository;

import org.sopt.server.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    int countByDate(LocalDate questionDate);
    List<Question> findAllByDateOrderByIdAsc(LocalDate date);
}
