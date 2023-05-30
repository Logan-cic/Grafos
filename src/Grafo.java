import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Grafo<T> {
    private HashMap<T, Vertice<T>> vertices;

    public Grafo() {
        this.vertices = new HashMap<>();
    }

    public void addVertice(T dado) {
        if (!vertices.containsKey(dado)) {
            vertices.put(dado, new Vertice<>(dado));
        }
    }

    public void addAresta(T inicio, T fim, int peso) {
        if (vertices.containsKey(inicio) && vertices.containsKey(fim)) {
            Vertice<T> verticeInicio = vertices.get(inicio);
            Vertice<T> verticeFim = vertices.get(fim);

            Aresta<T> aresta = new Aresta<>(verticeInicio, verticeFim, peso);

            verticeInicio.addArestaSaida(aresta);
            verticeFim.addArestaEntrada(aresta);
        }
    }

    public void printAdjList() {
        for (Vertice<T> vertice : vertices.values()) {
            System.out.print(vertice.getDado() + ": ");

            for (Aresta<T> aresta : vertice.getArestasSaida()) {
                System.out.print(aresta.getFim().getDado() + "(" + aresta.getPeso() + ") ");
            }

            System.out.println();
        }
    }

    public void printMatrizAdj() {
        int n = vertices.size();
        T[] verticeArray = (T[]) vertices.keySet().toArray();

        System.out.print("  ");

        for (int i = 0; i < n; i++) {
            System.out.print(verticeArray[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(verticeArray[i] + " ");

            for (int j = 0; j < n; j++) {
                Vertice<T> verticeInicio = vertices.get(verticeArray[i]);
                Vertice<T> verticeFim = vertices.get(verticeArray[j]);
                boolean adjacente = false;

                for (Aresta<T> aresta : verticeInicio.getArestasSaida()) {
                    if (aresta.getFim() == verticeFim) {
                        System.out.print(aresta.getPeso() + " ");
                        adjacente = true;
                        break;
                    }
                }

                if (!adjacente) {
                    System.out.print("0 ");
                }
            }

            System.out.println();
        }
    }

    public void printArestasAdjacentes(T dado) {
        if (vertices.containsKey(dado)) {
            Vertice<T> vertice = vertices.get(dado);

            System.out.println("Arestas adjacentes a " + dado + ":");

            for (Aresta<T> aresta : vertice.getArestasSaida()) {
                System.out.println(aresta);
            }
        }
    }

    public void BFS(T dado) {
        if (vertices.containsKey(dado)) {
            Vertice<T> vertice = vertices.get(dado);
            Queue<Vertice<T>> fila = new LinkedList<>();
            HashSet<Vertice<T>> visitados = new HashSet<>();

            fila.add(vertice);
            visitados.add(vertice);

            System.out.println("Busca em Largura (BFS) a partir de " + dado + ":");

            while (!fila.isEmpty()) {
                Vertice<T> atual = fila.poll();
                System.out.print(atual.getDado() + " ");

                for (Aresta<T> aresta : atual.getArestasSaida()) {
                    Vertice<T> vizinho = aresta.getFim();

                    if (!visitados.contains(vizinho)) {
                        fila.add(vizinho);
                        visitados.add(vizinho);
                    }
                }
            }

            System.out.println();
        }
    }

    public void DFS() {
        HashSet<Vertice<T>> visitados = new HashSet<>();

        System.out.println("Busca em Profundidade (DFS):");

        for (Vertice<T> vertice : vertices.values()) {
            if (!visitados.contains(vertice)) {
                DFSVisit(vertice, visitados);
            }
        }

        System.out.println();
    }

    private void DFSVisit(Vertice<T> vertice, HashSet<Vertice<T>> visitados) {
        visitados.add(vertice);
        System.out.print(vertice.getDado() + " ");

        for (Aresta<T> aresta : vertice.getArestasSaida()) {
            Vertice<T> vizinho = aresta.getFim();

            if (!visitados.contains(vizinho)) {
                DFSVisit(vizinho, visitados);
            }
        }
    }

    public void Dijkstra(T dado) {
        if (vertices.containsKey(dado)) {
            Vertice<T> fonte = vertices.get(dado);
            initializeSingleSource(fonte);
            HashSet<Vertice<T>> S = new HashSet<>();
            PriorityQueue<Vertice<T>> Q = new PriorityQueue<>(Comparator.comparingInt(Vertice<T>::getDistancia));

            Q.addAll(vertices.values());

            System.out.println("Algoritmo de Dijkstra a partir de " + dado + ":");

            while (!Q.isEmpty()) {
                Vertice<T> u = Q.poll();
                S.add(u);


                for (Aresta<T> aresta : u.getArestasSaida()) {
                    relax(u, aresta.getFim(), aresta.getPeso());
                    System.out.println(aresta);
                }
            }

            for (Vertice<T> vertice : vertices.values()) {
                System.out.println("Menor distância até " + vertice.getDado() + ": " + vertice.getDistancia());
            }

            System.out.println();
        }
    }

    public void BellmanFord(T dado) {
        if (vertices.containsKey(dado)) {
            Vertice<T> fonte = vertices.get(dado);
            initializeSingleSource(fonte);

            System.out.println("Algoritmo de Bellman-Ford a partir de " + dado + ":");

            for (int i = 0; i < vertices.size() - 1; i++) {
                for (Vertice<T> u : vertices.values()) {
                    for (Aresta<T> aresta : u.getArestasSaida()) {
                        Vertice<T> v = aresta.getFim();
                        int peso = aresta.getPeso();
                        relax(u, v, peso);
                        System.out.println(aresta);
                    }
                }
            }

            for (Vertice<T> u : vertices.values()) {
                for (Aresta<T> aresta : u.getArestasSaida()) {
                    Vertice<T> v = aresta.getFim();
                    int peso = aresta.getPeso();
                    if (v.getDistancia() > u.getDistancia() + peso) {
                        System.out.println("O grafo contém um ciclo de peso negativo.");
                        return;
                    }
                }
            }

            for (Vertice<T> vertice : vertices.values()) {
                System.out.println("Menor distância até " + vertice.getDado() + ": " + vertice.getDistancia());
            }

            System.out.println();
        }
    }

    public void FloydWarshall() {
        int n = vertices.size();
        int[][] dist = new int[n][n];
        T[] verticeArray = (T[]) vertices.keySet().toArray();
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            Vertice<T> verticeInicio = vertices.get(verticeArray[i]);
    
            for (Aresta<T> aresta : verticeInicio.getArestasSaida()) {
                Vertice<T> verticeFim = aresta.getFim();
                int peso = aresta.getPeso();
                int inicioIndex = getIndex(verticeArray, verticeInicio.getDado());
                int fimIndex = getIndex(verticeArray, verticeFim.getDado());
                dist[inicioIndex][fimIndex] = peso;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        System.out.println("Matriz (Floyd-Warshall):");
        System.out.print("  ");
        for (int i = 0; i < n; i++) {
            System.out.print(verticeArray[i] + " ");
        }
        System.out.println();
    
        for (int i = 0; i < n; i++) {
            System.out.print(verticeArray[i] + " ");
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("inf ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    
    private int getIndex(T[] array, T value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private void initializeSingleSource(Vertice<T> fonte) {
        for (Vertice<T> vertice : vertices.values()) {
            vertice.setDistancia(Integer.MAX_VALUE);
            vertice.setAntecessor(null);
        }

        fonte.setDistancia(0);
    }

    private void relax(Vertice<T> u, Vertice<T> v, int peso) {
        if (v.getDistancia() > u.getDistancia() + peso) {
            v.setDistancia(u.getDistancia() + peso);
            v.setAntecessor(u);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Vertice<T> vertice : vertices.values()) {
            sb.append("Vertice: ").append(vertice.getDado()).append(", Distancia: ").append(vertice.getDistancia()).append("\n");
        }

        return sb.toString();
    }
}