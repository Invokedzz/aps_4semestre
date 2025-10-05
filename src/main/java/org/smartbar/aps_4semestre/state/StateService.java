package org.smartbar.aps_4semestre.state;

import java.util.List;

import org.smartbar.aps_4semestre.pagination.PaginationCreator;
import org.smartbar.aps_4semestre.pagination.PaginationDTO;
import org.smartbar.aps_4semestre.pagination.StateQueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    private final StateRepositoryTemplate stateTemplate;

    public StateService (StateRepositoryTemplate stateTemplate) {

        this.stateTemplate = stateTemplate;

    }

    public PaginationDTO <StateDTO> findStateData (StateQueryParams params) {

        Pageable page = PageRequest.of(params.getPageNumber(), params.getSize());

        Page <State> statePage = stateTemplate.findStateDataAccordingToYear(params.getYear(), page);
        PaginationCreator <StateDTO> creator = new PaginationCreator<>();
        List <StateDTO> collection = statePage.stream().map(StateDTO::new).toList();

       return creator.createPaginatedResponse(collection, page);

    }
    // ============= QUICKSORT IMPLEMENTATION =============
    
    private int numeroComparacoes = 0;
    private int numeroTrocas = 0;

    /**
     * Implementação do algoritmo QuickSort para ordenar uma lista de StateDTO
     * @param lista Lista a ser ordenada
     * @param inicio Índice inicial
     * @param fim Índice final
     * @param criterio Critério de ordenação ("data", "bioma", "municipio", "precipitacao")
     */
    public void quickSort(List<StateDTO> lista, int inicio, int fim, String criterio) {
        if (inicio < fim) {
            int indicePivo = particionar(lista, inicio, fim, criterio);
            quickSort(lista, inicio, indicePivo - 1, criterio);
            quickSort(lista, indicePivo + 1, fim, criterio);
        }
    }

    /**
     * Método auxiliar para particionar a lista no QuickSort
     */
    private int particionar(List<StateDTO> lista, int inicio, int fim, String criterio) {
        StateDTO pivo = lista.get(fim);
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            numeroComparacoes++; // Contabiliza comparação
            if (comparar(lista.get(j), pivo, criterio) <= 0) {
                i++;
                trocar(lista, i, j);
            }
        }
        trocar(lista, i + 1, fim);
        return i + 1;
    }

    /**
     * Método auxiliar para trocar elementos na lista
     */
    private void trocar(List<StateDTO> lista, int i, int j) {
        if (i != j) { // Só conta como troca se forem posições diferentes
            numeroTrocas++; // Contabiliza troca
            StateDTO temp = lista.get(i);
            lista.set(i, lista.get(j));
            lista.set(j, temp);
        }
    }

    /**
     * Método auxiliar para comparar dois StateDTO baseado no critério
     * @return valor negativo se a < b, 0 se iguais, positivo se a > b
     */
    private int comparar(StateDTO a, StateDTO b, String criterio) {
        switch (criterio.toLowerCase()) {
            case "data":
                return a.getData().compareTo(b.getData());
            
            case "bioma":
                return a.getBioma().compareTo(b.getBioma());
            
            case "municipio":
                return a.getMunicipio().compareTo(b.getMunicipio());
            
            case "precipitacao":
                return Double.compare(a.getPrecipitacao(), b.getPrecipitacao());
            
            default:
                throw new IllegalArgumentException("Critério de ordenação inválido: " + criterio);
        }
    }

    public void resetarContadores() {
        this.numeroComparacoes = 0;
        this.numeroTrocas = 0;
    }

    public int getNumeroComparacoes() {
        return numeroComparacoes;
    }

    public int getNumeroTrocas() {
        return numeroTrocas;
    }

    /**
     * Método para buscar dados da Amazônia com paginação
     * @param pagina Número da página (começa em 0)
     * @param tamanho Tamanho da página
     * @param criterioOrdenacao Critério de ordenação ("data", "bioma", "municipio", "precipitacao")
     * @return PaginationDTO contendo os dados paginados e ordenados
     */
    public PaginationDTO<StateDTO> obterDadosAmazonia(int pagina, int tamanho, String criterioOrdenacao) {
        return null;
    }

}
