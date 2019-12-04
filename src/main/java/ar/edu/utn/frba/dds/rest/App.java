package ar.edu.utn.frba.dds.rest;

import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaCalzado;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaInferior;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaSuperior;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.abrigoLigero.TipoSweater;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.remera.TipoRemeraCorta;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.remera.TipoRemeraLarga;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.Caluroso;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.ReferenciaTemperatura;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuario;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuarioGratuito;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuarioPremium;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        crearCasosDePrueba();
        SpringApplication.run(App.class, args);
    }

    private static void crearCasosDePrueba() {

        Repositorio repo = Repositorio.getInstance();


        TipoPrenda RemeraCuelloRedondoMangaCorta = new TipoPrendaSuperior();
        RemeraCuelloRedondoMangaCorta.setNombre("Remera cuello redondo manga corta");
        RemeraCuelloRedondoMangaCorta.setNivelDeCalor(5D);
        //No puedo agregar telas admitidas ni combina con

        ReferenciaTemperatura caluroso = new Caluroso();
        TipoUsuario gratuito = new TipoUsuarioGratuito();
        TipoUsuario premium = new TipoUsuarioPremium();

        //Usuario Aroco
        Usuario aroco = Usuario.getUsuarioFromUserName("aroco");
       /* SI LO TENGO SUPONGO QUE ESTA BIEN, SI ESTA MAL HAY QUE ELIMINARLO PARA QUE SE VUELVA A CREAR,
        SINO voy a estar pisandolo todo el tiempo */
        if (aroco == null) {
            aroco = new Usuario();
            aroco.setRefTemperatura(caluroso);
            aroco.setTipoUsuario(gratuito);
            aroco.setUsername("aroco");
            aroco.setPassword("123456");
            aroco.setNombre("Alejandro");
            aroco.setApellido("Roco");
            if (aroco.getGuardarropas().size() == 0) {
                Guardarropa guardarropa = new Guardarropa();
                guardarropa.setNombre("Guardarropas de Alejandro");
                guardarropa.setPropietario(aroco);
                aroco.agregarGuardarropa(guardarropa);
            }
            repo.save(aroco);
        }

        //Usuario jazul
        Usuario jazul = Usuario.getUsuarioFromUserName("jazul");
        /* SI LO TENGO SUPONGO QUE ESTA BIEN, SI ESTA MAL HAY QUE ELIMINARLO PARA QUE SE VUELVA A CREAR,
        SINO voy a estar pisandolo todo el tiempo */
        if (jazul == null) {
            jazul = new Usuario();
            jazul.setRefTemperatura(caluroso);
            jazul.setTipoUsuario(premium);
            jazul.setUsername("jazul");
            jazul.setPassword("123456");
            jazul.setNombre("Julieta");
            jazul.setApellido("Azul");
            if (jazul.getGuardarropas().size() == 0) {
                Guardarropa guardarropa = new Guardarropa();
                guardarropa.setNombre("Guardarropas de Julieta");
                guardarropa.setPropietario(jazul);
                jazul.agregarGuardarropa(guardarropa);
            }
            repo.save(jazul);
        }



        TipoPrenda RemeraCuelloRedondoMangaLarga = new TipoPrendaSuperior();
        RemeraCuelloRedondoMangaLarga.setNombre("Remera cuello redondo manga larga");
        RemeraCuelloRedondoMangaLarga.setNivelDeCalor(8D);
        //No puedo agregar telas admitidas ni combina con

        TipoPrenda RemeraEscoteVMangaCorta = new TipoPrendaSuperior();
        RemeraEscoteVMangaCorta.setNombre("Remera escote V manga corta");
        RemeraEscoteVMangaCorta.setNivelDeCalor(5D);
        //No puedo agregar telas admitidas ni combina con

        TipoPrenda RemeraEscoteVMangaLarga = new TipoPrendaSuperior();
        RemeraEscoteVMangaLarga.setNombre("Remera escote V manga larga");
        RemeraEscoteVMangaLarga.setNivelDeCalor(8D);
        //No puedo agregar telas admitidas ni combina con

        TipoPrenda sueter = new TipoPrendaSuperior();
        sueter.setNombre("Sueter");
        sueter.setNivelDeCalor(15D);

        TipoPrenda campera = new TipoPrendaSuperior();
        campera.setNombre("Campera");
        campera.setNivelDeCalor(15D);

        TipoPrenda pantalonLargo = new TipoPrendaInferior();
        pantalonLargo.setNombre("Pantalón largo");
        pantalonLargo.setNivelDeCalor(8D);

        TipoPrenda pantalonCorto = new TipoPrendaInferior();
        pantalonCorto.setNombre("Pantalón corto");
        pantalonCorto.setNivelDeCalor(8D);

        TipoPrenda bermuda = new TipoPrendaInferior();
        bermuda.setNombre("Bermuda");
        bermuda.setNivelDeCalor(3D);

        TipoPrenda pollera = new TipoPrendaInferior();
        pollera.setNombre("Pollera");
        pollera.setNivelDeCalor(3D);

        TipoPrenda calza = new TipoPrendaInferior();
        calza.setNombre("Calza");
        calza.setNivelDeCalor(5D);

        TipoPrenda buzo = new TipoPrendaSuperior();
        buzo.setNombre("Buzo");
        buzo.setNivelDeCalor(13D);

        TipoPrenda musculosa = new TipoPrendaSuperior();
        musculosa.setNombre("Musculosa");
        musculosa.setNivelDeCalor(3D);

        TipoPrenda zapatillas = new TipoPrendaCalzado();
        zapatillas.setNombre("Zapatillas");
        zapatillas.setNivelDeCalor(0D);

        TipoPrenda zapatos = new TipoPrendaCalzado();
        zapatos.setNombre("Zapatos");
        zapatos.setNivelDeCalor(0D);

        TipoPrenda sandalias = new TipoPrendaCalzado();
        sandalias.setNombre("Zapatos");
        sandalias.setNivelDeCalor(0D);






    }
}
