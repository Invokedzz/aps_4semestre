package org.smartbar.aps_4semestre.state;

public record StateDTO (

        int id_bdq,

        String foco_id,

        double lat,

        double lon,

        String data_pass,

        String pais,

        String estado,

        String municipio,

        String bioma

)

{

    public StateDTO (State state) {

        this (
                state.id_bdq, state.foco_id, state.lat, state.lon, state.data_pas,
                state.pais, state.estado, state.municipio, state.bioma
        );

    }

}
