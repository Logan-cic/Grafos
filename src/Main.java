public class Main {
    
    public static void main(String[] args) {

        Grafo<String> grafo = new Grafo<String>();
        grafo.addVertice("A");
        grafo.addVertice("B");
        grafo.addVertice("C");
        grafo.addVertice("D");
        grafo.addVertice("E");
        grafo.addVertice("F");

        
        grafo.addAresta("A", "B");
        grafo.addAresta("A", "C");

        grafo.addAresta("B", "C");
        grafo.addAresta("B", "A");


        grafo.addAresta("C", "B");
        grafo.addAresta("C", "D");


        grafo.addAresta("D", "E");
        grafo.addAresta("D", "C");

        grafo.addAresta("E", "D");
        
        grafo.addAresta("E", "F");
        grafo.addAresta("F", "F");
        grafo.addAresta("F", "E");

        
        grafo.DFS();
        System.out.println(grafo.toString());

        System.out.println(" ");
        grafo.printAdjList();
        System.out.println(" ");
        grafo.printMatrizAdj();

        System.out.println(" ");
 
    }
    
}