package com.vikram.nxtwave.Repository;

import com.vikram.nxtwave.Entity.TravelInfo;
import com.vikram.nxtwave.Enum.MatchStatus;
import com.vikram.nxtwave.RequestBody.MatchedRidesReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Component
public class TravelInfoDao implements TravelInfoRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(TravelInfo travelInfo) {
        mongoTemplate.save(travelInfo);
    }

    public List<TravelInfo> getMatchedRides(MatchedRidesReq matchedRidesReq) {
        LocalDate date1 = LocalDate.parse(matchedRidesReq.getDate());
        LocalDate date2 = date1.plusDays(1L);

        LocalDateTime dateTime1 = LocalDateTime.of(date1, LocalTime.MIDNIGHT);
        LocalDateTime dateTime2 = LocalDateTime.of(date2, LocalTime.MIDNIGHT);

        Query query = new Query();
        query.addCriteria(Criteria.where(TravelInfo.CONSTANTS.FROM).is(matchedRidesReq.getFrom()));
        query.addCriteria(Criteria.where(TravelInfo.CONSTANTS.TO).is(matchedRidesReq.getTo()));
        query.addCriteria(Criteria.where(TravelInfo.CONSTANTS.DATE_TIME).gte(dateTime1).lt(dateTime2));

        if(Objects.nonNull(matchedRidesReq.getSkip())) {
            query.skip(matchedRidesReq.getSkip());
        }

        if(Objects.nonNull(matchedRidesReq.getLimit())) {
            query.limit(matchedRidesReq.getLimit());
        }

        return mongoTemplate.find(query, TravelInfo.class);
    }

    public void applyForRide(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where(TravelInfo.CONSTANTS.ID).is(id));

        Update update = new Update();
        update.set(TravelInfo.CONSTANTS.MATCH_STATUS, MatchStatus.APPLIED);

        mongoTemplate.updateFirst(query, update, TravelInfo.class);
    }
}
