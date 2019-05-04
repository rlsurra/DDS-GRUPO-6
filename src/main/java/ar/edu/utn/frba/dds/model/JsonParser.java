package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.model.config.Config;
import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.javatuples.Pair;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonParser {

    public JsonParser() {}

    Config config = new Config();

    // Cliente
    public List<Pair<Material, TipoPrenda>> loadClientesJSON() throws IOException {


        Type ValidationListType = new TypeToken<List<Pair<Material, TipoPrenda>>>() {}.getType();
        List<Pair<Material, TipoPrenda>> validaciones;
        try(Reader reader = new InputStreamReader(JsonParser.class.getResourceAsStream
                (config.getProperty("jsonValidaciones")), "UTF-8")){
            Gson gson = new GsonBuilder().create();

            validaciones = gson.fromJson(reader, ValidationListType);

        }
        return validaciones;
    }

}