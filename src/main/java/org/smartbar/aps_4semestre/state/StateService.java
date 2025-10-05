package org.smartbar.aps_4semestre.state;

import org.smartbar.aps_4semestre.pagination.PaginationCreator;
import org.smartbar.aps_4semestre.pagination.PaginationDTO;
import org.smartbar.aps_4semestre.pagination.StateQueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    private final StateRepositoryExtension stateRepositoryEx;

    public StateService (StateRepositoryExtension stateRepositoryEx) {

        this.stateRepositoryEx = stateRepositoryEx;

    }

    public PaginationDTO <StateDTO> findStateData (StateQueryParams params) {

        Pageable page = PageRequest.of(params.getPageNumber(), params.getSize());

        Page <State> statePage = stateRepositoryEx.findStateDataAccordingToYear(params.getYear(), page);
        PaginationCreator <StateDTO> creator = new PaginationCreator<>();
        List <StateDTO> collection = statePage.stream().map(StateDTO::new).toList();

       return creator.createPaginatedResponse(collection, page);

    }

}
