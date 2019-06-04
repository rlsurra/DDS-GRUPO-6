package ar.edu.utn.frba.dds.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitClimaService{

    @GET("/data/2.5/weather")
    Call<ResponseClima> getClima(@Query("id") int userId, @Query("units") String userUnits, @Query("appid") String userAppid);

}
