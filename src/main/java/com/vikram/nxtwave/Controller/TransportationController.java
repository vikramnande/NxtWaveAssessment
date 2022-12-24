package com.vikram.nxtwave.Controller;

import com.vikram.nxtwave.Entity.AssetRequest;
import com.vikram.nxtwave.Entity.TravelInfo;
import com.vikram.nxtwave.Manager.TransportationManager;
import com.vikram.nxtwave.RequestBody.AssetGetParams;
import com.vikram.nxtwave.RequestBody.AssetReq;
import com.vikram.nxtwave.RequestBody.MatchedRidesReq;
import com.vikram.nxtwave.RequestBody.TravelInfoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/transportation")
public class TransportationController {

    @Autowired
    private TransportationManager transportationManager;

    @PostMapping("/asset-request")
    @ResponseBody
    public Boolean assetRequest(@RequestBody AssetReq assetReq) {
        return transportationManager.saveAssetRequest(assetReq);
    }

    @PostMapping("/travel-info")
    @ResponseBody
    public Boolean travelInfo(@RequestBody TravelInfoReq travelInfoReq) {
        return transportationManager.saveTravelInfo(travelInfoReq);
    }

    @GetMapping("/asset-request")
    @ResponseBody
    public List<AssetRequest> assetRequests(@ModelAttribute AssetGetParams assetReq) {
        return transportationManager.getAssetRequests(assetReq);
    }

    @GetMapping("/matched-rides")
    @ResponseBody
    public List<TravelInfo> matchedRides(@ModelAttribute MatchedRidesReq matchedRidesReq) {
        return transportationManager.getMatchedRides(matchedRidesReq);
    }

    @PutMapping("/apply-for-ride")
    @ResponseBody
    public Boolean applyForRide(@RequestParam(value = "travelInfoId") String id) {
        return transportationManager.applyForRide(id);
    }

}
