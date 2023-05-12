public class Main {
    
    public static void main(String[] args) {

        Grafo<String> g = new Grafo<String>();

        g.addVertice("0");
        g.addVertice("1");
        g.addVertice("2");
        g.addVertice("3");
        g.addVertice("4");
        g.addVertice("5");
        g.addVertice("6");
        g.addVertice("7");
        g.addVertice("8");


        g.addAresta("0","1");
        g.addAresta("1","0");
        g.addAresta("1","2");
        g.addAresta("2","1");
        g.addAresta("4","1");
        g.addAresta("1","4");
        g.addAresta("2","3");
        g.addAresta("3","2");
        g.addAresta("3","4");
        g.addAresta("4","3");
        g.addAresta("4","5");
        g.addAresta("5","4");
        g.addAresta("4","6");
        g.addAresta("6","4");
        g.addAresta("6","7");
        g.addAresta("7","6");
        g.addAresta("6","8");
        g.addAresta("8","6");

        g.BFS("3");
        // g.printVerticesVisitados();
        // g.DFS();
        //System.out.println(g.toString());

        // System.out.println(" ");
        // g.printAdjList();
        // System.out.println(" ");
        // g.printMatrizAdj();

        // System.out.println(" ");
 
    }
    
}