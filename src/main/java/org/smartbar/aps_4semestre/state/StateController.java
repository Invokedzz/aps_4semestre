package org.smartbar.aps_4semestre.state;

import jakarta.validation.Valid;
import org.smartbar.aps_4semestre.pagination.PaginationDTO;
import org.smartbar.aps_4semestre.pagination.StateQueryParams;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {

    private final StateService stateService;

    public StateController (StateService stateService) {

        this.stateService = stateService;

    }

    @GetMapping
    public PaginationDTO <StateDTO> getStateData (@Valid @ModelAttribute StateQueryParams params) {

        return stateService.findStateData(params);

    }

}
