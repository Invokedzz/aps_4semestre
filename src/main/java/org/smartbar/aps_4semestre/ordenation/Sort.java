package org.smartbar.aps_4semestre.ordenation;

public class Sort {

    private int comparisons = 0;
    private int swaps = 0;

    public Sort () {}

    public Sort (int comparisons, int swaps) {

        this.comparisons = comparisons;

        this.swaps = swaps;

    }

    public int getComparisons () {

        return comparisons;

    }

    public void setComparisons (int comparisons) {

        this.comparisons = comparisons;

    }

    public int getSwaps () {

        return swaps;

    }

    public void setSwaps (int swaps) {

        this.swaps = swaps;

    }

}
