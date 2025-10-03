package org.smartbar.aps_4semestre.pagination;

import org.springframework.data.domain.Page;

public record PaginationDTO <E> (

        Page <E> items,

        boolean hasPreviousPage

) {}
