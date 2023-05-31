public class Main {
    
    /**
     * @param args
     */
    public static void main(String[] args) {

        // Grafo<String> g = new Grafo<String>();
        // g.addVertice("a");
        // g.addVertice("b");
        // g.addVertice("c");
        // g.addVertice("d");
        // g.addVertice("e");


        // g.addAresta("a", "b", "2");
        // g.addAresta("b", "a", "2");

        // g.addAresta("a", "e", "3");
        // g.addAresta("e", "a", "3");


        // g.addAresta("b", "c", "3");
        // g.addAresta("c", "b", "3");

        // g.addAresta("b", "e", "4");
        // g.addAresta("e", "b", "4");

        // g.addAresta("b", "e", "6");
        // g.addAresta("e", "b", "6");

        // g.addAresta("c", "d", "5");
        // g.addAresta("d", "c", "5");

        // g.addAresta("d", "e", "3");
        // g.addAresta("e", "d", "3");

        // g.Dijkstra("a");

        // Grafo<String> grafo = new Grafo<>();

        // // Adicionar vértices
        // grafo.addVertice("A");
        // grafo.addVertice("B");
        // grafo.addVertice("C");
        // grafo.addVertice("D");
        // grafo.addVertice("E");

        // // Adicionar arestas
        // grafo.addAresta("A", "B", "4");
        // grafo.addAresta("A", "C", "2");
        // grafo.addAresta("B", "D", "3");
        // grafo.addAresta("C", "B", "1");
        // grafo.addAresta("C", "D", "4");
        // grafo.addAresta("D", "E", "2");
        // grafo.addAresta("E", "C", -"3");

        // grafo.BellmanFord("A");

        Grafo<Character> grafo = new Grafo<>();

        grafo.addVertice('A');
        grafo.addVertice('B');
        grafo.addVertice('C');
        grafo.addVertice('D');

        // Adicionar arestas
        grafo.addAresta('A', 'B', 1);
        grafo.addAresta('B', 'C', 1);
        grafo.addAresta('C', 'A', 1);
        grafo.addAresta('C', 'D', 1);
        

        grafo.DFS();
        int[][] closure = grafo.warshall();
        System.out.println("Matriz de Fecho Transitivo (Warshall):");
        grafo.imprimirMatriz(closure);
        System.out.println();

        // grafo.FloydWarshall();
        // grafo.printMatrizAdj();
        // grafo.printAdjList();
    }
}