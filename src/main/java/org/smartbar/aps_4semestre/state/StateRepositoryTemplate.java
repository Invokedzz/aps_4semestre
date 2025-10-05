package org.smartbar.aps_4semestre.state;

import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StateRepositoryTemplate {

    private final MongoTemplate mongoTemplate;

    public StateRepositoryTemplate (MongoTemplate mongoTemplate) {

        this.mongoTemplate = mongoTemplate;

    }

    public Page <State> findStateDataAccordingToYear (int year, Pageable pageable) {

        String collectionName = "amazonia_" + year;

        Query query = new Query().with(pageable);
        List <State> results = mongoTemplate.find(query, State.class, collectionName);

        return new PageImpl<>(results);

    }

}
