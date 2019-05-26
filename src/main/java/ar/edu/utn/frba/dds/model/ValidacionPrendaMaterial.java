package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.accesorio.TipoAnteojos;
import ar.edu.utn.frba.dds.model.prenda.accesorio.TipoGorra;
import ar.edu.utn.frba.dds.model.prenda.accesorio.TipoPulsera;
import ar.edu.utn.frba.dds.model.prenda.accesorio.TipoReloj;
import ar.edu.utn.frba.dds.model.prenda.calzado.*;
import ar.edu.utn.frba.dds.model.prenda.inferior.*;
import ar.edu.utn.frba.dds.model.prenda.superior.*;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

public class ValidacionPrendaMaterial {

//    --------------------------------------------------------------------------------------------------
//      ESTO ES PARA QUE SEA UNA CLASE SINGLETON, SOLO SE CREA UNA VEZ
    private static ValidacionPrendaMaterial INSTANCE = null;

    private ValidacionPrendaMaterial() {
        //TODO: Ver si aca se puede hacer la lectura del Json para que sea mas dinamico
        cargarListaDeValidaciones();
    }

    public static ValidacionPrendaMaterial ValidacionPrendaMaterial(){
        if(INSTANCE == null){
            INSTANCE = new ValidacionPrendaMaterial();
        }
        return INSTANCE;
    }

//    --------------------------------------------------------------------------------------------------

    private List<Pair<Material, Class>> listaValidacion = new ArrayList<>();

    public List<Pair<Material, Class>> getListaValidacion() {
        return listaValidacion;
    }

    public void setListaValidacion(List<Pair<Material, Class>> listaValidacion) {
        this.listaValidacion = listaValidacion;
    }

    private void insertarValidacion(Material m, Class t){
        this.listaValidacion.add(new Pair<>(m, t));
    }

    public boolean validarPrenda(Material material, TipoPrenda tipoPrenda){
        Pair<Material, Class> parMaterialTipoPrenda = new Pair<>(material, tipoPrenda.getClass());
        return listaValidacion.contains(parMaterialTipoPrenda);
    }

    private void cargarListaDeValidaciones() {
        insertarValidacion(Material.ALGODON, TipoRemeraCorta.class);
        insertarValidacion(Material.LINO, TipoRemeraCorta.class);
        insertarValidacion(Material.NYLON, TipoRemeraCorta.class);
        insertarValidacion(Material.ALGODON, TipoRemeraLarga.class);
        insertarValidacion(Material.LINO, TipoRemeraLarga.class);
        insertarValidacion(Material.ALGODON, TipoCamisaLarga.class);
        insertarValidacion(Material.LINO, TipoCamisaLarga.class);
        insertarValidacion(Material.ALGODON, TipoCamisaCorta.class);
        insertarValidacion(Material.LINO, TipoCamisaCorta.class);
        insertarValidacion(Material.ALGODON, TipoMusculosa.class);
        insertarValidacion(Material.LINO, TipoMusculosa.class);
        insertarValidacion(Material.ALGODON, TipoChomba.class);
        insertarValidacion(Material.LINO, TipoChomba.class);
        insertarValidacion(Material.ALGODON, TipoJean.class);
        insertarValidacion(Material.GABARDINA, TipoJean.class);
        insertarValidacion(Material.ALGODON, TipoBermuda.class);
        insertarValidacion(Material.GABARDINA, TipoBermuda.class);
        insertarValidacion(Material.ALGODON, TipoJogging.class);
        insertarValidacion(Material.ALGODON, TipoShort.class);
        insertarValidacion(Material.NYLON, TipoShort.class);
        insertarValidacion(Material.NYLON, TipoTrajeDeBanio.class);
        insertarValidacion(Material.LONA, TipoAlpargata.class);
        insertarValidacion(Material.CUERO, TipoAlpargata.class);
        insertarValidacion(Material.CUERO, TipoBota.class);
        insertarValidacion(Material.CAUCHO, TipoBota.class);
        insertarValidacion(Material.PLASTICO, TipoBota.class);
        insertarValidacion(Material.CUERO, TipoBotin.class);
        insertarValidacion(Material.PLASTICO, TipoBotin.class);
        insertarValidacion(Material.CAUCHO, TipoBotin.class);
        insertarValidacion(Material.PLASTICO, TipoOjota.class);
        insertarValidacion(Material.CAUCHO, TipoOjota.class);
        insertarValidacion(Material.PLASTICO, TipoZapatilla.class);
        insertarValidacion(Material.CUERO, TipoZapatilla.class);
        insertarValidacion(Material.CAUCHO, TipoZapatilla.class);
        insertarValidacion(Material.LONA, TipoZapatilla.class);
        insertarValidacion(Material.CUERO, TipoZapato.class);
        insertarValidacion(Material.CAUCHO, TipoZapato.class);
        insertarValidacion(Material.PLASTICO, TipoAnteojos.class);
        insertarValidacion(Material.METAL, TipoAnteojos.class);
        insertarValidacion(Material.LONA, TipoGorra.class);
        insertarValidacion(Material.LANA, TipoGorra.class);
        insertarValidacion(Material.ALGODON, TipoGorra.class);
        insertarValidacion(Material.CUERO, TipoGorra.class);
        insertarValidacion(Material.CUERO, TipoPulsera.class);
        insertarValidacion(Material.ALGODON, TipoPulsera.class);
        insertarValidacion(Material.METAL, TipoPulsera.class);
        insertarValidacion(Material.PLASTICO, TipoPulsera.class);
        insertarValidacion(Material.PLASTICO, TipoReloj.class);
        insertarValidacion(Material.METAL, TipoReloj.class);
        insertarValidacion(Material.CUERO, TipoReloj.class);
        insertarValidacion(Material.JEAN, TipoJean.class);
    }
}
