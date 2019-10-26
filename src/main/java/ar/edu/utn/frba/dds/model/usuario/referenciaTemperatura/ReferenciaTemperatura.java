package ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura;

import javax.persistence.*;

@Entity
@Inheritance
@DiscriminatorColumn(name = "TIPO")
public abstract class ReferenciaTemperatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
