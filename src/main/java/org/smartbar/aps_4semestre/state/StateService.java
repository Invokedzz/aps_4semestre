package org.smartbar.aps_4semestre.state;

import org.springframework.stereotype.Service;

@Service
public class StateService {

    private final StateRepository stateRepository;

    public StateService (StateRepository stateRepository) {

        this.stateRepository = stateRepository;

    }

}
