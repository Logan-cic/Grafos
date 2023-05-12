import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo<Object> {
    private ArrayList<Vertice<Object>> vertices;
    private ArrayList<Aresta<Object>> arestas;

    private ArrayList<ArrayList<Vertice<Object>>> adjList;
    private int[][] adjMatriz;
    int time = 0;

    
    public Grafo(){
        this.vertices = new ArrayList<Vertice<Object>>();
        this.arestas = new ArrayList<Aresta<Object>>();
        this.adjList = new ArrayList<ArrayList<Vertice<Object>>>();
        this.adjMatriz = new int[0][0];
    }
    
    
    public void addVertice(String string){
        Vertice<Object> novoVertice = new Vertice<Object>(string);
        this.vertices.add(novoVertice);
    
        int[][] novaMatrizadjMatriz = new int[this.vertices.size()][this.vertices.size()];
        for (int i = 0; i < this.adjMatriz.length; i++) {
            for (int j = 0; j < this.adjMatriz[0].length; j++) {
                novaMatrizadjMatriz[i][j] = this.adjMatriz[i][j];
            }
        }
        this.adjMatriz = novaMatrizadjMatriz;
    
        ArrayList<Vertice<Object>> newList = new ArrayList<Vertice<Object>>();
        this.adjList.add(newList);
    }
    
    
    public void addAresta(String string, String string2){
        Vertice<Object> inicio = this.getVertice(string);
        Vertice<Object> fim = this.getVertice(string2);
        Aresta<Object> aresta = new Aresta<Object>(inicio, fim);
        inicio.addArestaSaida(aresta);
        fim.addArestaEntrada(aresta);
        this.arestas.add(aresta);
    
        int i = this.vertices.indexOf(inicio);
        int j = this.vertices.indexOf(fim);
        this.adjMatriz[i][j] = 1;
    
        this.adjList.get(i).add(fim);
    }
    
    
    public Vertice<Object> getVertice(String string){
        Vertice<Object> vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(string)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }
    
    public void printAdjList(){
        for(int i=0; i<this.adjList.size(); i++){
            System.out.print("[" + this.vertices.get(i).getDado() + "]: ");
            for(int j=0; j<this.adjList.get(i).size(); j++){
                System.out.print(this.adjList.get(i).get(j).getDado() + " ");
            }
            System.out.println();
        }
    }
    
    public void printMatrizAdj(){
        System.out.print("  ");
        for(int i=0; i<this.vertices.size(); i++){
            System.out.print(this.vertices.get(i).getDado() + " ");
        }
        System.out.println();
        for(int i=0; i<this.adjMatriz.length; i++){
            System.out.print(this.vertices.get(i).getDado() + " ");
            for(int j=0; j<this.adjMatriz[0].length; j++){
                System.out.print(this.adjMatriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printArestasAdjacentes(String string) {
        ArrayList<Aresta<Object>> arestasAdjacentes = new ArrayList<Aresta<Object>>();
        Vertice<Object> vertice = this.getVertice(string);
        if (vertice != null) {
            for (Aresta<Object> aresta : this.arestas) {
                if (aresta.getInicio().equals(vertice) || aresta.getFim().equals(vertice)) {
                    arestasAdjacentes.add(aresta);
                }
            }
            System.out.println("Arestas adjacentes ao vértice " + string + ": ");
            for (Aresta<Object> aresta : arestasAdjacentes) {
                System.out.println(aresta.toString());
            }
        }
    }

    public void DFS() {
        for (Vertice<Object> u : vertices) {
            u.setCor("BRANCO");
            u.setAntecessor(null);
        }
        time = 0;
        for (Vertice<Object> u : vertices) {
            if (u.getCor().equals("BRANCO")) {
                DFS_VISIT(u);
            }
        }
    }
    
    private <TIPO> void DFS_VISIT(Vertice<Object> u) {
        u.setCor("CINZA");
        time++;
        u.setTempoDeDescoberta(time);
        for (Vertice<Object> v : adjList.get(vertices.indexOf(u))) {
            if (v.getCor().equals("BRANCO")) {
                v.setAntecessor(u);
                DFS_VISIT(v);
            }
        }
        u.setCor("PRETO");
        time++;
        u.setTermino(time);
    }
    

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertice<Object> v : vertices) {
            sb.append("Vertice: ").append(v.toString());
            sb.append("\nCor: ").append(v.getCor());
            sb.append("\nTempo de descoberta: ").append(v.getTempoDeDescoberta());
            sb.append("\ntérmino: ").append(v.getTermino());
            sb.append("\nAntecessor: ");
            if (v.getAntecessor() == null) {
                sb.append("null");
            } else {
                sb.append(v.getAntecessor().toString());
            }
            sb.append("\n\n");
        }
        return sb.toString();
    }


    public void BFS(String s) {
        for (Vertice<Object> u : vertices) {
            u.setCor("BRANCO");
            u.setAntecessor(null);
            u.setTempoDeDescoberta(Integer.MAX_VALUE);
        }
        Vertice<Object> inicio = this.getVertice(s);
        inicio.setCor("CINZA");
        inicio.setTempoDeDescoberta(0);
        inicio.setAntecessor(null);
        Queue<Vertice<Object>> fila = new LinkedList<Vertice<Object>>();
        fila.add(inicio);
        while (!fila.isEmpty()) {
            // System.out.println(fila);
            Vertice<Object> u = fila.poll();
            System.out.println(u);
            for (Vertice<Object> v : adjList.get(vertices.indexOf(u))) {
                if (v.getCor().equals("BRANCO")) {
                    // System.out.println(v + v.getCor());
                    v.setCor("CINZA");
                    v.setTempoDeDescoberta(u.getTempoDeDescoberta()+1);
                    v.setAntecessor(u);
                    fila.add(v);
                    // System.out.println(v + v.getCor());
                }
            }
            u.setCor("PRETO");
            System.out.println("vertice " + u + " ficou " + u.getCor());
            // System.out.println("vertice " + u + " o seu tempo de descorberta foi: " + u.getTempoDeDescoberta());
        }
    }
}