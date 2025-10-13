package org.smartbar.aps_4semestre.state.render;

import org.smartbar.aps_4semestre.pagination.ResponseDTO;
import org.smartbar.aps_4semestre.pagination.StateQueryParams;
import org.smartbar.aps_4semestre.state.StateDTO;
import org.smartbar.aps_4semestre.state.StateService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class RenderService {

    private final StateService stateService;

    public RenderService (StateService stateService) {

        this.stateService = stateService;

    }

    public String renderStatePage (StateQueryParams params, Model model) {

        ResponseDTO <StateDTO> response = stateService.findStateData(params);

        Page <StateDTO> items = response.pagination().items();

        model.addAttribute("states", items.getContent());
        model.addAttribute("currentPage", items.getNumber());
        model.addAttribute("totalPages", items.getTotalPages());
        model.addAttribute("pageSize", items.getSize());
        model.addAttribute("hasPreviousPage", response.pagination().hasPreviousPage());

        model.addAttribute("sortSwaps", response.sort().numberOfSwaps());
        model.addAttribute("sortComparisons", response.sort().numberOfComparisons());

        return "aps";

    }

}
