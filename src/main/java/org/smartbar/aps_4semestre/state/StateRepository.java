package org.smartbar.aps_4semestre.state;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StateRepository extends MongoRepository <State, ObjectId>  {}
