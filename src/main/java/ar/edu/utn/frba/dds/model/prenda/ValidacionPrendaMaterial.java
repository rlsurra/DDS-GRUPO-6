package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.accesorio.TipoAnteojos;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.accesorio.TipoGorra;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.accesorio.TipoPulsera;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.accesorio.TipoReloj;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.calzado.*;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.inferior.*;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.abrigoLigero.TipoBuzo;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.abrigoLigero.TipoSweater;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.abrigoPesado.TipoBuzoPolar;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.abrigoPesado.TipoCampera;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.camisa.TipoCamisaCorta;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.camisa.TipoCamisaLarga;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.remera.TipoChomba;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.remera.TipoMusculosa;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.remera.TipoRemeraCorta;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.remera.TipoRemeraLarga;
import ar.edu.utn.frba.dds.persistence.Entidad;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ValidacionPrendaMaterial {

    public static boolean validarPrenda(Material material, TipoPrenda tipoPrenda) {
        return tipoPrenda.getMaterialesPermitidos().stream().map(Entidad::getNombre).collect(Collectors.toList()).contains(material.getNombre());
    }

}
