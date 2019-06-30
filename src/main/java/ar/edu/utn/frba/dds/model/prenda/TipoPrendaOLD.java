package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.Categoria;

public enum TipoPrendaOLD {

    //TIPOS DE PRENDA PARA CATEGORIA SUPERIOR
    REMERA_CORTA(Categoria.SUPERIOR),
    REMERA_LARGA(Categoria.SUPERIOR),
    MUSCULOSA(Categoria.SUPERIOR),
    CAMISA_LARGA(Categoria.SUPERIOR),
    CAMISA_CORTA(Categoria.SUPERIOR),
    CHOMBA(Categoria.SUPERIOR),

    //TIPOS DE PRENDA PARA CATEGORIA INFERIOR
    JEAN(Categoria.INFERIOR),
    BERMUDA(Categoria.INFERIOR),
    TRAJE_DE_BANIO(Categoria.INFERIOR),
    SHORT(Categoria.INFERIOR),
    JOGGING(Categoria.INFERIOR),

    //TIPOS DE PRENDA PARA CATEGORIA CALZADO
    ZAPATILLA(Categoria.CALZADO),
    ZAPATO(Categoria.CALZADO),
    BOTIN(Categoria.CALZADO),
    BOTA(Categoria.CALZADO),
    OJOTA(Categoria.CALZADO),
    ALPARGATA(Categoria.CALZADO),


    //TIPOS DE PRENDA PARA CATEGORIA ACCESORIO
    RELOJ(Categoria.ACCESORIO),
    GORRA(Categoria.ACCESORIO),
    PULSERA(Categoria.ACCESORIO),
    ANTEOJO(Categoria.ACCESORIO);

    TipoPrendaOLD(Categoria categoria) {
        this.categoria = categoria;
    }

    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
