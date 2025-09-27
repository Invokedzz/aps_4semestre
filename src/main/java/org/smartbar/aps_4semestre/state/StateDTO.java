package org.smartbar.aps_4semestre.state;

public record StateDTO (

        int id_bdq,

        String foco_id,

        double lat,

        double lon,

        String data_pass,

        String pais,

        String municipio,

        String bioma

) {}
