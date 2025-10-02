package org.smartbar.aps_4semestre.state;

import org.smartbar.aps_4semestre.pagination.PaginationCreator;
import org.smartbar.aps_4semestre.pagination.PaginationDTO;
import org.smartbar.aps_4semestre.pagination.StateQueryParams;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StateService {

    private final StateRepository stateRepository;

    public StateService (StateRepository stateRepository) {

        this.stateRepository = stateRepository;

    }

    public PaginationDTO <StateDTO> findStateData (StateQueryParams params) {

        Pageable page = PageRequest.of(params.getPageNumber(), params.getSize());

        Collection <StateDTO> collection = stateRepository.findAll(page).stream().map(StateDTO::new).toList();
        PaginationCreator <StateDTO> creator = new PaginationCreator<>();

        return creator.createPaginatedResponse(collection, page);

    }

}
