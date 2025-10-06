package org.smartbar.aps_4semestre.state;

import java.util.ArrayList;
import java.util.List;

import org.smartbar.aps_4semestre.ordenation.SortAlgorithm;
import org.smartbar.aps_4semestre.pagination.PaginationCreator;
import org.smartbar.aps_4semestre.pagination.PaginationDTO;
import org.smartbar.aps_4semestre.pagination.StateQueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    private final StateRepositoryTemplate stateTemplate;

    public StateService (StateRepositoryTemplate stateTemplate) {

        this.stateTemplate = stateTemplate;

    }

    // Método para buscar dados da Amazônia com paginação
    // @param pagina Número da página (começa em 0)
    // @param tamanho Tamanho da página
    // @param criterioOrdenacao Critério de ordenação ("data", "bioma", "municipio", "precipitacao")
    // @return PaginationDTO contendo os dados paginados e ordenados

    public PaginationDTO <StateDTO> findStateData (StateQueryParams params) {

        Pageable page = PageRequest.of(params.getPageNumber(), params.getSize());

        Page <State> statePage = orderStateData(params, page);
        PaginationCreator <StateDTO> creator = new PaginationCreator<>();
        List <StateDTO> collection = new ArrayList<>(statePage.stream().map(StateDTO::new).toList());

       return creator.createPaginatedResponse(collection, page);

    }

    private Page <State> orderStateData (StateQueryParams params, Pageable page) {

        List <State> states = stateTemplate.findStateDataAccordingToYear(params.getYear(), page);

        SortAlgorithm <State> sort = new SortAlgorithm<>();
        sort.quickSort(states, 0, states.size() - 1, "municipio");

        return new PageImpl<>(states);

    }

}
