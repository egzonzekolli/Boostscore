package com.example.my123.Api;


import com.example.my123.Games.Game;
import com.example.my123.TeamData.TeamData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("matches")
    Call<Game[]> getCsGo_matches(
            @Query("token") String token
    );


    @GET("/teams/{team_id_or_slug}")
    Call<TeamData> getTeamData(@Path("team_id_or_slug") int team_id_or_slug,
                               @Query("token") String token
    );


}
