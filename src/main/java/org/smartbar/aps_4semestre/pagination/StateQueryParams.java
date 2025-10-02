package org.smartbar.aps_4semestre.pagination;

import jakarta.validation.constraints.Min;

public class StateQueryParams {

    @Min(1)
    private int size = 5;

    @Min(0)
    private int pageNumber = 0;

    public StateQueryParams () {}

    public int getSize () {

        return size;

    }

    public void setSize (int size) {

        this.size = size;

    }

    public int getPageNumber () {

        return pageNumber;

    }

    public void setPageNumber (int pageNumber) {

        this.pageNumber = pageNumber;

    }

}
