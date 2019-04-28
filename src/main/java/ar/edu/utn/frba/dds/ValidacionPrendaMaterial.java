package ar.edu.utn.frba.dds;

public class ValidacionPrendaMaterial {

    private Boolean[][] matrizDeValidacion;

    public ValidacionPrendaMaterial(){
        int cantidadDeMateriales = Material.values().length;
        int cantidadDeTiposDePrenda = TipoPrenda.values().length;
        this.matrizDeValidacion = new Boolean[cantidadDeTiposDePrenda][cantidadDeMateriales];
        completarMatriz();
    }

    public Boolean validar(TipoPrenda tipoPrenda, Material material){
        return this.matrizDeValidacion[tipoPrenda.ordinal()][material.ordinal()];
    }

    private void completarMatriz(){
        this.matrizDeValidacion[0][0] = true; // REMERA_CORTA ; ALGODON
        this.matrizDeValidacion[0][1] = true; // REMERA_CORTA ; NYLON
        this.matrizDeValidacion[0][2] = false; // REMERA_CORTA ; CUERO
        this.matrizDeValidacion[1][0] = true; // REMERA_LARGA ; ALGODON
        this.matrizDeValidacion[1][1] = true; // REMERA_LARGA ; NYLON
        this.matrizDeValidacion[1][2] = false; // REMERA_LARGA ; CUERO
        // TODO completar
    }

    public Boolean[][] getMatrizDeValidacion() {
        return matrizDeValidacion;
    }
}
