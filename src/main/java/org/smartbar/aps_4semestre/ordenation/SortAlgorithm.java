package org.smartbar.aps_4semestre.ordenation;

import org.smartbar.aps_4semestre.state.State;

import java.util.List;

public class SortAlgorithm <E extends State> extends Sort {

    private int numberOfComparisons = 0;
    private int numberOfSwaps = 0;

    // Implementação do algoritmo QuickSort para ordenar uma lista de StateDTO
    // @param lista Lista a ser ordenada
    // @param inicio Índice inicial
    // @param fim Índice final
    // @param criterio Critério de ordenação ("data", "bioma", "municipio", "precipitacao")

    public void quickSort (List <E> list, int begin, int end, String criteria) {

        if (begin < end) {

            int pivotIndex = partition(list, begin, end, criteria);
            quickSort(list, begin, pivotIndex - 1, criteria);
            quickSort(list, pivotIndex + 1, end, criteria);

        }

    }

    private int partition (List <E> list, int begin, int end, String criteria) {

        E pivot = list.get(end);
        int i = begin - 1;

        for (int j = begin; j < end; j++) {

            numberOfComparisons++;
            setComparisons(numberOfComparisons);

            if (compare(list.get(j), pivot, criteria) <= 0) {

                i++;
                swap(list, i, j);

            }

        }

        swap(list, i + 1, end);
        return i + 1;

    }

    private void swap (List <E> list, int i, int j) {

        if (i != j) {

            numberOfSwaps++;
            setSwaps(numberOfSwaps);
            E temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);

        }

    }

    private int compare (E a, E b, String criteria) {

        return switch (criteria.toLowerCase()) {

            case "data" -> a.data_pas.compareTo(b.data_pas);
            case "bioma" -> a.bioma.compareTo(b.bioma);
            case "municipio" -> a.municipio.compareTo(b.municipio);
            case "estado" -> a.estado.compareTo(b.estado);

            default -> throw new IllegalArgumentException("Critério de ordenação inválido: " + criteria);

        };

    }

}
