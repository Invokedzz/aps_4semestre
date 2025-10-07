package org.smartbar.aps_4semestre.ordenation;

import org.smartbar.aps_4semestre.pagination.StateQueryParams;
import org.smartbar.aps_4semestre.state.State;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortService <E extends State> {

    public Sort orderData (List <E> list, StateQueryParams params) {

        SortAlgorithm <E> sortAlgorithm = new SortAlgorithm<>();

        sortAlgorithm.resetCounters();
        return sortAlgorithm.quickSort(list, 0, list.size() - 1, params.getOrderBy());

    }

    public SortDTO createSortDTO (int swaps, int comparisons) {

        return new SortDTO(swaps, comparisons);

    }

}
