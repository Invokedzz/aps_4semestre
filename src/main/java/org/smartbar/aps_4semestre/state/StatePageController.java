package org.smartbar.aps_4semestre.state;

import jakarta.validation.Valid;
import org.smartbar.aps_4semestre.pagination.StateQueryParams;
import org.smartbar.aps_4semestre.render.RenderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatePageController {

    private final RenderService renderService;

    public StatePageController (RenderService renderService) {

        this.renderService = renderService;

    }

    @GetMapping("/state")
    public ModelAndView renderStatesPage (@Valid StateQueryParams params) {

        return renderService.renderStatePage(params);

    }

}
