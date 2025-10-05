package org.smartbar.aps_4semestre.state;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StateRepositoryExtension {

    private final MongoTemplate mongoTemplate;

    public StateRepositoryExtension (MongoTemplate mongoTemplate) {

        this.mongoTemplate = mongoTemplate;

    }

    public Page <State> findStateDataAccordingToYear (int year, Pageable pageable) {

        String collectionName = "amazonia_" + year;

        Query query = new Query().with(pageable);
        List <State> results = mongoTemplate.find(query, State.class, collectionName);

        long total = mongoTemplate.count(query.skip(-1).limit(-1), State.class, collectionName);

        return new PageImpl<>(results, pageable, total);

    }

}
