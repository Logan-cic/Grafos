import java.util.ArrayList;

class Vertice<T> {
    private T dado;
    private ArrayList<Aresta<T>> arestasSaida;
    private ArrayList<Aresta<T>> arestasEntrada;
    private Vertice<T> antecessor;
    private int distancia;

    public Vertice(T dado) {
        this.dado = dado;
        this.arestasSaida = new ArrayList<>();
        this.arestasEntrada = new ArrayList<>();
        this.antecessor = null;
        this.distancia = Integer.MAX_VALUE;
    }

    public T getDado() {
        return dado;
    }

    public ArrayList<Aresta<T>> getArestasSaida() {
        return arestasSaida;
    }

    public ArrayList<Aresta<T>> getArestasEntrada() {
        return arestasEntrada;
    }

    public void addArestaSaida(Aresta<T> aresta) {
        arestasSaida.add(aresta);
    }

    public void addArestaEntrada(Aresta<T> aresta) {
        arestasEntrada.add(aresta);
    }

    public Vertice<T> getAntecessor() {
        return antecessor;
    }

    public void setAntecessor(Vertice<T> antecessor) {
        this.antecessor = antecessor;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
}