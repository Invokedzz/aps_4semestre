package org.smartbar.aps_4semestre.pagination;

import jakarta.validation.constraints.Min;

import java.util.Set;

public class StateQueryParams {

    @Min(value = 1, message = "Minimum value for 'size' is 1")
    private int size = 5;

    @Min(value = 0, message = "Minimum value for 'pageNumber' is 0")
    private int pageNumber = 0;

    private int year = 2024;

    private final static Set <Integer> AVAILABLE_YEARS_FOR_QUERY = Set.of(2023, 2024);

    private final static String NUMERIC_REGEX_PATTERN = "^\\d+$";

    public StateQueryParams () {}

    public int getSize () {

        return size;

    }

    public void setSize (String size) {

        if (size.matches(NUMERIC_REGEX_PATTERN))
            this.size = Integer.parseInt(size);

    }

    public int getPageNumber () {

        return pageNumber;

    }

    public void setPageNumber (String pageNumber) {

        if (pageNumber.matches(NUMERIC_REGEX_PATTERN))
            this.pageNumber = Integer.parseInt(pageNumber);

    }

    public int getYear () {

        return year;

    }

    public void setYear (String year) {

        boolean matches = year.matches(NUMERIC_REGEX_PATTERN);

        if (matches) {

            int convertedToNum = Integer.parseInt(year);
            if (AVAILABLE_YEARS_FOR_QUERY.contains(convertedToNum)) this.year = convertedToNum;

        }

    }

}
