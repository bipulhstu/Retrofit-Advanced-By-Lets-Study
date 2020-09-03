package com.bipulhstu.retrofitadvancebyletsstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.bipulhstu.retrofitadvancebyletsstudy.tutorial3.ArrayDesignClass;
import com.bipulhstu.retrofitadvancebyletsstudy.tutorial3.ObjectDesignClass;
import com.bipulhstu.retrofitadvancebyletsstudy.tutorial3.PositionClass;
import com.bipulhstu.retrofitadvancebyletsstudy.tutorial3.TeamClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Retrofit retrofit;
    OurRetrofitClient ourRetrofitClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ourRetrofitClient = retrofit.create(OurRetrofitClient.class);

        //call enqueue for teams by id
        Call<TeamClass> call = ourRetrofitClient.geData(10, "YmG83m5luFMdt9KrKzArPwlIvXemzvcLNm6MVGcUV0p91NKJ1FaWWoeKTcPp");
        call.enqueue(new Callback<TeamClass>() {
            @Override
            public void onResponse(Call<TeamClass> call, Response<TeamClass> response) {
                if (response.isSuccessful()) {
                    int cid = response.body().getCountry_id();
                    String country_name = response.body().getName();

                    Call<ArrayDesignClass> playerCall = ourRetrofitClient.getPlayerData("YmG83m5luFMdt9KrKzArPwlIvXemzvcLNm6MVGcUV0p91NKJ1FaWWoeKTcPp", cid);


                    playerCall.enqueue(new Callback<ArrayDesignClass>() {
                        @Override
                        public void onResponse(Call<ArrayDesignClass> call, Response<ArrayDesignClass> response) {
                            if (response.isSuccessful()) {
                                List<ObjectDesignClass> objectDesignClassList = response.body().getData();
                                for (ObjectDesignClass objectDesignClass : objectDesignClassList) {

                                    String dob = objectDesignClass.getDateofbirth();
                                    String fullName = objectDesignClass.getFullname();
                                    String gender = objectDesignClass.getGender();

                                    PositionClass positionClass = objectDesignClass.getPosition();
                                    String positionName = positionClass.getName();


                                    Log.d("cid", String.valueOf(cid));
                                    Log.d("dob", String.valueOf(dob));
                                    Log.d("fullName", String.valueOf(fullName));
                                    Log.d("gender", String.valueOf(gender));
                                    Log.d("positionName", String.valueOf(positionName));


                                }
                            } else {
                                Log.d("response", "fail1");
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayDesignClass> call, Throwable t) {
                            Log.d("response", "fail2");
                        }
                    });

                } else {
                    Log.d("response", "fail3");
                }
            }

            @Override
            public void onFailure(Call<TeamClass> call, Throwable t) {
                Log.d("response", "fail4");
            }
        });


        //call enqueue for get continents by id
        /*Call<Tutorial2Class> call = ourRetrofitClient.geData(2, "YmG83m5luFMdt9KrKzArPwlIvXemzvcLNm6MVGcUV0p91NKJ1FaWWoeKTcPp");
        call.enqueue(new Callback<Tutorial2Class>() {
            @Override
            public void onResponse(Call<Tutorial2Class> call, Response<Tutorial2Class> response) {
                if (response.isSuccessful()) {
                    OjbectDataClass ojbectDataClass = response.body().getData();

                    Log.d("id", String.valueOf(ojbectDataClass.getId()));
                    Log.d("name", String.valueOf(ojbectDataClass.getName()));
                    Log.d("resource", String.valueOf(ojbectDataClass.getResource()));
                    Log.d("updated_at", String.valueOf(ojbectDataClass.getUpdated_at()));


                } else {
                    Log.d("response", "fail");

                }
            }

            @Override
            public void onFailure(Call<Tutorial2Class> call, Throwable t) {
                Log.d("response", "fail");

            }
        });
*/

        //call enqueue for get all continents
       /* Call<OurMainDataClass> call = ourRetrofitClient.getData("YmG83m5luFMdt9KrKzArPwlIvXemzvcLNm6MVGcUV0p91NKJ1FaWWoeKTcPp");
        call.enqueue(new Callback<OurMainDataClass>() {
            @Override
            public void onResponse(Call<OurMainDataClass> call, Response<OurMainDataClass> response) {
                if(response.isSuccessful()){

                    List<OjbectDataClass> list = response.body().getData();
                    for (OjbectDataClass ojbectDataClass: list){
                        Log.d("id", String.valueOf(ojbectDataClass.getId()));
                        Log.d("name", String.valueOf(ojbectDataClass.getName()));
                        Log.d("resource", String.valueOf(ojbectDataClass.getResource()));
                        Log.d("updated_at", String.valueOf(ojbectDataClass.getUpdated_at()));
                    }

                }
                else {
                    Log.d("response", "fail");
                }
            }

            @Override
            public void onFailure(Call<OurMainDataClass> call, Throwable t) {
                Log.d("response", "fail");
            }
        });*/

    }
}