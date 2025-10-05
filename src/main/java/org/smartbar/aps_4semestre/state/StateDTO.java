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

) {

    public StateDTO (State state) {
        this (
                state.id_bdq, state.foco_id, state.lat, state.lon, state.data_pas,
                state.pais, state.estado, state.municipio, state.bioma
        );
    }

    public String getData() {
        return this.data_pass;
    }

    public String getBioma() {
        return this.bioma;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    // Como não existe precipitação nos dados, vamos retornar 0.0 por padrão
    // ou você pode adicionar esse campo no CSV depois
    public double getPrecipitacao() {
        return 0.0; // TODO: Adicionar campo precipitacao quando disponível
    }

}