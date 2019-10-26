package ar.edu.utn.frba.dds.model.usuario;

import ar.edu.utn.frba.dds.model.Guardarropa;

import javax.persistence.*;

@Entity
@Inheritance
@DiscriminatorColumn(name = "Usuario_Tipo")
public abstract class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public abstract boolean validarCantidadMaxima(Guardarropa guardarropa);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
