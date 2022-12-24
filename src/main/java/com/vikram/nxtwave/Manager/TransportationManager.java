package com.vikram.nxtwave.Manager;

import com.vikram.nxtwave.Entity.AssetRequest;
import com.vikram.nxtwave.Entity.TravelInfo;
import com.vikram.nxtwave.Enum.MatchStatus;
import com.vikram.nxtwave.Repository.AssetRequestDao;
import com.vikram.nxtwave.Repository.TravelInfoDao;
import com.vikram.nxtwave.RequestBody.AssetGetParams;
import com.vikram.nxtwave.RequestBody.AssetReq;
import com.vikram.nxtwave.RequestBody.MatchedRidesReq;
import com.vikram.nxtwave.RequestBody.TravelInfoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransportationManager {

    @Autowired
    private AssetRequestDao assetRequestDao;

    @Autowired
    private TravelInfoDao travelInfoDao;

    public Boolean saveAssetRequest(AssetReq assetReq) {
        AssetRequest assetRequest = AssetRequest.builder()
                                                .requestedBy(assetReq.getRequestedBy())
                                                .from(assetReq.getFrom())
                                                .to(assetReq.getTo())
                                                .dateTime(assetReq.getDateTime())
                                                .assetCount(assetReq.getAssetCount())
                                                .assetType(assetReq.getAssetType())
                                                .deliverTo(assetReq.getDeliverTo())
                                                .build();

        assetRequestDao.saveAssetRequest(assetRequest);
        return Boolean.TRUE;
    }

    public Boolean saveTravelInfo(TravelInfoReq travelInfoReq) {
        TravelInfo travelInfo = TravelInfo.builder()
                                            .userId(travelInfoReq.getUserId())
                                            .from(travelInfoReq.getFrom())
                                            .to(travelInfoReq.getTo())
                                            .dateTime(travelInfoReq.getDateTime())
                                            .travelMedium(travelInfoReq.getTravelMedium())
                                            .assetCount(travelInfoReq.getAssetCount())
                                            .matchStatus(MatchStatus.NOT_APPLIED)
                                            .build();

        travelInfoDao.save(travelInfo);

        return Boolean.TRUE;
    }

    public List<AssetRequest> getAssetRequests(AssetGetParams assetReq) {
        return assetRequestDao.getAssetRequests(assetReq);
    }

    public List<TravelInfo> getMatchedRides(MatchedRidesReq matchedRidesReq) {
        return travelInfoDao.getMatchedRides(matchedRidesReq);
    }

    public Boolean applyForRide(String id) {
        travelInfoDao.applyForRide(id);
        return Boolean.TRUE;
    }
}
