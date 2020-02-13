package ar.edu.utn.frba.dds.rest.DTOs;

public class PrendaDTO {

    private Integer tipoPrendaID;
    private Integer materialId;
    private String colorPrincipal;
    private String colorSecundario;
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

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(String colorSecundario) {
        this.colorSecundario = colorSecundario;
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
