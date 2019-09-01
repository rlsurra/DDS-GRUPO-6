package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.model.usuario.Usuario;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

public class Guardarropa {

    private List<Prenda> prendasSuperiores = new ArrayList<>();
    private List<Prenda> prendasAbrigoLigero = new ArrayList<>();
    private List<Prenda> prendasAbrigoPesado = new ArrayList<>();
    private List<Prenda> prendasInferiores = new ArrayList<>();
    private List<Prenda> prendasCalzado = new ArrayList<>();
    private List<Prenda> prendasAccesorio = new ArrayList<>();

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

    public void setPrendasAccesorio(List<Prenda> prendasAccesorio) {
        this.prendasAccesorio = prendasAccesorio;
    }

    public void setPrendasAbrigoLigero(List<Prenda> prendasAbrigoLigero) { this.prendasAbrigoLigero = prendasAbrigoLigero; }

    public void setPrendasAbrigoPesado(List<Prenda> prendasAbrigoPesado) { this.prendasAbrigoPesado = prendasAbrigoPesado; }


    /*
    metodos
     */

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

        return atuendosPosibles.stream()
                .filter(x -> x.getNivelDeCalor() + temp < usuario.getRefTemperatura().getMaximo() &&
                        x.getNivelDeCalor() + temp > usuario.getRefTemperatura().getMinimo())
                .collect(Collectors.toList());
    }

    public List<Atuendo> ordenarSugerenciasPorPuntaje(List<Atuendo> sugerencias){
        sugerencias.sort(Comparator.comparingDouble(x -> x.getPuntaje()));
        return sugerencias;
    }

    public List<Atuendo> getSugerencia(Usuario usuario, Evento evento){
        List<Atuendo> posibilidades = generarSugerenciasPosibles();
        List<Atuendo> sugerencias = filtrarSugerenciasPorNivelCalor(usuario,evento,posibilidades);
        List<Atuendo> sugerenciasOrdenadas = ordenarSugerenciasPorPuntaje(sugerencias);
        return sugerenciasOrdenadas;
    }

    @Override
    public String toString() {
        return "Guardarropa{" +
                "prendasSuperiores=" + prendasSuperiores +
                ", prendasInferiores=" + prendasInferiores +
                ", prendasCalzado=" + prendasCalzado +
                ", prendasAccesorio=" + prendasAccesorio +
                '}';
    }
}
