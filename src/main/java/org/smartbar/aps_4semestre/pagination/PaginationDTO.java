package org.smartbar.aps_4semestre.pagination;

import java.util.Collection;

public record PaginationDTO <E> (

        Collection <E> items,

        int pageNumber,

        int size,

        long totalPages

) {}
