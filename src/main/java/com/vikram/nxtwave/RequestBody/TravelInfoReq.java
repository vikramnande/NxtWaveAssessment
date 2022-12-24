package com.vikram.nxtwave.RequestBody;

import com.vikram.nxtwave.Enum.TravelMedium;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelInfoReq {
    private String userId;
    private String from;
    private String to;
    private LocalDateTime dateTime;
    private TravelMedium travelMedium;
    private int assetCount;
}
