package ar.edu.utn.frba.dds.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GeneradorDeAtuendos {

    //TODO: En un futuro se le va a poder pasar algun atuendo a generar para que sepa como hacerlo,
    // por ahora lo hacemos siempre igual

    private static GeneradorDeAtuendos INSTANCE = null;

    private GeneradorDeAtuendos() {
    }

    public static GeneradorDeAtuendos getInstance(){
        if(INSTANCE == null){
            INSTANCE = new GeneradorDeAtuendos();
        }
        return INSTANCE;
    }


    public List<Atuendo> generarAtuendos(List<Prenda> prendas){

        List<Atuendo> atuendos = new ArrayList<>();

        List<Prenda> prendasSuperiores = prendas.stream().
                filter(prenda -> prenda.getCategoria().equals(Categoria.SUPERIOR)).collect(Collectors.toList());
        List<Prenda> prendasInferiores = prendas.stream().
                filter(prenda -> prenda.getCategoria().equals(Categoria.INFERIOR)).collect(Collectors.toList());
        List<Prenda> prendasCalzado = prendas.stream().
                filter(prenda -> prenda.getCategoria().equals(Categoria.CALZADO)).collect(Collectors.toList());
        List<Prenda> prendasAccesorio = prendas.stream().
                filter(prenda -> prenda.getCategoria().equals(Categoria.ACCESORIO)).collect(Collectors.toList());


        boolean posibilidades = true;

        while (posibilidades){

            for (Prenda prendaSuperior: prendasSuperiores) {
                for (Prenda prendaInferior: prendasInferiores) {
                    for (Prenda prendaCalzado: prendasCalzado) {
                        for (Prenda prendaAccesorio: prendasAccesorio) {
                            Atuendo atuendo = Atuendo.builder()
                                    .prendaSuperior(prendaSuperior)
                                    .prendaInferior(prendaInferior)
                                    .prendaCalzado(prendaCalzado)
                                    .prendaAccesorio(prendaAccesorio).build();
                            atuendos.add(atuendo);
                        }
                        Atuendo atuendo = Atuendo.builder()
                                .prendaSuperior(prendaSuperior)
                                .prendaInferior(prendaInferior)
                                .prendaCalzado(prendaCalzado).build();
                        atuendos.add(atuendo);
                    }
                }
            }
            posibilidades=false;
        }


        return atuendos;




    }


}
