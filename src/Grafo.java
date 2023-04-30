import java.util.ArrayList;

public class Grafo<Object> {
    private ArrayList<Vertice<Object>> vertices;
    private ArrayList<Aresta<Object>> arestas;

    private ArrayList<ArrayList<Vertice<Object>>> adjList;
    private int[][] adjMatriz;

    
    public Grafo(){
        this.vertices = new ArrayList<Vertice<Object>>();
        this.arestas = new ArrayList<Aresta<Object>>();
        this.adjList = new ArrayList<ArrayList<Vertice<Object>>>();
        this.adjMatriz = new int[0][0];
    }
    
    
    public void addVertice(Object dado){
        Vertice<Object> novoVertice = new Vertice<Object>(dado);
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
    
    
    public void addAresta(Object dadoInicio, Object dadoFim){
        Vertice<Object> inicio = this.getVertice(dadoInicio);
        Vertice<Object> fim = this.getVertice(dadoFim);
        Aresta<Object> aresta = new Aresta<Object>(inicio, fim);
        inicio.addArestaSaida(aresta);
        fim.addArestaEntrada(aresta);
        this.arestas.add(aresta);
    
        int i = this.vertices.indexOf(inicio);
        int j = this.vertices.indexOf(fim);
        this.adjMatriz[i][j] = 1;
    
        this.adjList.get(i).add(fim);
    }
    
    
    public Vertice<Object> getVertice(Object dado){
        Vertice<Object> vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(dado)){
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
}