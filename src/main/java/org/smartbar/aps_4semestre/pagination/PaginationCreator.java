package org.smartbar.aps_4semestre.pagination;

import org.springframework.data.domain.Pageable;

import java.util.Collection;

public class PaginationCreator <DTO> {

    public PaginationDTO <DTO> createPaginatedResponse (Collection <DTO> collection, Pageable page) {

        int size = page.getPageSize(), index = page.getPageNumber();

        return new PaginationDTO<>(collection, index, size);

    }

}
