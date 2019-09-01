package ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura;

public abstract class ReferenciaTemperatura {

    private double minimo;
    private double maximo;

    public double getMinimo() { return minimo; }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public double getMaximo() {
        return maximo;
    }

    public void setMaximo(double maximo) {
        this.maximo = maximo;
    }
}
