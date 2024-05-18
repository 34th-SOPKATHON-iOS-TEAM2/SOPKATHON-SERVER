package org.sopt.server.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.sopt.server.domain.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Long> {

    @Query("SELECT a FROM Attempt a WHERE a.member.id = :memberId AND a.attemptedDate = :date")
    List<Attempt> findAttemptsByMemberIdAndDate(final Long memberId, final LocalDate date);

    @Query("SELECT a FROM Attempt a WHERE a.member.id = :memberId")
    List<Attempt> findAttemptsByMemberId(final Long memberId);
}
