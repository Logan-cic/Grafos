import java.util.ArrayList;

public class Vertice<TIPO> {
    private String dado;
    private ArrayList<Aresta<TIPO>> arestasEntrada;
    private ArrayList<Aresta<TIPO>> arestasSaida;
    private String cor;
    private Vertice<TIPO> antecessor;
    private int tempoDeDescoberta;
    private int termino;
    private String rotulo;

    public Vertice(String dado){
        this.dado = dado;
        this.arestasEntrada = new ArrayList<Aresta<TIPO>>();
        this.arestasSaida = new ArrayList<Aresta<TIPO>>();
        this.cor = "BRANCO";
        this.antecessor = null;
        this.tempoDeDescoberta = -1;
        this.termino = -1;
    }
    
    public String getDado() {
        return dado;
    }

    public void setDado(String dado) {
        this.dado = dado;
    }

    public ArrayList<Aresta<TIPO>> getArestasEntrada() {
        return arestasEntrada;
    }

    public void setArestasEntrada(ArrayList<Aresta<TIPO>> arestasEntrada) {
        this.arestasEntrada = arestasEntrada;
    }

    public ArrayList<Aresta<TIPO>> getArestasSaida() {
        return arestasSaida;
    }

    public void setArestasSaida(ArrayList<Aresta<TIPO>> arestasSaida) {
        this.arestasSaida = arestasSaida;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Vertice<TIPO> getAntecessor() {
        return antecessor;
    }

    public void setAntecessor(Vertice<TIPO> u) {
        this.antecessor = u;
    }

    public int getTempoDeDescoberta() {
        return tempoDeDescoberta;
    }

    public void setTempoDeDescoberta(int tempoDeDescoberta) {
        this.tempoDeDescoberta = tempoDeDescoberta;
    }

    public int getTermino() {
        return termino;
    }

    public void setTermino(int termino) {
        this.termino = termino;
    }

    public void addArestaEntrada(Aresta<TIPO> aresta){
        this.arestasEntrada.add(aresta);
    }

    public void addArestaSaida(Aresta<TIPO> aresta){
        this.arestasSaida.add(aresta);
    }

    public String toString(){
        return this.dado;
    }


}