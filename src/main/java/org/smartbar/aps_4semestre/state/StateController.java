package org.smartbar.aps_4semestre.state;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {

    private final StateService stateService;

    public StateController (StateService stateService) {

        this.stateService = stateService;

    }

}
