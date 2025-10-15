package org.smartbar.aps_4semestre.render;

import org.smartbar.aps_4semestre.pagination.ResponseDTO;
import org.smartbar.aps_4semestre.pagination.StateQueryParams;
import org.smartbar.aps_4semestre.state.StateDTO;
import org.smartbar.aps_4semestre.state.StateService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class RenderService {

    private final StateService stateService;

    private final RenderTemplate renderTemplate;

    private static final String FILE_NAME = "aps";

    public RenderService (StateService stateService, RenderTemplate renderTemplate) {

        this.stateService = stateService;

        this.renderTemplate = renderTemplate;

    }

    public ModelAndView renderStatePage (StateQueryParams params) {

        ResponseDTO <StateDTO> response = stateService.findStateData(params);

        Page <StateDTO> items = response.pagination().items();
        ModelAndView model = renderTemplate.getModel(FILE_NAME);

        model.addObject("states", items.getContent());
        model.addObject("currentPage", items.getNumber());
        model.addObject("totalPages", items.getTotalPages());
        model.addObject("pageSize", items.getSize());
        model.addObject("hasPreviousPage", response.pagination().hasPreviousPage());

        model.addObject("sortSwaps", response.sort().numberOfSwaps());
        model.addObject("sortComparisons", response.sort().numberOfComparisons());

        return model;

    }

}
