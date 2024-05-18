package org.sopt.server.repository;

import java.util.List;
import org.sopt.server.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("SELECT q FROM Question q WHERE q.id IN (" +
            "SELECT MIN(q2.id) FROM Question q2 GROUP BY FUNCTION('DATE', q2.date))")
    List<Question> findFirstQuestionsEachDay();
}
