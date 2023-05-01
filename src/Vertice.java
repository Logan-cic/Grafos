import java.util.ArrayList;

public class Vertice<TIPO> {
    private String dado;
    private ArrayList<Aresta<TIPO>> arestasEntrada;
    private ArrayList<Aresta<TIPO>> arestasSaida;
    
    public Vertice(String string){
        this.dado = string;
        this.arestasEntrada = new ArrayList<Aresta<TIPO>>();
        this.arestasSaida = new ArrayList<Aresta<TIPO>>();
    }

    public String getDado() {
        return dado;
    }

    public void setDado(TIPO dado) {
        this.dado = (String) dado;
    }
    
    public void addArestaEntrada(Aresta<TIPO> aresta){
        this.arestasEntrada.add(aresta);
    }
    
    public void addArestaSaida(Aresta<TIPO> aresta){
        this.arestasSaida.add(aresta);
    }

    public ArrayList<Aresta<TIPO>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<TIPO>> getArestasSaida() {
        return arestasSaida;
    }

}