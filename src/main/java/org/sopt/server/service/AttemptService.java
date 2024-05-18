package org.sopt.server.service;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.server.dto.response.AttemptsResponse;
import org.sopt.server.repository.AttemptRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AttemptService {

    private final AttemptRepository attemptRepository;

    @Transactional(readOnly = true)
    public List<AttemptsResponse> getAttemptsByDate(final Long memberId, final LocalDate date) {
        return AttemptsResponse.listOf(attemptRepository.getAttemptsByMemberIdAndDate(memberId, date));
    }
}
