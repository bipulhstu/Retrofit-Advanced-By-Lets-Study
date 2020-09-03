package com.bipulhstu.retrofitadvancebyletsstudy;

import com.bipulhstu.retrofitadvancebyletsstudy.tutorial3.ArrayDesignClass;
import com.bipulhstu.retrofitadvancebyletsstudy.tutorial3.TeamClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OurRetrofitClient {
    //Get all continents
   /* @GET("continents")
    Call<OurMainDataClass> getData(@Query("api_token") String token);*/

    //Get continents by id
   /* @GET("continents/{id}")
    Call<Tutorial2Class> geData(@Path("id") int id, @Query("api_token") String token);*/

    //Get teams by id
    @GET("teams/{id}")
    Call<TeamClass> geData(@Path("id") int id, @Query("api_token") String token);

    @GET("players")
    Call<ArrayDesignClass> getPlayerData(@Query("api_token") String token, @Query("country_id") int cid);
}
