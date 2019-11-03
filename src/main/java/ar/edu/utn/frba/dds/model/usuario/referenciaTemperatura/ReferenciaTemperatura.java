package ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura;

import ar.edu.utn.frba.dds.persistence.Entidad;

import javax.persistence.*;

@Entity
@Inheritance
@DiscriminatorColumn(name = "TIPO")
public abstract class ReferenciaTemperatura extends Entidad {

    @Column
    private double minimo;

    @Column
    private double maximo;


    public double getMinimo() {
        return minimo;
    }

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
