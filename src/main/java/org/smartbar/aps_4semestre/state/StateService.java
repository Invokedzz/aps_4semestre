package org.smartbar.aps_4semestre.state;

import org.smartbar.aps_4semestre.pagination.PaginationCreator;
import org.smartbar.aps_4semestre.pagination.PaginationDTO;
import org.smartbar.aps_4semestre.pagination.StateQueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StateService {

    private final StateRepository stateRepository;

    public StateService (StateRepository stateRepository) {

        this.stateRepository = stateRepository;

    }

    public Page<State> findStateData (StateQueryParams params) {

        Pageable page = PageRequest.of(params.getPageNumber(), params.getSize());

        Page <State> statePage = stateRepository.findAll(page);
        PaginationCreator <StateDTO> creator = new PaginationCreator<>();

        List <StateDTO> collection = statePage.stream().map(StateDTO::new).toList();

        return statePage;
    //    return creator.createPaginatedResponse(collection, page);

    }

}
