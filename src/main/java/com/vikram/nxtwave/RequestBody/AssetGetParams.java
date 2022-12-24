package com.vikram.nxtwave.RequestBody;

import com.vikram.nxtwave.Enum.AssetStatus;
import com.vikram.nxtwave.Enum.AssetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetGetParams {
    private String requestedBy;
    private AssetStatus assetStatus;
    private AssetType assetType;
    private int skip;
    private int limit;
}
