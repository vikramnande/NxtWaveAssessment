package com.vikram.nxtwave.Entity;

import com.vikram.nxtwave.Enum.MatchStatus;
import com.vikram.nxtwave.Enum.TravelMedium;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "TravelInfo")
public class TravelInfo {

    @Id
    private String id;
    private String userId;
    private String from;
    private String to;
    private LocalDateTime dateTime;
    private TravelMedium travelMedium;
    private int assetCount;
    private MatchStatus matchStatus;

    public static class CONSTANTS {
        public static final String ID = "id";
        public static final String USER_ID = "userId";
        public static final String FROM = "from";
        public static final String TO = "to";
        public static final String DATE_TIME = "dateTime";
        public static final String TRAVEL_MEDIUM = "travelMedium";
        public static final String ASSET_COUNT = "assetCount";
        public static final String MATCH_STATUS = "matchStatus";
    }
}
