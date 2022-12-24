package com.vikram.nxtwave.RequestBody;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchedRidesReq {
    private String from;
    private String to;
    private String date;
    private int skip;
    private int limit;
}
