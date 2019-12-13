package ar.edu.utn.frba.dds.rest.DTOs;

public class PrendaDTO {
    private Integer tipoPrendaID;
    private String colorPrincipal;
    private Integer guardarropaID;
    private String imagenUrl;
    private String nombrePrenda;

    public Integer getTipoPrendaID() {
        return tipoPrendaID;
    }

    public void setTipoPrendaID(Integer tipoPrendaID) {
        this.tipoPrendaID = tipoPrendaID;
    }

    public String getColorPrincipal() {
        return colorPrincipal;
    }

    public void setColorPrincipal(String colorPrincipal) {
        this.colorPrincipal = colorPrincipal;
    }

    public Integer getGuardarropaID() {
        return guardarropaID;
    }

    public void setGuardarropaID(Integer guardarropaID) {
        this.guardarropaID = guardarropaID;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getNombrePrenda() {
        return nombrePrenda;
    }

    public void setNombrePrenda(String nombrePrenda) {
        this.nombrePrenda = nombrePrenda;
    }
}
