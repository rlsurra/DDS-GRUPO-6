package ar.edu.utn.frba.dds.rest;

import ar.edu.utn.frba.dds.csvReader.CSVReader;
import ar.edu.utn.frba.dds.csvReader.Ciudad;
import ar.edu.utn.frba.dds.model.CiudadesService;
import ar.edu.utn.frba.dds.model.categoria.CategoriaCalzado;
import ar.edu.utn.frba.dds.model.categoria.CategoriaInferior;
import ar.edu.utn.frba.dds.model.categoria.CategoriaSuperior;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoLigero;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoPesado;
import ar.edu.utn.frba.dds.model.evento.Evento;
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

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        crearCasosDePrueba();

        cargarCiudades();

        SpringApplication.run(App.class, args);
    }

    private static void crearCasosDePrueba() {

        Repositorio repo = Repositorio.getInstance();

        Material ALGODON = Material.buscarMaterialPorNombre("ALGODON");
        if (ALGODON == null) {
            ALGODON = new Material();
            ALGODON.setNombre("ALGODON");
            repo.save(ALGODON);
        }

        Material GABARDINA = Material.buscarMaterialPorNombre("GABARDINA");
        if (GABARDINA == null) {
            GABARDINA = new Material();
            GABARDINA.setNombre("GABARDINA");
            repo.save(GABARDINA);
        }

        Material LINO = Material.buscarMaterialPorNombre("LINO");
        if (LINO == null) {
            LINO = new Material();
            LINO.setNombre("LINO");
            repo.save(LINO);
        }

        Material NYLON = Material.buscarMaterialPorNombre("NYLON");
        if (NYLON == null) {
            NYLON = new Material();
            NYLON.setNombre("NYLON");
            repo.save(NYLON);
        }

        Material CAUCHO = Material.buscarMaterialPorNombre("CAUCHO");
        if (CAUCHO == null) {
            CAUCHO = new Material();
            CAUCHO.setNombre("CAUCHO");
            repo.save(CAUCHO);
        }

        Material LONA = Material.buscarMaterialPorNombre("LONA");
        if (LONA == null) {
            LONA = new Material();
            LONA.setNombre("LONA");
            repo.save(LONA);
        }

        Material PLASTICO = Material.buscarMaterialPorNombre("PLASTICO");
        if (PLASTICO == null) {
            PLASTICO = new Material();
            PLASTICO.setNombre("PLASTICO");
            repo.save(PLASTICO);
        }

        Material METAL = Material.buscarMaterialPorNombre("METAL");
        if (METAL == null) {
            METAL = new Material();
            METAL.setNombre("METAL");
            repo.save(METAL);
        }

        Material LANA = Material.buscarMaterialPorNombre("LANA");
        if (LANA == null) {
            LANA = new Material();
            LANA.setNombre("LANA");
            repo.save(LANA);
        }

        Material JEAN = Material.buscarMaterialPorNombre("JEAN");
        if (JEAN == null) {
            JEAN = new Material();
            JEAN.setNombre("JEAN");
            repo.save(JEAN);
        }

        Material CUERO = Material.buscarMaterialPorNombre("CUERO");
        if (CUERO == null) {
            CUERO = new Material();
            CUERO.setNombre("CUERO");
            repo.save(CUERO);
        }

        Material LYCRA = Material.buscarMaterialPorNombre("LYCRA");
        if (LYCRA == null) {
            LYCRA = new Material();
            LYCRA.setNombre("LYCRA");
            repo.save(LYCRA);
        }

        Material POLIESTER = Material.buscarMaterialPorNombre("POLIESTER");
        if (POLIESTER == null) {
            POLIESTER = new Material();
            POLIESTER.setNombre("POLIESTER");
            repo.save(POLIESTER);
        }

        Material SEDA = Material.buscarMaterialPorNombre("SEDA");
        if (SEDA == null) {
            SEDA = new Material();
            SEDA.setNombre("SEDA");
            repo.save(SEDA);
        }

        TipoPrenda RemeraCuelloRedondoMangaCorta = TipoPrenda.buscarTipoDePrendaPorCodigo("REMERA_CUELLO_REDONDO_MANGA_CORTA");
        if (RemeraCuelloRedondoMangaCorta == null) {
            RemeraCuelloRedondoMangaCorta = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
            RemeraCuelloRedondoMangaCorta.setNombre("Remera cuello redondo manga corta");
            RemeraCuelloRedondoMangaCorta.setCodigo("REMERA_CUELLO_REDONDO_MANGA_CORTA");
            RemeraCuelloRedondoMangaCorta.setNivelDeCalor(5D);
            RemeraCuelloRedondoMangaCorta.getMaterialesPermitidos().add(ALGODON);
            RemeraCuelloRedondoMangaCorta.getMaterialesPermitidos().add(SEDA);
            RemeraCuelloRedondoMangaCorta.getMaterialesPermitidos().add(POLIESTER);
            RemeraCuelloRedondoMangaCorta.getMaterialesPermitidos().add(LYCRA);
            repo.save(RemeraCuelloRedondoMangaCorta);
            //No puedo agregar combina con
        }

        TipoPrenda RemeraCuelloRedondoMangaLarga = TipoPrenda.buscarTipoDePrendaPorCodigo("REMERA_CUELLO_REDONDO_MANGA_LARGA");
        if (RemeraCuelloRedondoMangaLarga == null) {
            RemeraCuelloRedondoMangaLarga = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
            RemeraCuelloRedondoMangaLarga.setNombre("Remera cuello redondo manga larga");
            RemeraCuelloRedondoMangaLarga.setCodigo("REMERA_CUELLO_REDONDO_MANGA_LARGA");
            RemeraCuelloRedondoMangaLarga.setNivelDeCalor(8D);
            RemeraCuelloRedondoMangaLarga.getMaterialesPermitidos().add(ALGODON);
            RemeraCuelloRedondoMangaLarga.getMaterialesPermitidos().add(SEDA);
            RemeraCuelloRedondoMangaLarga.getMaterialesPermitidos().add(POLIESTER);
            RemeraCuelloRedondoMangaLarga.getMaterialesPermitidos().add(LYCRA);
            //No puedo agregar combina con
            repo.save(RemeraCuelloRedondoMangaLarga);
        }


        TipoPrenda RemeraEscoteVMangaCorta = TipoPrenda.buscarTipoDePrendaPorCodigo("REMERA_ESCOTE_V_MANGA_CORTA");
        if (RemeraEscoteVMangaCorta == null) {
            RemeraEscoteVMangaCorta = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
            RemeraEscoteVMangaCorta.setNombre("Remera escote V manga corta");
            RemeraEscoteVMangaCorta.setCodigo("REMERA_ESCOTE_V_MANGA_CORTA");
            RemeraEscoteVMangaCorta.setNivelDeCalor(5D);
            RemeraEscoteVMangaCorta.getMaterialesPermitidos().add(ALGODON);
            RemeraEscoteVMangaCorta.getMaterialesPermitidos().add(SEDA);
            RemeraEscoteVMangaCorta.getMaterialesPermitidos().add(POLIESTER);
            RemeraEscoteVMangaCorta.getMaterialesPermitidos().add(LYCRA);
            //No puedo agregar combina con
            repo.save(RemeraEscoteVMangaCorta);
        }


        TipoPrenda RemeraEscoteVMangaLarga = TipoPrenda.buscarTipoDePrendaPorCodigo("REMERA_ESCOTE_V_MANGA_LARGA");
        if (RemeraEscoteVMangaLarga == null) {
            RemeraEscoteVMangaLarga = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
            RemeraEscoteVMangaLarga.setNombre("Remera escote V manga larga");
            RemeraEscoteVMangaLarga.setCodigo("REMERA_ESCOTE_V_MANGA_LARGA");
            RemeraEscoteVMangaLarga.setNivelDeCalor(8D);
            RemeraEscoteVMangaLarga.getMaterialesPermitidos().add(ALGODON);
            RemeraEscoteVMangaLarga.getMaterialesPermitidos().add(SEDA);
            RemeraEscoteVMangaLarga.getMaterialesPermitidos().add(POLIESTER);
            RemeraEscoteVMangaLarga.getMaterialesPermitidos().add(LYCRA);
            //No puedo agregar combina con
            repo.save(RemeraEscoteVMangaLarga);
        }

        TipoPrenda sueter = TipoPrenda.buscarTipoDePrendaPorCodigo("SUETER");
        if (sueter == null) {
            sueter = new TipoPrendaSuperior(CategoriaSuperiorAbrigoLigero.getInstance());
            sueter.setNombre("Sueter");
            sueter.setCodigo("SUETER");
            sueter.setNivelDeCalor(15D);
            sueter.getMaterialesPermitidos().add(ALGODON);
            sueter.getMaterialesPermitidos().add(SEDA);
            sueter.getMaterialesPermitidos().add(POLIESTER);
            //No puedo agregar combina con
            repo.save(sueter);
        }

        TipoPrenda campera = TipoPrenda.buscarTipoDePrendaPorCodigo("CAMPERA");
        if (campera == null) {
            campera = new TipoPrendaSuperior(CategoriaSuperiorAbrigoPesado.getInstance());
            campera.setNombre("Campera");
            campera.setCodigo("CAMPERA");
            campera.setNivelDeCalor(15D);
            campera.getMaterialesPermitidos().add(ALGODON);
            campera.getMaterialesPermitidos().add(SEDA);
            campera.getMaterialesPermitidos().add(POLIESTER);
            campera.getMaterialesPermitidos().add(CUERO);
            campera.getMaterialesPermitidos().add(NYLON);
            //No puedo agregar combina con
            repo.save(campera);
        }

        TipoPrenda pantalonLargo = TipoPrenda.buscarTipoDePrendaPorCodigo("PANTALON_LARGO");
        if (pantalonLargo == null) {
            pantalonLargo = new TipoPrendaInferior(CategoriaInferior.getInstance());
            pantalonLargo.setNombre("Pantalon largo");
            pantalonLargo.setCodigo("PANTALON_LARGO");
            pantalonLargo.setNivelDeCalor(8D);
            pantalonLargo.getMaterialesPermitidos().add(ALGODON);
            pantalonLargo.getMaterialesPermitidos().add(SEDA);
            pantalonLargo.getMaterialesPermitidos().add(POLIESTER);
            pantalonLargo.getMaterialesPermitidos().add(NYLON);
            pantalonLargo.getMaterialesPermitidos().add(JEAN);

            //No puedo agregar combina con
            repo.save(pantalonLargo);
        }

        TipoPrenda pantalonCorto = TipoPrenda.buscarTipoDePrendaPorCodigo("PANTALON_CORTO");
        if (pantalonCorto == null) {
            pantalonCorto = new TipoPrendaInferior(CategoriaInferior.getInstance());
            pantalonCorto.setNombre("Pantalon corto");
            pantalonCorto.setCodigo("PANTALON_CORTO");
            pantalonCorto.setNivelDeCalor(8D);
            pantalonCorto.getMaterialesPermitidos().add(ALGODON);
            pantalonCorto.getMaterialesPermitidos().add(SEDA);
            pantalonCorto.getMaterialesPermitidos().add(POLIESTER);
            pantalonCorto.getMaterialesPermitidos().add(NYLON);
            pantalonCorto.getMaterialesPermitidos().add(JEAN);
            //No puedo agregar combina con
            repo.save(pantalonCorto);
        }

        TipoPrenda bermuda = TipoPrenda.buscarTipoDePrendaPorCodigo("BERMUDA");
        if (bermuda == null) {
            bermuda = new TipoPrendaInferior(CategoriaInferior.getInstance());
            bermuda.setNombre("Bermuda");
            bermuda.setCodigo("BERMUDA");
            bermuda.setNivelDeCalor(3D);
            bermuda.getMaterialesPermitidos().add(ALGODON);
            bermuda.getMaterialesPermitidos().add(SEDA);
            bermuda.getMaterialesPermitidos().add(POLIESTER);
            bermuda.getMaterialesPermitidos().add(NYLON);
            bermuda.getMaterialesPermitidos().add(JEAN);

            //No puedo agregar combina con
            repo.save(bermuda);
        }

        TipoPrenda pollera = TipoPrenda.buscarTipoDePrendaPorCodigo("POLLERA");
        if (pollera == null) {
            pollera = new TipoPrendaInferior(CategoriaInferior.getInstance());
            pollera.setNombre("Pollera");
            pollera.setCodigo("POLLERA");
            pollera.setNivelDeCalor(3D);
            pollera.getMaterialesPermitidos().add(ALGODON);
            pollera.getMaterialesPermitidos().add(SEDA);
            pollera.getMaterialesPermitidos().add(POLIESTER);
            pollera.getMaterialesPermitidos().add(NYLON);
            pollera.getMaterialesPermitidos().add(JEAN);
            //No puedo agregar combina con
            repo.save(pollera);
        }

        TipoPrenda calza = TipoPrenda.buscarTipoDePrendaPorCodigo("CALZA");
        if (calza == null) {
            calza = new TipoPrendaInferior(CategoriaInferior.getInstance());
            calza.setNombre("Calza");
            calza.setCodigo("CALZA");
            calza.setNivelDeCalor(5D);
            calza.getMaterialesPermitidos().add(ALGODON);
            calza.getMaterialesPermitidos().add(SEDA);
            calza.getMaterialesPermitidos().add(POLIESTER);
            calza.getMaterialesPermitidos().add(NYLON);
            //No puedo agregar combina con
            repo.save(calza);
        }

        TipoPrenda buzo = TipoPrenda.buscarTipoDePrendaPorCodigo("BUZO");
        if (buzo == null) {
            buzo = new TipoPrendaSuperior(CategoriaSuperiorAbrigoLigero.getInstance());
            buzo.setNombre("Buzo");
            buzo.setCodigo("BUZO");
            buzo.setNivelDeCalor(13D);
            buzo.getMaterialesPermitidos().add(ALGODON);
            buzo.getMaterialesPermitidos().add(SEDA);
            buzo.getMaterialesPermitidos().add(POLIESTER);
            buzo.getMaterialesPermitidos().add(NYLON);
            //No puedo agregar combina con
            repo.save(buzo);
        }

        TipoPrenda musculosa = TipoPrenda.buscarTipoDePrendaPorCodigo("MUSCULOSA");
        if (musculosa == null) {
            musculosa = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
            musculosa.setNombre("Musculosa");
            musculosa.setCodigo("MUSCULOSA");
            musculosa.setNivelDeCalor(3D);
            musculosa.getMaterialesPermitidos().add(ALGODON);
            musculosa.getMaterialesPermitidos().add(LYCRA);
            //No puedo agregar combina con
            repo.save(musculosa);
        }

        TipoPrenda zapatillas = TipoPrenda.buscarTipoDePrendaPorCodigo("ZAPATILLAS");
        if (zapatillas == null) {
            zapatillas = new TipoPrendaCalzado(CategoriaCalzado.getInstance());
            zapatillas.setNombre("Zapatillas");
            zapatillas.setCodigo("ZAPATILLAS");
            zapatillas.setNivelDeCalor(0D);
            zapatillas.getMaterialesPermitidos().add(CUERO);
            zapatillas.getMaterialesPermitidos().add(NYLON);
            //No puedo agregar combina con
            repo.save(zapatillas);
        }

        TipoPrenda zapatos = TipoPrenda.buscarTipoDePrendaPorCodigo("ZAPATOS");
        if (zapatos == null) {
            zapatos = new TipoPrendaCalzado(CategoriaCalzado.getInstance());
            zapatos.setNombre("Zapatos");
            zapatos.setCodigo("ZAPATOS");
            zapatos.setNivelDeCalor(0D);
            zapatos.getMaterialesPermitidos().add(CUERO);

            //No puedo agregar combina con
            repo.save(zapatos);
        }

        TipoPrenda sandalias = TipoPrenda.buscarTipoDePrendaPorCodigo("SANDALIAS");
        if (sandalias == null) {
            sandalias = new TipoPrendaCalzado(CategoriaCalzado.getInstance());
            sandalias.setNombre("Sandalias");
            sandalias.setCodigo("SANDALIAS");
            sandalias.setNivelDeCalor(0D);
            sandalias.getMaterialesPermitidos().add(CUERO);
            //No puedo agregar combina con
            repo.save(sandalias);
        }

        ReferenciaTemperatura caluroso = new Caluroso();
        TipoUsuario gratuito = new TipoUsuarioGratuito();
        TipoUsuario premium = new TipoUsuarioPremium();

        //Usuario Aroco
        Usuario aroco = Usuario.getUsuarioFromUserName("aroco");
       /* SI LO TENGO SUPONGO QUE ESTA BIEN, SI ESTA MAL HAY QUE ELIMINARLO PARA QUE SE VUELVA A CREAR,
        SINO voy a estar pisandolo tod el tiempo */
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

                Prenda prenda1 = new Prenda("Remera cuello redondo", RemeraCuelloRedondoMangaCorta, ALGODON, "0|0|0|1", "255|0|0|1");
                Prenda prenda2 = new Prenda("Remera escote ", RemeraEscoteVMangaCorta, LYCRA, "255|255|255|1");
                Prenda prenda3 = new Prenda("La muscuLoca", musculosa, LYCRA, "255|255|0|1");
                Prenda prenda4 = new Prenda("La Jampera del tio", campera, CUERO, "255|255|255|1");
                Prenda prenda5 = new Prenda("Su eter", sueter, POLIESTER, "255|255|255|1");
                Prenda prenda6 = new Prenda("Bermudeli", bermuda, JEAN, "0|128|255|1");
                Prenda prenda7 = new Prenda("Jean para el bolo", pantalonLargo, NYLON, "128|128|128|1");
                Prenda prenda8 = new Prenda("Los championes", zapatillas, NYLON, "112|0|0|1");
                Prenda prenda9 = new Prenda("Zapatito para trajedia", zapatos, CUERO, "0|0|0|1");

                prendas.addAll(Arrays.asList(prenda1,prenda2, prenda3, prenda4, prenda5, prenda6, prenda7, prenda8, prenda9));
                guardarropaAroco.setPrendas(prendas);
            }
            aroco.getGuardarropas().clear();
            aroco.getGuardarropas().add(guardarropaAroco);
            repo.save(aroco);

            if(aroco.getEventos().size() == 0) {
                Evento fiesta = new Evento();
                fiesta.setNombre("Previa con los pibes");
                fiesta.setTemperatura(10.0);
                fiesta.setCiudad(3430310);
                fiesta.setUsuario(aroco);
                repo.save(fiesta);
                aroco.agregarEvento(fiesta);
            }
            repo.save(aroco);
        }


        //Usuario jazul
        Usuario jazul = Usuario.getUsuarioFromUserName("jazul");
        /* SI LO TENGO SUPONGO QUE ESTA BIEN, SI ESTA MAL HAY QUE ELIMINARLO PARA QUE SE VUELVA A CREAR,
        SINO voy a estar pisandolo tod el tiempo */
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

                Prenda prenda1 = new Prenda("Remera cuello redondo", RemeraCuelloRedondoMangaLarga, LYCRA, "255|255|0|1");
                Prenda prenda2 = new Prenda("Remera cuello V", RemeraEscoteVMangaLarga, ALGODON, "255|255|255|1");
                Prenda prenda3 = new Prenda("Musculosa verde", musculosa, LYCRA, "0|255|0|1");
                Prenda prenda4 = new Prenda("Sweater", sueter, POLIESTER, "128|128|128|1");
                Prenda prenda5 = new Prenda("La pollerita", pollera, SEDA, "0|0|0|1");
                Prenda prenda6 = new Prenda("Calza", calza, NYLON, "0|0|0|1");
                Prenda prenda7 = new Prenda("El Paton Buzo", buzo, ALGODON, "255|255|255|1");
                Prenda prenda8 = new Prenda("Zapatos de fiesta", zapatos, CUERO, "0|0|0|1");
                Prenda prenda9 = new Prenda("Sandalias para todos los dias", sandalias, CUERO, "0|0|0|1");

                prendas.addAll(Arrays.asList(prenda1,prenda2, prenda3, prenda4, prenda5, prenda6, prenda7, prenda8, prenda9));
                guardarropajazul.setPrendas(prendas);
            }
            jazul.getGuardarropas().clear();
            jazul.getGuardarropas().add(guardarropajazul);
            repo.save(jazul);

            if(jazul.getEventos().size() == 0) {
                Evento fiesta = new Evento();
                fiesta.setNombre("Cumple de Ro");
                fiesta.setTemperatura(10.0);
                fiesta.setCiudad(3430234);
                fiesta.setUsuario(jazul);
                repo.save(fiesta);
                jazul.agregarEvento(fiesta);
            }
            repo.save(jazul);
        }

    }

    private static void cargarCiudades(){

        CiudadesService service = CiudadesService.CiudadesService();

        List<Ciudad> ciudades = CSVReader.readBooksFromCSV("/Users/juanmartinconde/Documents/Facultad/DDS/2019/QMP/DDS-GRUPO-6/src/main/resources/ciudades.csv");

        service.setCiudades(ciudades);

        int contador = 0;
        for (Ciudad c : ciudades) {
            contador++;
        }

        System.out.println("Se cargaron " + contador + " ciudades");

    }
}
