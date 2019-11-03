package ar.edu.utn.frba.dds.model.empleado;

import ar.edu.utn.frba.dds.persistence.Entidad;

import javax.persistence.*;

@Entity
@Table(name = "EMPLEADO")
public class Empleado extends Entidad {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGO")
    private Long codigo;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "FECHANAC")
    private int fechanac;

    public Empleado() {
    }

    public Empleado(Long codigo, String apellido, String nombre, int fechanac) {
        this.codigo = codigo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechanac = fechanac;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigo=" + codigo +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechanac=" + fechanac +
                '}';
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechanac() {
        return fechanac;
    }

    public void setFechanac(int fechanac) {
        this.fechanac = fechanac;
    }
}