package com.vikram.nxtwave.RequestBody;

import com.vikram.nxtwave.Enum.AssetStatus;
import com.vikram.nxtwave.Enum.AssetType;
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
public class AssetReq {
    private String requestedBy;
    private String from;
    private String to;
    private LocalDateTime dateTime;
    private int assetCount;
    private AssetType assetType;
    private String deliverTo;
    private AssetStatus assetStatus;
}
