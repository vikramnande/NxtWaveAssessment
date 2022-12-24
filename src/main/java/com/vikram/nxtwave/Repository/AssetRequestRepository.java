package com.vikram.nxtwave.Repository;

import com.vikram.nxtwave.Entity.AssetRequest;
import com.vikram.nxtwave.Entity.User;
import com.vikram.nxtwave.RequestBody.AssetGetParams;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssetRequestRepository{

    void saveAssetRequest(AssetRequest assetRequest);

    List<AssetRequest> getAssetRequests(AssetGetParams assetReq);

}
