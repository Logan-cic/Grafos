public class Main {
    
    public static void main(String[] args) {
        Grafo<Integer> grafinho = new Grafo<Integer>();
        grafinho.addVertice(1);
        grafinho.addVertice(2);
        grafinho.addVertice(3);
        grafinho.addVertice(4);

        grafinho.addAresta(1, 2);
        grafinho.addAresta(1, 4);
        grafinho.addAresta(1, 3);
        grafinho.addAresta(2, 1);        
        grafinho.addAresta(2, 3);
        grafinho.addAresta(3, 2);
        grafinho.addAresta(4, 1);
        grafinho.addAresta(4, 1);
        grafinho.addAresta(3, 1);
        grafinho.addAresta(4, 1);
        grafinho.addAresta(4, 3);
        
        grafinho.printAdjList();
        System.out.println(" ");
        grafinho.printMatrizAdj();
    }
    
}