package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.prenda.Clima;
import ar.edu.utn.frba.dds.services.ResponseClima;
import ar.edu.utn.frba.dds.services.RetrofitClimaService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClimaTest {
    public static void main(String args[]){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitClimaService service = retrofit.create(RetrofitClimaService.class);

        Call<ResponseClima> call = service.getClima(3435910,"metric","9de01d0c8f622c95601a4b3aee0f5040");
        try{
            Response<ResponseClima> response = call.execute();
            Clima user = response.body().data;

            System.out.println(user.allData());
        }

        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }


}
