package org.smartbar.aps_4semestre.state;

import java.util.ArrayList;
import java.util.List;

import org.smartbar.aps_4semestre.ordenation.SortAlgorithm;
import org.smartbar.aps_4semestre.ordenation.SortDTO;
import org.smartbar.aps_4semestre.pagination.PaginationCreator;
import org.smartbar.aps_4semestre.pagination.PaginationDTO;
import org.smartbar.aps_4semestre.pagination.ResponseDTO;
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

    public ResponseDTO <StateDTO> findStateData (StateQueryParams params) {

        Pageable page = PageRequest.of(params.getPageNumber(), params.getSize());

        SortAlgorithm <State> sortAlg = new SortAlgorithm<>();
        Page <State> statePage = orderStateData(sortAlg, params, page);
        PaginationCreator <StateDTO> creator = new PaginationCreator<>();
        List <StateDTO> collection = streamThroughPage(statePage);

        PaginationDTO <StateDTO> pagination = creator.createPaginatedResponse(collection, page);
        SortDTO sort = createSortData(sortAlg);

        return new ResponseDTO<>(pagination, sort);

    }

    private List <StateDTO> streamThroughPage (Page <State> statePage) {

        return new ArrayList<>(statePage.stream().map(StateDTO::new).toList());

    }

    private Page <State> orderStateData (SortAlgorithm <State> sort, StateQueryParams params, Pageable page) {

        List <State> states = stateTemplate.findStateDataAccordingToYear(params.getYear(), page);
        sort.resetCounters();
        sort.quickSort(states, 0, states.size() - 1, params.getOrderBy());

        return new PageImpl<>(states);

    }

    private SortDTO createSortData (SortAlgorithm <State> sort) {

        return new SortDTO(sort.getSwaps(), sort.getComparisons());

    }

}
