import java.util.ArrayList;

public class Vertice<Object> {
    private Object dado;
    private ArrayList<Aresta<Object>> arestasEntrada;
    private ArrayList<Aresta<Object>> arestasSaida;
    
    public Vertice(Object valor){
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Aresta<Object>>();
        this.arestasSaida = new ArrayList<Aresta<Object>>();
    }

    public Object getDado() {
        return dado;
    }

    public void setDado(Object dado) {
        this.dado = dado;
    }
    
    public void addArestaEntrada(Aresta<Object> aresta){
        this.arestasEntrada.add(aresta);
    }
    
    public void addArestaSaida(Aresta<Object> aresta){
        this.arestasSaida.add(aresta);
    }

    public ArrayList<Aresta<Object>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<Object>> getArestasSaida() {
        return arestasSaida;
    }
}