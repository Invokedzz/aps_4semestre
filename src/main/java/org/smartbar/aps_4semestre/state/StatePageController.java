package org.smartbar.aps_4semestre.state;

import jakarta.validation.Valid;
import org.smartbar.aps_4semestre.pagination.PaginationDTO;
import org.smartbar.aps_4semestre.pagination.ResponseDTO;
import org.smartbar.aps_4semestre.pagination.StateQueryParams;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StatePageController {

    private final StateService stateService;

    public StatePageController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/state")
    public String renderStatesPage(@Valid StateQueryParams params, Model model) {

        ResponseDTO<StateDTO> response = stateService.findStateData(params);

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
