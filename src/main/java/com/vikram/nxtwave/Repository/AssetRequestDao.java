package com.vikram.nxtwave.Repository;

import com.vikram.nxtwave.Entity.AssetRequest;
import com.vikram.nxtwave.RequestBody.AssetGetParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class AssetRequestDao implements AssetRequestRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveAssetRequest(AssetRequest assetRequest) {
        mongoTemplate.save(assetRequest);
    }

    @Override
    public List<AssetRequest> getAssetRequests(AssetGetParams assetReq) {
        Query query = new Query();
        query.addCriteria(Criteria.where(AssetRequest.CONSTANTS.REQUESTED_BY).is(assetReq.getRequestedBy()));

        if(Objects.nonNull(assetReq.getAssetStatus())) {
            query.addCriteria(Criteria.where(AssetRequest.CONSTANTS.ASSET_STATUS).is(assetReq.getAssetStatus()));
        }

        if(Objects.nonNull(assetReq.getAssetType())) {
            query.addCriteria(Criteria.where(AssetRequest.CONSTANTS.ASSET_TYPE).is(assetReq.getAssetType()));
        }

        query.with(Sort.by(Sort.Direction.DESC, AssetRequest.CONSTANTS.DATE_TIME));

        if(Objects.nonNull(assetReq.getSkip())) {
            query.skip(assetReq.getSkip());
        }

        if(Objects.nonNull(assetReq.getLimit())) {
            query.limit(assetReq.getLimit());
        }

        return mongoTemplate.find(query, AssetRequest.class);
    }
}
