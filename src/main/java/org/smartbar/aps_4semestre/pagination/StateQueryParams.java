package org.smartbar.aps_4semestre.pagination;

import jakarta.validation.constraints.Min;

public class StateQueryParams {

    @Min(value = 1, message = "Minimum value for 'size' is 1")
    private int size = 5;

    @Min(value = 0, message = "Minimum value for 'pageNumber' is 0")
    private int pageNumber = 0;

    public StateQueryParams () {}

    public int getSize () {

        return size;

    }

    public void setSize (String size) {

        if (size.matches("^\\d+$")) this.size = Integer.parseInt(size);

    }

    public int getPageNumber () {

        return pageNumber;

    }

    public void setPageNumber (String pageNumber) {

        if (pageNumber.matches("^\\d+$")) this.pageNumber = Integer.parseInt(pageNumber);

    }

}
