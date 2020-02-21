package ar.edu.utn.frba.dds.model.guardarropa;

import ar.edu.utn.frba.dds.model.atuendo.Atuendo;
import ar.edu.utn.frba.dds.model.categoria.*;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoLigero;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoPesado;
import ar.edu.utn.frba.dds.model.clima.ClimaAPIsProxy;
import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.prenda.PrendaVacio;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Entidad;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Sets;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Guardarropa extends Entidad {

    public Guardarropa() {
    }

    public Guardarropa(Usuario propietario) {
        this.propietario = propietario;
    }

    @OneToMany(
            mappedBy = "guardarropaActual",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties(value = "guardarropaActual", allowSetters = true)
    private List<Prenda> prendas = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"guardarropas", "eventos", "tipoUsuario", "guardarropasAccedidos", "refTemperatura"})
    @JsonProperty(value = "propietario")
    private Usuario propietario;

    @ManyToMany(mappedBy = "guardarropasAccedidos", fetch = FetchType.LAZY)
    private List<Usuario> usuarios = new ArrayList<>();


    @JsonIgnoreProperties({"guardarropas", "eventos", "tipoUsuario", "guardarropasAccedidos", "refTemperatura"})
    public Usuario getPropietario() {
        return propietario;
    }

    @JsonIgnore
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @JsonIgnoreProperties(value = "guardarropaActual", allowSetters = true)
    public List<Prenda> getPrendas() {
        return prendas;
    }

    @JsonIgnoreProperties(value = "guardarropaActual", allowSetters = true)
    public void setPrendas(List<Prenda> prendas) {
        prendas.forEach(prenda -> {
            prenda.setGuardarropaActual(this);
        });
        this.prendas = prendas;
    }

    @JsonIgnoreProperties({"guardarropas", "eventos", "tipoUsuario", "guardarropasAccedidos", "refTemperatura"})
    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    /*
    metodos
     */

    public List<Atuendo> generarSugerencias(Usuario usuario, Evento evento) {
        List<Atuendo> atuendosPosibles = generarSugerenciasPosibles();
        System.out.println("Se generaron " + atuendosPosibles.size() + " atuendos posibles");
        System.out.println("Niveles de calor de atuendos: " + atuendosPosibles.stream().map(Atuendo::getNivelDeCalor).collect(Collectors.toList()));

        List<Atuendo> sugerenciasPorNivelCalor = filtrarSugerenciasPorNivelCalor(usuario, evento, atuendosPosibles);
        System.out.println("Sugerencias restantes luego de filtrar por Nivel de Calor: " + sugerenciasPorNivelCalor.size());

        return ordenarSugerenciasPorPuntaje(sugerenciasPorNivelCalor, usuario);
    }

    public List<Atuendo> generarSugerenciasPosibles() {
        List<Prenda> prendasSuperiores = new ArrayList<>();
        List<Prenda> prendasAbrigoLigero = new ArrayList<>();
        List<Prenda> prendasAbrigoPesado = new ArrayList<>();
        List<Prenda> prendasInferiores = new ArrayList<>();
        List<Prenda> prendasCalzado = new ArrayList<>();
        List<Prenda> prendasAccesorio = new ArrayList<>();

        prendasAbrigoLigero.add(new PrendaVacio(CategoriaSuperior.getInstance()));
        prendasAbrigoPesado.add(new PrendaVacio(CategoriaSuperior.getInstance()));
        prendasAccesorio.add(new PrendaVacio(CategoriaAccesorio.getInstance()));

        prendas.forEach(prenda -> {
            if (prenda.getCategoria().equals(CategoriaAccesorio.getInstance())) {
                prendasAccesorio.add(prenda);
            } else if (prenda.getCategoria().getId().equals(CategoriaSuperiorAbrigoLigero.getInstance().getId())) {
                prendasAbrigoLigero.add(prenda);
            } else if (prenda.getCategoria().getId().equals(CategoriaSuperiorAbrigoPesado.getInstance().getId())) {
                prendasAbrigoPesado.add(prenda);
            } else if (prenda.getCategoria().getId().equals(CategoriaInferior.getInstance().getId())) {
                prendasInferiores.add(prenda);
            } else if (prenda.getCategoria().getId().equals(CategoriaCalzado.getInstance().getId())) {
                prendasCalzado.add(prenda);
            } else if (prenda.getCategoria().getId().equals(CategoriaSuperior.getInstance().getId())) {
                prendasSuperiores.add(prenda);
            }
        });

        return
                Sets.cartesianProduct(Sets.newHashSet(prendasSuperiores), Sets.newHashSet(prendasInferiores),
                        Sets.newHashSet(prendasCalzado), Sets.newHashSet(prendasAccesorio),
                        Sets.newHashSet(prendasAbrigoLigero), Sets.newHashSet(prendasAbrigoPesado))
                        .stream()
                        .map(list -> new Atuendo(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)))
                        .collect(Collectors.toList());
    }

    public List<Atuendo> filtrarSugerenciasPorNivelCalor(Usuario usuario, Evento evento, List<Atuendo> atuendosPosibles) {
        ClimaAPIsProxy proxy = new ClimaAPIsProxy();
        Float temp = proxy.getTemperatura(evento.getCiudad());
        System.out.println("Temperatura: " + temp);

        return atuendosPosibles.stream()
                .filter(x -> x.getNivelDeCalor() + temp < usuario.getRefTemperatura().getMaximo() &&
                        x.getNivelDeCalor() + temp > usuario.getRefTemperatura().getMinimo())
                .collect(Collectors.toList());
    }

    public List<Atuendo> ordenarSugerenciasPorPuntaje(List<Atuendo> sugerencias, Usuario usuario) {
        sugerencias.sort(Comparator.comparingDouble(atuendo -> atuendo.getPuntaje(usuario)));
        return sugerencias;
    }

    @Override
    public String toString() {
        return "Guardarropa{" +
                "prendas=" + prendas +
                '}';
    }

}
