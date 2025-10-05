package org.smartbar.aps_4semestre.state;

import org.bson.types.ObjectId;
import org.smartbar.aps_4semestre.state.coordinate.Coordinate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class State extends Coordinate {

    @Id
    private ObjectId _id;

    public String pais;

    public String estado;

    public String municipio;

    public String bioma;

}
