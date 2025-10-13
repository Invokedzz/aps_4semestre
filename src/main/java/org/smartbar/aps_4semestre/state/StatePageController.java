package org.smartbar.aps_4semestre.state;

import jakarta.validation.Valid;
import org.smartbar.aps_4semestre.pagination.StateQueryParams;
import org.smartbar.aps_4semestre.state.render.RenderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatePageController {

    private final RenderService renderService;

    public StatePageController (RenderService renderService) {

        this.renderService = renderService;

    }

    @GetMapping("/state")
    public String renderStatesPage (@Valid StateQueryParams params, Model model) {

        return renderService.renderStatePage(params, model);

    }

}
