package com.vikram.nxtwave.Entity;

import com.vikram.nxtwave.Enum.AssetStatus;
import com.vikram.nxtwave.Enum.AssetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "AssetRequest")
public class AssetRequest {
    @Id
    private String id;
    private String requestedBy;
    private String from;
    private String to;
    private LocalDateTime dateTime;
    private int assetCount;
    private AssetType assetType;
    private String deliverTo;
    private AssetStatus assetStatus;

    public static class CONSTANTS {
        public static final String ID = "id";
        public static final String REQUESTED_BY = "requestedBy";
        public static final String FROM = "from";
        public static final String TO = "to";
        public static final String DATE_TIME = "dateTime";
        public static final String ASSET_COUNT = "assetCount";
        public static final String ASSET_TYPE = "assetType";
        public static final String DELIVER_TO = "deliverTo";
        public static final String ASSET_STATUS= "assetStatus";
    }
}
