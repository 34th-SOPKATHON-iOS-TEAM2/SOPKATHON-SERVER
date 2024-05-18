package org.sopt.server.repository;

import java.time.LocalDate;
import java.util.List;
import org.sopt.server.domain.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Long> {

    @Query("SELECT a FROM Attempt a WHERE a.member.id = :memberId AND a.attemptedDate = :date")
    List<Attempt> getAttemptsByMemberIdAndDate(final Long memberId, final LocalDate date);
}
