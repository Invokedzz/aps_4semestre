package org.smartbar.aps_4semestre.state;

import jakarta.validation.Valid;
import org.smartbar.aps_4semestre.pagination.ResponseDTO;
import org.smartbar.aps_4semestre.pagination.StateQueryParams;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {

    private final StateService stateService;

    public StateController (StateService stateService) {

        this.stateService = stateService;

    }

    @GetMapping
    public ResponseDTO <StateDTO> getStateData (@Valid StateQueryParams params) {

        return stateService.findStateData(params);

    }

}
