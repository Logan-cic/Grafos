class Aresta<T> {
    private Vertice<T> inicio;
    private Vertice<T> fim;
    private int peso;

    public Aresta(Vertice<T> inicio, Vertice<T> fim, int peso) {
        this.inicio = inicio;
        this.fim = fim;
        this.peso = peso;
    }

    public Vertice<T> getInicio() {
        return inicio;
    }

    public Vertice<T> getFim() {
        return fim;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return inicio.getDado() + " -> " + fim.getDado() + ", Peso: " + peso;
    }
}