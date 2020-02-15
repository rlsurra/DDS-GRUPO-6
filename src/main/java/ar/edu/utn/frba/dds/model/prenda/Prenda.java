package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.persistence.Entidad;
import ar.edu.utn.frba.dds.exceptions.ColorPrimarioIgualAlSecundarioException;
import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import ar.edu.utn.frba.dds.exceptions.PrendaNoValidaException;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.categoria.Categoria;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.rest.DTOs.PrendaDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity(name = "prenda")
@Table
public class Prenda extends Entidad {

    public Prenda() {
    }

    @ManyToOne(cascade = CascadeType.ALL)
    private TipoPrenda tipoPrenda;

    @OneToOne
    private Material material;

    @Column
    private String colorPrimario;

    @Column
    private String colorSecundario;

    @Column
    private String imagenPrenda;

    @ManyToOne
    @JsonIgnoreProperties({"prendas", "propietario"})
    private Guardarropa guardarropaActual;

    @OneToMany(
            mappedBy = "prenda",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private java.util.List<PuntajePrenda> puntajes = new  java.util.ArrayList<>();


    public Prenda(String nombre, TipoPrenda tipoPrenda, Material material, String colorPrimario) {
        this(nombre, tipoPrenda, material, colorPrimario, null);
    }

    public Prenda(TipoPrenda tipoPrenda, Material material, String colorPrimario, String colorSecundario) {
        validarParametrosInvalidos(tipoPrenda, material, colorPrimario);
        validarPrendaMaterial(tipoPrenda, material);
        validarColores(colorPrimario, colorSecundario);
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
    }

    public Prenda(String nombre, TipoPrenda tipoPrenda, Material material, String colorPrimario, String colorSecundario) {
        validarParametrosInvalidos(tipoPrenda, material, colorPrimario);
        validarPrendaMaterial(tipoPrenda, material);
        validarColores(colorPrimario, colorSecundario);
        this.nombre = nombre;
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
    }

    /*
    GETTERS
     */

    public Material getMaterial() {
        return material;
    }

    public String getColorPrimario() {
        return colorPrimario;
    }

    public String getColorSecundario() {
        return colorSecundario;
    }

    public TipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }

    public Categoria getCategoria() {
        return tipoPrenda.getCategoria();
    }

    public String getImagenPrenda() {
        return imagenPrenda;
    }

    @JsonIgnoreProperties({"prendas", "propietario"})
    public Guardarropa getGuardarropaActual() {
        return guardarropaActual;
    }

	/*
    SETTERS
     */

    public void setTipoPrenda(TipoPrenda tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setColorPrimario(String colorPrimario) {
        this.colorPrimario = colorPrimario;
    }

    public void setColorSecundario(String colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    @JsonIgnoreProperties({"prendas", "propietario"})
    public void setGuardarropaActual(Guardarropa guardarropa) {
        this.guardarropaActual = guardarropa;
    }

    /*
    METODOS
     */

    public void setImagenPrenda(String pathFile) {
        File archivo = new File(pathFile);
        try {
            BufferedImage imagenOriginal = ImageIO.read(archivo);
            BufferedImage imagenFormateada = formatearImagen(imagenOriginal, 500, 500);
            String pathArchivo = "/home/dds/TP/repo/DDS-GRUPO-6/images/" + tipoPrenda.getClass().getSimpleName()
                    + material + ".jpg";
            ImageIO.write(imagenFormateada, "jpg", new File(pathArchivo));
            this.imagenPrenda = pathArchivo;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void validarPrendaMaterial(TipoPrenda tipoPrenda, Material material) {
        if (!ValidacionPrendaMaterial.validarPrenda(material, tipoPrenda)) {
            System.out.println("Prenda no valida");
            throw new PrendaNoValidaException("COMBINACION TIPO DE PRENDA / MATERIAL NO VALIDA !");
        }
    }

    protected void validarColores(String primario, String secundario) {
        if (primario.equals(secundario)) {
            throw new ColorPrimarioIgualAlSecundarioException("El color primario debe ser distinto al secundario");
        }
    }

    protected void validarParametrosInvalidos(TipoPrenda tipoPrenda, Material material, String primario) {
        if (tipoPrenda == null || tipoPrenda.getCategoria() == null || material == null || primario == null) {
            throw new ParametrosInvalidosException("Los parámetros no pueden ser vacíos");
        }
    }

    private static BufferedImage formatearImagen(BufferedImage img, int alt, int anch) {
        Image tmp = img.getScaledInstance(anch, alt, Image.SCALE_SMOOTH);
        //Tuve que poner este Type en vez de TYPE_INT_ARGB ya que tiraba error al guardar.
        BufferedImage resized = new BufferedImage(anch, alt, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "tipoPrenda=" + tipoPrenda.getClass().getSimpleName() +
                ", material=" + material +
                ", color primario =" + colorPrimario +
                ", color secundario =" + colorSecundario +
                '}' + System.getProperty("line.separator");
    }

    public java.util.List<PuntajePrenda> getPuntajes() {
        return puntajes;
    }

    public void setPuntaje(Usuario usuario, Double puntos) {
        List<PuntajePrenda> puntajeDelUsuario = this.puntajes.stream().filter(puntaje -> puntaje.getUsuario().equals(usuario)).collect(Collectors.toList());
        if (puntajeDelUsuario.isEmpty()) {
            PuntajePrenda nuevoPuntaje = new PuntajePrenda(usuario, this, puntos);
            this.puntajes.add(nuevoPuntaje);
            return;
        }
        PuntajePrenda puntajeActual = puntajeDelUsuario.get(0);
        puntajeActual.setPuntaje(puntos);
    }

    public double getPuntajeDeUsuario(Usuario usuario) {
        List<PuntajePrenda> collect = this.puntajes.stream().filter(puntaje -> puntaje.getUsuario().equals(usuario)).collect(Collectors.toList());
        if (collect.isEmpty()) {
            return (double) 0;
        }
        return collect.get(0).getPuntaje();
    }

    public PuntajePrenda getPuntajePrendaDelUsuario(Usuario usuario) {
        List<PuntajePrenda> collect = this.puntajes.stream().filter(puntaje -> puntaje.getUsuario().equals(usuario)).collect(Collectors.toList());
        if (collect.isEmpty()) {
            return null;
        }
        return collect.get(0);
    }

}
