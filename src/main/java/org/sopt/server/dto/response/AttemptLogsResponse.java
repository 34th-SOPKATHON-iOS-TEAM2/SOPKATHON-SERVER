package org.sopt.server.dto.response;

import java.time.LocalDate;
import java.util.List;

public record AttemptLogsResponse(
        LocalDate date,
        Boolean pass
) {

    public static AttemptLogsResponse from(final LocalDate date, final Boolean pass) {
        return new AttemptLogsResponse(date, pass);
    }
}
