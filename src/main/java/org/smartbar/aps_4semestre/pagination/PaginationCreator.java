package org.smartbar.aps_4semestre.pagination;

import org.springframework.data.domain.Page;

import java.util.Collection;

public class PaginationCreator <DTO, E> {

    public PaginationDTO <DTO> createPaginatedResponse (Collection <DTO> collection, Page <E> page) {

        int size = page.getSize(), index = page.getNumber();

        int totalPages = page.getTotalPages();

        return new PaginationDTO<>(collection, index, size, totalPages);

    }

}
