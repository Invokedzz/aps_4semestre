package org.smartbar.aps_4semestre.state;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StateRepository extends MongoRepository <State, UUID> {}
