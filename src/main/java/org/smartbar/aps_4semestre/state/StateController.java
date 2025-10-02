package org.smartbar.aps_4semestre.state;

import jakarta.servlet.ServletResponse;
import jakarta.validation.Valid;
import org.smartbar.aps_4semestre.pagination.StateQueryParams;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <Object> getStateData (@Valid @ModelAttribute StateQueryParams params, PagedResourcesAssembler<State> assembler, ServletResponse servletResponse) {

        return ResponseEntity.ok(assembler.toModel(stateService.findStateData(params)));

    }

}
