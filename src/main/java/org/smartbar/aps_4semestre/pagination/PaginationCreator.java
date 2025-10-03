package org.smartbar.aps_4semestre.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PaginationCreator <E> {

    public PaginationDTO <E> createPaginatedResponse (List <E> list, Pageable pageable) {

        Page <E> page = new PageImpl<>(list, pageable, list.size());
        return new PaginationDTO<>(page, page.hasPrevious());

    }

}
