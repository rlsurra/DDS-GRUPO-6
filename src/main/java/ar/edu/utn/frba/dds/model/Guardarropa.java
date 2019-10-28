package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.model.categoria.CategoriaCalzado;
import ar.edu.utn.frba.dds.model.categoria.CategoriaInferior;
import ar.edu.utn.frba.dds.model.categoria.CategoriaSuperior;
import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.model.prenda.PrendaVacio;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import com.google.common.collect.Sets;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static ar.edu.utn.frba.dds.model.categoria.CategoriaAccesorio.CATEGORIA_ACCESORIO;
import static ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoLigero.CATEGORIA_SUPERIOR_ABRIGO_LIGERO;
import static ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoPesado.CATEGORIA_SUPERIOR_ABRIGO_PESADO;

@Entity
public class Guardarropa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(
            mappedBy = "guardarropaActual",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Prenda> prendas;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Usuario propietario;

    @ManyToMany(mappedBy = "guardarropasAccedidos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Usuario> usuarios = new ArrayList<>();

    public Guardarropa(Usuario propietario) {
        this.propietario = propietario;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public Guardarropa() {
    }

    public List<Prenda> getPrendas() {
        return prendas;
    }

    public void setPrendas(List<Prenda> prendas) {
        this.prendas = prendas;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    /*
    metodos
     */

    public List<Atuendo> generarSugerencias(Usuario usuario, Evento evento) {
        List<Atuendo> atuendosPosibles = generarSugerenciasPosibles();
        System.out.println("Se generaron " + atuendosPosibles.size() + " atuendos");
        System.out.println("Niveles de calor de atuendos: " + atuendosPosibles.stream().map(Atuendo::getNivelDeCalor).collect(Collectors.toList()));
        return ordenarSugerenciasPorPuntaje(filtrarSugerenciasPorNivelCalor(usuario, evento, atuendosPosibles), usuario);
    }

    public List<Atuendo> generarSugerenciasPosibles() {
        List<Prenda> prendasSuperiores = new ArrayList<>();
        List<Prenda> prendasAbrigoLigero = new ArrayList<>();
        List<Prenda> prendasAbrigoPesado = new ArrayList<>();
        List<Prenda> prendasInferiores = new ArrayList<>();
        List<Prenda> prendasCalzado = new ArrayList<>();
        List<Prenda> prendasAccesorio = new ArrayList<>();

        prendasAbrigoLigero.add(new PrendaVacio(CATEGORIA_SUPERIOR_ABRIGO_LIGERO));
        prendasAbrigoPesado.add(new PrendaVacio(CATEGORIA_SUPERIOR_ABRIGO_PESADO));
        prendasAccesorio.add(new PrendaVacio(CATEGORIA_ACCESORIO));

        prendas.forEach(prenda -> {
            if (prenda.getCategoria().equals(CATEGORIA_ACCESORIO)) {
                prendasAccesorio.add(prenda);
            } else if (prenda.getCategoria().equals(CATEGORIA_SUPERIOR_ABRIGO_LIGERO)) {
                prendasAbrigoLigero.add(prenda);
            } else if (prenda.getCategoria().equals(CATEGORIA_SUPERIOR_ABRIGO_PESADO)) {
                prendasAbrigoPesado.add(prenda);
            } else if (prenda.getCategoria().equals(new CategoriaInferior())) {
                prendasInferiores.add(prenda);
            } else if (prenda.getCategoria().equals(new CategoriaCalzado())) {
                prendasCalzado.add(prenda);
            } else if (prenda.getCategoria().equals(new CategoriaSuperior())) {
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

}
