package com.vikram.nxtwave.Repository;

import com.vikram.nxtwave.Entity.AssetRequest;
import com.vikram.nxtwave.Entity.TravelInfo;
import com.vikram.nxtwave.RequestBody.AssetGetParams;
import com.vikram.nxtwave.RequestBody.AssetReq;

import java.util.List;

public interface TravelInfoRepository {
    void save(TravelInfo travelInfo);
}
