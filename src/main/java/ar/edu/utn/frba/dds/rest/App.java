package ar.edu.utn.frba.dds.rest;

import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaCalzado;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaInferior;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaSuperior;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.Caluroso;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.ReferenciaTemperatura;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuario;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuarioGratuito;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuarioPremium;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        crearCasosDePrueba();
        SpringApplication.run(App.class, args);
    }

    private static void crearCasosDePrueba() {

        Repositorio repo = Repositorio.getInstance();

        Material ALGODON = Material.buscarMaterialPorNombre("ALGODON");
        if (ALGODON != null) {
            ALGODON = new Material();
            ALGODON.setNombre("ALGODON");
        }

        Material GABARDINA = Material.buscarMaterialPorNombre("GABARDINA");
        if (GABARDINA != null) {
            GABARDINA = new Material();
            GABARDINA.setNombre("GABARDINA");
        }

        Material LINO = Material.buscarMaterialPorNombre("LINO");
        if (LINO != null) {
            LINO = new Material();
            LINO.setNombre("LINO");
        }

        Material NYLON = Material.buscarMaterialPorNombre("NYLON");
        if (NYLON != null) {
            NYLON = new Material();
            NYLON.setNombre("NYLON");
        }

        Material CAUCHO = Material.buscarMaterialPorNombre("CAUCHO");
        if (CAUCHO != null) {
            CAUCHO = new Material();
            CAUCHO.setNombre("CAUCHO");
        }

        Material LONA = Material.buscarMaterialPorNombre("LONA");
        if (LONA != null) {
            LONA = new Material();
            LONA.setNombre("LONA");
        }

        Material PLASTICO = Material.buscarMaterialPorNombre("PLASTICO");
        if (PLASTICO != null) {
            PLASTICO = new Material();
            PLASTICO.setNombre("PLASTICO");
        }

        Material METAL = Material.buscarMaterialPorNombre("METAL");
        if (METAL != null) {
            METAL = new Material();
            METAL.setNombre("METAL");
        }

        Material LANA = Material.buscarMaterialPorNombre("LANA");
        if (LANA != null) {
            LANA = new Material();
            LANA.setNombre("LANA");
        }

        Material JEAN = Material.buscarMaterialPorNombre("JEAN");
        if (JEAN != null) {
            JEAN = new Material();
            JEAN.setNombre("JEAN");
        }

        Material CUERO = Material.buscarMaterialPorNombre("CUERO");
        if (CUERO != null) {
            CUERO = new Material();
            CUERO.setNombre("CUERO");
        }

        Material LYCRA = Material.buscarMaterialPorNombre("LYCRA");
        if (LYCRA != null) {
            LYCRA = new Material();
            LYCRA.setNombre("LYCRA");
        }

        Material POLIESTER = Material.buscarMaterialPorNombre("POLIESTER");
        if (POLIESTER != null) {
            POLIESTER = new Material();
            POLIESTER.setNombre("POLIESTER");
        }

        Material SEDA = Material.buscarMaterialPorNombre("SEDA");
        if (SEDA != null) {
            SEDA = new Material();
            SEDA.setNombre("SEDA");
        }

        TipoPrenda RemeraCuelloRedondoMangaCorta = TipoPrenda.buscarTipoDePrendaPorCodigo("REMERA_CUELLO_REDONDO_MANGA_CORTA");
        if (RemeraCuelloRedondoMangaCorta == null) {
            RemeraCuelloRedondoMangaCorta = new TipoPrendaSuperior();
            RemeraCuelloRedondoMangaCorta.setNombre("Remera cuello redondo manga corta");
            RemeraCuelloRedondoMangaCorta.setCodigo("REMERA_CUELLO_REDONDO_MANGA_CORTA");
            RemeraCuelloRedondoMangaCorta.setNivelDeCalor(5D);
            repo.save(RemeraCuelloRedondoMangaCorta);
            //No puedo agregar telas admitidas ni combina con
        }

        TipoPrenda RemeraCuelloRedondoMangaLarga = TipoPrenda.buscarTipoDePrendaPorCodigo("REMERA_CUELLO_REDONDO_MANGA_LARGA");
        if (RemeraCuelloRedondoMangaLarga == null) {
            RemeraCuelloRedondoMangaLarga = new TipoPrendaSuperior();
            RemeraCuelloRedondoMangaLarga.setNombre("Remera cuello redondo manga larga");
            RemeraCuelloRedondoMangaLarga.setCodigo("REMERA_CUELLO_REDONDO_MANGA_LARGA");
            RemeraCuelloRedondoMangaLarga.setNivelDeCalor(8D);
            //No puedo agregar telas admitidas ni combina con
            repo.save(RemeraCuelloRedondoMangaLarga);
        }


        TipoPrenda RemeraEscoteVMangaCorta = TipoPrenda.buscarTipoDePrendaPorCodigo("REMERA_ESCOTE_V_MANGA_CORTA");
        if (RemeraEscoteVMangaCorta == null) {
            RemeraEscoteVMangaCorta = new TipoPrendaSuperior();
            RemeraEscoteVMangaCorta.setNombre("Remera escote V manga corta");
            RemeraEscoteVMangaCorta.setCodigo("REMERA_ESCOTE_V_MANGA_CORTA");
            RemeraEscoteVMangaCorta.setNivelDeCalor(5D);
            //No puedo agregar telas admitidas ni combina con
            repo.save(RemeraEscoteVMangaCorta);
        }


        TipoPrenda RemeraEscoteVMangaLarga = TipoPrenda.buscarTipoDePrendaPorCodigo("REMERA_ESCOTE_V_MANGA_LARGA");
        if (RemeraEscoteVMangaLarga == null) {
            RemeraEscoteVMangaLarga = new TipoPrendaSuperior();
            RemeraEscoteVMangaLarga.setNombre("Remera escote V manga larga");
            RemeraEscoteVMangaLarga.setCodigo("REMERA_ESCOTE_V_MANGA_LARGA");
            RemeraEscoteVMangaLarga.setNivelDeCalor(8D);
            //No puedo agregar telas admitidas ni combina con
            repo.save(RemeraEscoteVMangaLarga);
        }

        TipoPrenda sueter = TipoPrenda.buscarTipoDePrendaPorCodigo("SUETER");
        if (sueter == null) {
            sueter = new TipoPrendaSuperior();
            sueter.setNombre("Sueter");
            sueter.setCodigo("SUETER");
            sueter.setNivelDeCalor(15D);
            //No puedo agregar telas admitidas ni combina con
            repo.save(sueter);
        }

        TipoPrenda campera = TipoPrenda.buscarTipoDePrendaPorCodigo("CAMPERA");
        if (campera == null) {
            campera = new TipoPrendaSuperior();
            campera.setNombre("Campera");
            campera.setCodigo("CAMPERA");
            campera.setNivelDeCalor(15D);
            //No puedo agregar telas admitidas ni combina con
            repo.save(campera);
        }

        TipoPrenda pantalonLargo = TipoPrenda.buscarTipoDePrendaPorCodigo("PANTALON_LARGO");
        if (pantalonLargo == null) {
            pantalonLargo = new TipoPrendaInferior();
            pantalonLargo.setNombre("Pantalón largo");
            pantalonLargo.setCodigo("PANTALON_LARGO");
            pantalonLargo.setNivelDeCalor(8D);

            //No puedo agregar telas admitidas ni combina con
            repo.save(pantalonLargo);
        }

        TipoPrenda pantalonCorto = TipoPrenda.buscarTipoDePrendaPorCodigo("PANTALON_CORTO");
        if (pantalonCorto == null) {
            pantalonCorto = new TipoPrendaInferior();
            pantalonCorto.setNombre("Pantalón corto");
            pantalonCorto.setCodigo("PANTALON_CORTO");
            pantalonCorto.setNivelDeCalor(8D);

            //No puedo agregar telas admitidas ni combina con
            repo.save(pantalonCorto);
        }

        TipoPrenda bermuda = TipoPrenda.buscarTipoDePrendaPorCodigo("BERMUDA");
        if (bermuda == null) {
            bermuda = new TipoPrendaInferior();
            bermuda.setNombre("Bermuda");
            bermuda.setCodigo("BERMUDA");
            bermuda.setNivelDeCalor(3D);

            //No puedo agregar telas admitidas ni combina con
            repo.save(bermuda);
        }

        TipoPrenda pollera = TipoPrenda.buscarTipoDePrendaPorCodigo("POLLERA");
        if (pollera == null) {
            pollera = new TipoPrendaInferior();
            pollera.setNombre("Pollera");
            pollera.setCodigo("POLLERA");
            pollera.setNivelDeCalor(3D);

            //No puedo agregar telas admitidas ni combina con
            repo.save(pollera);
        }

        TipoPrenda calza = TipoPrenda.buscarTipoDePrendaPorCodigo("CALZA");
        if (calza == null) {
            calza = new TipoPrendaInferior();
            calza.setNombre("Calza");
            calza.setCodigo("CALZA");
            calza.setNivelDeCalor(5D);

            //No puedo agregar telas admitidas ni combina con
            repo.save(calza);
        }

        TipoPrenda buzo = TipoPrenda.buscarTipoDePrendaPorCodigo("BUZO");
        if (buzo == null) {
            buzo = new TipoPrendaSuperior();
            buzo.setNombre("Buzo");
            buzo.setCodigo("BUZO");
            buzo.setNivelDeCalor(13D);

            //No puedo agregar telas admitidas ni combina con
            repo.save(buzo);
        }

        TipoPrenda musculosa = TipoPrenda.buscarTipoDePrendaPorCodigo("MUSCULOSA");
        if (musculosa == null) {
            musculosa = new TipoPrendaSuperior();
            musculosa.setNombre("Musculosa");
            musculosa.setCodigo("MUSCULOSA");
            musculosa.setNivelDeCalor(3D);

            //No puedo agregar telas admitidas ni combina con
            repo.save(musculosa);
        }

        TipoPrenda zapatillas = TipoPrenda.buscarTipoDePrendaPorCodigo("ZAPATILLAS");
        if (zapatillas == null) {
            zapatillas = new TipoPrendaCalzado();
            zapatillas.setNombre("Zapatillas");
            zapatillas.setCodigo("ZAPATILLAS");
            zapatillas.setNivelDeCalor(0D);

            //No puedo agregar telas admitidas ni combina con
            repo.save(zapatillas);
        }

        TipoPrenda zapatos = TipoPrenda.buscarTipoDePrendaPorCodigo("ZAPATOS");
        if (zapatos == null) {
            zapatos = new TipoPrendaCalzado();
            zapatos.setNombre("Zapatos");
            zapatos.setCodigo("ZAPATOS");
            zapatos.setNivelDeCalor(0D);

            //No puedo agregar telas admitidas ni combina con
            repo.save(zapatos);
        }

        TipoPrenda sandalias = TipoPrenda.buscarTipoDePrendaPorCodigo("SANDALIAS");
        if (sandalias == null) {
            sandalias = new TipoPrendaCalzado();
            sandalias.setNombre("Sandalias");
            sandalias.setCodigo("SANDALIAS");
            sandalias.setNivelDeCalor(0D);

            //No puedo agregar telas admitidas ni combina con
            repo.save(sandalias);
        }

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
            repo.save(aroco);

            if (aroco.getGuardarropas().size() == 0) {
                Guardarropa guardarropa = new Guardarropa();
                guardarropa.setNombre("Guardarropas de Alejandro");
                guardarropa.setPropietario(aroco);
                aroco.agregarGuardarropa(guardarropa);
            }

            Guardarropa guardarropaAroco = aroco.getGuardarropas().get(0);
            if (guardarropaAroco.getPrendas().size() == 0) {

                java.util.List<Prenda> prendas = guardarropaAroco.getPrendas();
                prendas.add(new Prenda(RemeraCuelloRedondoMangaCorta, ALGODON, Color.BLACK));
                prendas.add(new Prenda(RemeraEscoteVMangaCorta, LYCRA, Color.WHITE));
                prendas.add(new Prenda(musculosa, LYCRA, Color.YELLOW));
                prendas.add(new Prenda(campera, CUERO, Color.WHITE));
                prendas.add(new Prenda(sueter, POLIESTER, Color.WHITE));
                prendas.add(new Prenda(bermuda, JEAN, new Color(0, 128, 255)));
                prendas.add(new Prenda(pantalonLargo, NYLON, Color.gray));
                prendas.add(new Prenda(zapatillas, NYLON, new Color(112, 0, 0)));
                prendas.add(new Prenda(zapatos, CUERO, Color.BLACK));
                guardarropaAroco.setPrendas(prendas);
            }
            aroco.getGuardarropas().clear();
            aroco.getGuardarropas().add(guardarropaAroco);
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

            Guardarropa guardarropajazul = jazul.getGuardarropas().get(0);
            if (guardarropajazul.getPrendas().size() == 0) {

                java.util.List<Prenda> prendas = guardarropajazul.getPrendas();
                prendas.add(new Prenda(RemeraCuelloRedondoMangaLarga, LYCRA, Color.YELLOW));
                prendas.add(new Prenda(RemeraEscoteVMangaLarga, ALGODON, Color.WHITE));
                prendas.add(new Prenda(musculosa, LYCRA, Color.GREEN));
                prendas.add(new Prenda(sueter, POLIESTER, Color.GRAY));
                prendas.add(new Prenda(pollera, SEDA, Color.BLACK));
                prendas.add(new Prenda(calza, NYLON, Color.BLACK));
                prendas.add(new Prenda(buzo, ALGODON, Color.WHITE));
                prendas.add(new Prenda(zapatos, CUERO, Color.BLACK));
                prendas.add(new Prenda(sandalias, CUERO, Color.BLACK));
                guardarropajazul.setPrendas(prendas);
            }
            jazul.getGuardarropas().clear();
            jazul.getGuardarropas().add(guardarropajazul);
            repo.save(jazul);
        }

    }
}
