package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.model.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GrupoUsuario {

    String nombre;
    List<Usuario> usuarios = new ArrayList<>();

    public GrupoUsuario(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Setea los usuarios como miembros del grupo, ademas setea el grupo de cada usuario con este grupo.
     * Si el usuario ya tiene un grupo se pisa por el actual
     * @param usuarios
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        usuarios.forEach(usuario -> usuario.setGrupo(this));
    }

    public List<Guardarropa> getGuardarropaGrupo(){

        List<List<Guardarropa>> listasDeGuardarropas = usuarios.stream().map(x -> x.getGuardarropas()).collect(Collectors.toList());
        List<Guardarropa> guardarropas = listasDeGuardarropas.stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());

        return guardarropas;
    }



}
