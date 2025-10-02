package org.smartbar.aps_4semestre.pagination;

import org.smartbar.aps_4semestre.state.StateDTO;
import org.springframework.data.domain.Page;

public record PaginationDTO <E> (

        Page <E> items

) {}
