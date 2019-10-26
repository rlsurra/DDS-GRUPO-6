package ar.edu.utn.frba.dds.model.usuario;

import ar.edu.utn.frba.dds.exceptions.MaximaCantidadPrendasException;
import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import ar.edu.utn.frba.dds.model.GrupoUsuario;
import ar.edu.utn.frba.dds.model.Guardarropa;
import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.ReferenciaTemperatura;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany(
            mappedBy = "propietario",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Guardarropa> guardarropas = new ArrayList<>();

    @OneToMany(
            mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Evento> eventos = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private TipoUsuario tipoUsuario;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private GrupoUsuario grupo;

    @OneToOne(targetEntity = ReferenciaTemperatura.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "refTemperatura_id", referencedColumnName = "id")
    private ReferenciaTemperatura refTemperatura;

    public Usuario() {
    }

    public Usuario(TipoUsuario tipoUsuario, ReferenciaTemperatura refTemperatura) {
        if (tipoUsuario == null) {
            throw new ParametrosInvalidosException("No se permite un usuario sin tipo");
        }
        this.tipoUsuario = tipoUsuario;
        this.refTemperatura = refTemperatura;
    }

    /*
    getters
     */
    public List<Guardarropa> getGuardarropas() {
        return guardarropas;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public GrupoUsuario getGrupo() {
        return grupo;
    }

    public ReferenciaTemperatura getRefTemperatura() {
        return refTemperatura;
    }

    /*
    setters
     */

    public void setGuardarropas(List<Guardarropa> guardarropas) {
        this.guardarropas = guardarropas;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public void setRefTemperatura(ReferenciaTemperatura refTemperatura) {
        this.refTemperatura = refTemperatura;
    }

    public void setGrupo(GrupoUsuario grupo) {
        this.grupo = grupo;
    }

    /*
    metodos
     */

    public void agregarGuardarropa(Guardarropa guardarropa) {
        if (guardarropa == null) {
            throw new ParametrosInvalidosException("No se permite agregar guardarropa nulo");
        }
        if (!tipoUsuario.validarCantidadMaxima(guardarropa)) {
            throw new MaximaCantidadPrendasException();
        }
        guardarropas.add(guardarropa);
    }

    public void agregarEvento(Evento evento) {
        if (evento == null) {
            throw new ParametrosInvalidosException("No se permite agregar un evento nulo");
        }
        if (this.eventos == null) {
            this.eventos = new ArrayList<>();
        }
        this.eventos.add(evento);
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "guardarropas=" + guardarropas +
                ", eventos=" + eventos +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
