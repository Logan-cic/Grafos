public class Main {
    
    public static void main(String[] args) {
        Grafo<Integer> grafinho = new Grafo<Integer>();
        grafinho.addVertice("u");
        grafinho.addVertice("v");
        grafinho.addVertice("y");
        grafinho.addVertice("w");
        grafinho.addVertice("x");     

        grafinho.addAresta("u", "v");
        grafinho.addAresta("u", "w");

        grafinho.addAresta("v", "u");        
        grafinho.addAresta("v", "v");
        grafinho.addAresta("v", "w");
        grafinho.addAresta("v", "x");

        grafinho.addAresta("w", "v");
        grafinho.addAresta("w", "u");

        grafinho.addAresta("x", "v");

        System.out.println(" ");

        grafinho.printAdjList();
        System.out.println(" ");
        grafinho.printMatrizAdj();

        System.out.println(" ");

        grafinho.numeroDeVertices();
        grafinho.numeroDeArestas();

        System.out.println(" ");

        grafinho.printArestasAdjacentes("v");

        System.out.println(" ");
    }
    
}