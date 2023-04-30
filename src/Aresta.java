

public class Aresta<Object> {
    private Vertice<Object> inicio;
    private Vertice<Object> fim;
    
    public Aresta(Vertice<Object> inicio, Vertice<Object> fim){
        this.inicio = inicio;
        this.fim = fim;
    }

    public Vertice<Object> getInicio() {
        return inicio;
    }

    public void setInicio(Vertice<Object> inicio) {
        this.inicio = inicio;
    }

    public Vertice<Object> getFim() {
        return fim;
    }

    public void setFim(Vertice<Object> fim) {
        this.fim = fim;
    }

}