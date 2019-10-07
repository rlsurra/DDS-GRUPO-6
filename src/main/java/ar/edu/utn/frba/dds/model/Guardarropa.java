package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.model.prenda.PrendaVacio;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static ar.edu.utn.frba.dds.model.categoria.CategoriaAccesorio.CATEGORIA_ACCESORIO;
import static ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoLigero.CATEGORIA_SUPERIOR_ABRIGO_LIGERO;
import static ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoPesado.CATEGORIA_SUPERIOR_ABRIGO_PESADO;

public class Guardarropa {

    private List<Prenda> prendasSuperiores = new ArrayList<>();
    private List<Prenda> prendasAbrigoLigero = Arrays.asList(new PrendaVacio(CATEGORIA_SUPERIOR_ABRIGO_LIGERO));
    private List<Prenda> prendasAbrigoPesado = Arrays.asList(new PrendaVacio(CATEGORIA_SUPERIOR_ABRIGO_PESADO));
    private List<Prenda> prendasInferiores = new ArrayList<>();
    private List<Prenda> prendasCalzado = new ArrayList<>();
    private List<Prenda> prendasAccesorio = Arrays.asList(new PrendaVacio(CATEGORIA_ACCESORIO));
    private Usuario propietario;

    public Guardarropa(Usuario propietario) {
        this.propietario = propietario;
    }

    /*
            getters
             */
    public List<Prenda> getPrendasSuperiores() {
        return prendasSuperiores;
    }

    public List<Prenda> getPrendasInferiores() {
        return prendasInferiores;
    }

    public List<Prenda> getPrendasCalzado() {
        return prendasCalzado;
    }

    public List<Prenda> getPrendasAccesorio() {
        return prendasAccesorio;
    }

    public List<Prenda> getPrendasAbrigoLigero() { return prendasAbrigoLigero; }

    public List<Prenda> getPrendasAbrigoPesado() { return prendasAbrigoPesado; }

    public Usuario getPropietario() {
        return propietario;
    }

    /*
    setters
    */

    public void setPrendasSuperiores(List<Prenda> prendasSuperiores) {
        this.prendasSuperiores = prendasSuperiores;
    }

    public void setPrendasInferiores(List<Prenda> prendasInferiores) {
        this.prendasInferiores = prendasInferiores;
    }

    public void setPrendasCalzado(List<Prenda> prendasCalzado) {
        this.prendasCalzado = prendasCalzado;
    }

        // Accesorio, abrigo ligero y abrigo pesado tienen q tener la posibilidad de no estar en un atuendo, por eso se agrega a la lista una prenda vacia
    public void setPrendasAccesorio(List<Prenda> prendasAccesorio) {
        this.prendasAccesorio = new ArrayList<>();
        this.prendasAccesorio.addAll(prendasAccesorio);
        this.prendasAccesorio.add(new PrendaVacio(CATEGORIA_ACCESORIO));
    }

    public void setPrendasAbrigoLigero(List<Prenda> prendasAbrigoLigero) {
        this.prendasAbrigoLigero = new ArrayList<>();
        this.prendasAbrigoLigero.addAll(prendasAbrigoLigero);
        this.prendasAbrigoLigero.add(new PrendaVacio(CATEGORIA_SUPERIOR_ABRIGO_LIGERO));
    }

    public void setPrendasAbrigoPesado(List<Prenda> prendasAbrigoPesado) {
        this.prendasAbrigoPesado = new ArrayList<>();
        this.prendasAbrigoPesado.addAll(prendasAbrigoPesado);
        this.prendasAbrigoPesado.add(new PrendaVacio(CATEGORIA_SUPERIOR_ABRIGO_PESADO));
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }


    /*
    metodos
     */

    public List<Atuendo> generarSugerencias(Usuario usuario, Evento evento){
        List<Atuendo> atuendosPosibles = generarSugerenciasPosibles();
        System.out.println("Se generaron " + atuendosPosibles.size() + " atuendos");
        System.out.println("Niveles de calor de atuendos: " + atuendosPosibles.stream().map(Atuendo::getNivelDeCalor).collect(Collectors.toList()));
        return ordenarSugerenciasPorPuntaje(
                filtrarSugerenciasPorNivelCalor(usuario, evento, atuendosPosibles)
        );
    }

    public List<Atuendo> generarSugerenciasPosibles(){
    return
       Sets.cartesianProduct(Sets.newHashSet(prendasSuperiores), Sets.newHashSet(prendasInferiores),
                Sets.newHashSet(prendasCalzado), Sets.newHashSet(prendasAccesorio),
               Sets.newHashSet(prendasAbrigoLigero), Sets.newHashSet(prendasAbrigoPesado))
                .stream()
                .map(list -> new Atuendo(list.get(0), list.get(1), list.get(2), list.get(3),list.get(4),list.get(5)))
                .collect(Collectors.toList());
    }

    public List<Atuendo> filtrarSugerenciasPorNivelCalor(Usuario usuario, Evento evento, List<Atuendo> atuendosPosibles){
        ClimaAPIsProxy proxy = new ClimaAPIsProxy();
        Float temp = proxy.getTemperatura(evento.getCiudad());
        System.out.println("Temperatura: " + temp);

        return atuendosPosibles.stream()
                .filter(x -> x.getNivelDeCalor() + temp < usuario.getRefTemperatura().getMaximo() &&
                        x.getNivelDeCalor() + temp > usuario.getRefTemperatura().getMinimo())
                .collect(Collectors.toList());
    }

    public List<Atuendo> ordenarSugerenciasPorPuntaje(List<Atuendo> sugerencias){
        sugerencias.sort(Comparator.comparingDouble(Atuendo::getPuntaje));
        return sugerencias;
    }

    @Override
    public String toString() {
        return "Guardarropa{" +
                "prendasSuperiores=" + prendasSuperiores +
                ", prendasAbrigoLigero=" + prendasAbrigoLigero +
                ", prendasAbrigoPesado=" + prendasAbrigoPesado +
                ", prendasInferiores=" + prendasInferiores +
                ", prendasCalzado=" + prendasCalzado +
                ", prendasAccesorio=" + prendasAccesorio +
                '}';
    }
}
