public class Main {
    
    public static void main(String[] args) {

        Grafo<String> g = new Grafo<String>();
        g.addVertice("a");
        g.addVertice("b");
        g.addVertice("c");
        g.addVertice("d");
        g.addVertice("e");


        g.addAresta("a", "b", 2);
        g.addAresta("a", "e", 3);

        g.addAresta("b", "c", 3);
        g.addAresta("b", "e", 4);

        g.addAresta("c", "d", 5);
        g.addAresta("d", "e", 3);

        g.addAresta("e", "b", 6);


        g.Dijkstra("a");
 
    }
    
}