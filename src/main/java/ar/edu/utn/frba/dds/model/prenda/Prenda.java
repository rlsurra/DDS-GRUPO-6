package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.Persistible;
import ar.edu.utn.frba.dds.exceptions.ColorPrimarioIgualAlSecundarioException;
import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import ar.edu.utn.frba.dds.exceptions.PrendaNoValidaException;
import ar.edu.utn.frba.dds.model.Guardarropa;
import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.ValidacionPrendaMaterial;
import ar.edu.utn.frba.dds.model.categoria.Categoria;
import ar.edu.utn.frba.dds.model.prenda.ColorJpaConverter;
import ar.edu.utn.frba.dds.model.prenda.PuntajePrenda;
import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.usuario.Usuario;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


@Entity(name = "prenda")
@Table
public class Prenda extends Persistible {

    public Prenda() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private TipoPrenda tipoPrenda;

    @Column
    private Material material;
    @Column
    @Convert(converter = ColorJpaConverter.class)
    private Color colorPrimario;
    @Column
    @Convert(converter = ColorJpaConverter.class)
    private Color colorSecundario;
    @Column
    private String imagenPrenda;

    @ManyToOne(cascade = CascadeType.ALL)
    private Guardarropa guardarropaActual;

    @OneToMany(
            mappedBy = "prenda",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private java.util.List<PuntajePrenda> puntajes;


    public Prenda(TipoPrenda tipoPrenda, Material material, Color colorPrimario) {
        this(tipoPrenda, material, colorPrimario, null);
    }

    public Prenda(TipoPrenda tipoPrenda, Material material, Color colorPrimario, Color colorSecundario) {
        validarParametrosInvalidos(tipoPrenda, material, colorPrimario);
        validarPrendaMaterial(tipoPrenda, material);
        validarColores(colorPrimario, colorSecundario);
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
    }

    /*
    GETTERS
     */

    public Long getId() {
        return id;
    }

    public Material getMaterial() {
        return material;
    }

    public Color getColorPrimario() {
        return colorPrimario;
    }

    public Color getColorSecundario() {
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

    public Guardarropa getGuardarropaAcual() {
        return guardarropaActual;
    }

	/*
    SETTERS
     */

    public void setId(Long id) {
        this.id = id;
    }

    public void setTipoPrenda(TipoPrenda tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setColorPrimario(Color colorPrimario) {
        this.colorPrimario = colorPrimario;
    }

    public void setColorSecundario(Color colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public void setGuardarropaAcual(Guardarropa guardarropa) {
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
        ValidacionPrendaMaterial validacionPrendaMaterial = ValidacionPrendaMaterial.ValidacionPrendaMaterial();
        if (!validacionPrendaMaterial.validarPrenda(material, tipoPrenda)) {
            //TODO: CAMBIAR EL SOUT POR LOGGER, USAR SLF4J de LOMBOK que es tremendo!
            System.out.println("Prenda no valida");
            throw new PrendaNoValidaException("COMBINACION TIPO DE PRENDA / MATERIAL NO VALIDA !");
        }
    }

    protected void validarColores(Color primario, Color secundario) {
        if (primario.equals(secundario)) {
            throw new ColorPrimarioIgualAlSecundarioException("El color primario debe ser distinto al secundario");
        }
    }

    protected void validarParametrosInvalidos(TipoPrenda tipoPrenda, Material material, Color primario) {
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

    public void setPuntajes(java.util.List<PuntajePrenda> puntajes) {
        this.puntajes = puntajes;
    }

    public double getPuntajeDeUsuario(Usuario usuario) {
        return this.getPuntajes().stream().filter(puntaje -> puntaje.getUsuario().equals(usuario)).mapToDouble(PuntajePrenda::getPuntaje).sum();
    }
}