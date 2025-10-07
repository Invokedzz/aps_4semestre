package org.smartbar.aps_4semestre.pagination;

import org.smartbar.aps_4semestre.ordenation.SortDTO;

public record ResponseDTO <E> (

        PaginationDTO <E> pagination,

        SortDTO sort

) {}
