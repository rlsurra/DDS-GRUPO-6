package ar.edu.utn.frba.dds;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidacionPrendaMaterial {

    //private Map<Pair<Material,TipoPrenda>,Boolean> mapaValidacion = new HashMap<Pair<Material,TipoPrenda>,Boolean>();
    //private Boolean[][] matrizDeValidacion;
    private List<Pair<Material,TipoPrenda>> listaValidacion = new ArrayList<Pair<Material,TipoPrenda>>();

    public ValidacionPrendaMaterial(){
        insertarValidacion(Material.ALGODON,TipoPrenda.REMERA_CORTA);
        //TODO COMPLETAR LISTA
    }

    private void insertarValidacion(Material m,TipoPrenda t){
        this.listaValidacion.add(new Pair<Material,TipoPrenda>(m,t));
    }

    public boolean validarPrenda(Material material, TipoPrenda tipoPrenda){
        Pair<Material,TipoPrenda> parMaterialTipoPrenda = new Pair<Material,TipoPrenda>(material,tipoPrenda);
        return listaValidacion.contains(parMaterialTipoPrenda);
        //return listaValidacion.stream().anyMatch(objects -> objects.equals(parMaterialTipoPrenda));
    }

    public List<Pair<Material, TipoPrenda>> getListaValidacion() {
        return listaValidacion;
    }

    public void setListaValidacion(List<Pair<Material, TipoPrenda>> listaValidacion) {
        this.listaValidacion = listaValidacion;
    }

    /*public Boolean validar(TipoPrenda tipoPrenda, Material material){
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
        insertarValidacion(Material.ALGODON,TipoPrenda.REMERA_CORTA,true);



    }*/

}
