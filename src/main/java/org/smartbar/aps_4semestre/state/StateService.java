package org.smartbar.aps_4semestre.state;

import java.util.ArrayList;
import java.util.List;

import org.smartbar.aps_4semestre.ordenation.Sort;
import org.smartbar.aps_4semestre.ordenation.SortDTO;
import org.smartbar.aps_4semestre.ordenation.SortService;
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

    private final SortService <State> sortService;

    public StateService (StateRepositoryTemplate stateTemplate, SortService <State> sortService) {

        this.stateTemplate = stateTemplate;

        this.sortService = sortService;

    }

    // Método para buscar dados da Amazônia com paginação
    // @param pagina Número da página (começa em 0)
    // @param tamanho Tamanho da página
    // @param criterioOrdenacao Critério de ordenação ("data", "bioma", "municipio", "precipitacao")
    // @return PaginationDTO contendo os dados paginados e ordenados

    public ResponseDTO <StateDTO> findStateData (StateQueryParams params) {

        Pageable page = PageRequest.of(params.getPageNumber(), params.getSize());

        List <State> states = stateTemplate.findStateDataAccordingToYear(params.getYear(), page);
        Sort sortResult = sortService.orderData(states, params);
        PaginationCreator <StateDTO> creator = new PaginationCreator<>();
        Page <State> statePage = turnListIntoPage(states);
        List <StateDTO> collection = streamThroughPage(statePage);

        PaginationDTO <StateDTO> pagination = creator.createPaginatedResponse(collection, page);
        SortDTO sort = sortService.createSortDTO(sortResult.getSwaps(), sortResult.getComparisons());

        return new ResponseDTO<>(pagination, sort);

    }

    private Page <State> turnListIntoPage (List <State> states) {

        return new PageImpl<>(states);

    }

    private List <StateDTO> streamThroughPage (Page <State> statePage) {

        return new ArrayList<>(statePage.stream().map(StateDTO::new).toList());

    }

}
