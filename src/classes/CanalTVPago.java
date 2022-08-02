package classes;

public class CanalTVPago extends Canal {
    
    private double mensalidade;

    public CanalTVPago(double mensalidade, String nomeDoCanal){
        super(nomeDoCanal);
        this.mensalidade = mensalidade;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }

    public String toString(){
        return "Nome do canal: " + getNomeDoCanal()
        +"\nMensalidade: " + getMensalidade();
    }

}
