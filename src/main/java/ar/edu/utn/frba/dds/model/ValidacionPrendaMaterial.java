package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.model.prenda.TipoPrendaOLD;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

public class ValidacionPrendaMaterial {

    //private Map<Pair<Material,TipoPrendaOLD>,Boolean> mapaValidacion = new HashMap<Pair<Material,TipoPrendaOLD>,Boolean>();
    //private Boolean[][] matrizDeValidacion;
    private List<Pair<Material, TipoPrendaOLD>> listaValidacion = new ArrayList<Pair<Material, TipoPrendaOLD>>();

    public ValidacionPrendaMaterial(){
        insertarValidacion(Material.ALGODON, TipoPrendaOLD.REMERA_CORTA);
        //TODO COMPLETAR LISTA
    }

    private void insertarValidacion(Material m, TipoPrendaOLD t){
        this.listaValidacion.add(new Pair<Material, TipoPrendaOLD>(m,t));
    }

    public boolean validarPrenda(Material material, TipoPrendaOLD tipoPrenda){
        Pair<Material, TipoPrendaOLD> parMaterialTipoPrenda = new Pair<Material, TipoPrendaOLD>(material,tipoPrenda);
        return listaValidacion.contains(parMaterialTipoPrenda);
        //return listaValidacion.stream().anyMatch(objects -> objects.equals(parMaterialTipoPrenda));
    }

    public List<Pair<Material, TipoPrendaOLD>> getListaValidacion() {
        return listaValidacion;
    }

    public void setListaValidacion(List<Pair<Material, TipoPrendaOLD>> listaValidacion) {
        this.listaValidacion = listaValidacion;
    }

    /*public Boolean validar(TipoPrendaOLD tipoPrenda, Material material){
        return this.matrizDeValidacion[tipoPrenda.ordinal()][material.ordinal()];
    }

    private void completarMatriz(){
        this.matrizDeValidacion[0][0] = true; // REMERA_CORTA ; ALGODON
        this.matrizDeValidacion[0][1] = true; // REMERA_CORTA ; NYLON
        this.matrizDeValidacion[0][2] = false; // REMERA_CORTA ; CUERO
        this.matrizDeValidacion[1][0] = true; // REMERA_LARGA ; ALGODON
        this.matrizDeValidacion[1][1] = true; // REMERA_LARGA ; NYLON
        this.matrizDeValidacion[1][2] = false; // REMERA_LARGA ; CUERO
    }

    public ValidacionPrendaMaterial(){
        insertarValidacion(Material.ALGODON,TipoPrendaOLD.REMERA_CORTA,true);



    }*/

}
