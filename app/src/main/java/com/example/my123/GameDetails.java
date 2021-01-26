package com.example.my123;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.my123.Api.ApiClient;
import com.example.my123.Api.ApiInterface;
import com.example.my123.TeamData.TeamData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameDetails extends AppCompatActivity {

    private static final String token = "3f6F8k8XUQMHw_XsC4tVooilxfz2IzJ4mO3hB1HPISKAivvSrn8";
    private static final String BASE_URL = "https://api.pandascore.co/";
    private TeamData teamData = new TeamData();
    ImageView ImgTeam1,ImgTeam2;
    TextView NameTeam1,NameTeam2;
    private int mposition;
    ImageView ImgTeam1Player1,ImgTeam1Player2,ImgTeam1Player3,ImgTeam1Player4,ImgTeam1Player5,ImgTeam2Player1,ImgTeam2Player2,ImgTeam2Player3,ImgTeam2Player4,ImgTeam2Player5;
    TextView NameTeam1Player1,NameTeam1Player2,NameTeam1Player3,NameTeam1Player4,NameTeam1Player5,NameTeam2Player1,NameTeam2Player2,NameTeam2Player3,NameTeam2Player4,NameTeam2Player5;
    int Idteam1,Idteam2;
    int i =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);


        Initialize();
        Intent intent= getIntent();
        String UrlTeam1 = intent.getStringExtra("Imgteam1");
        String UrlTeam2 = intent.getStringExtra("Imgteam2");
        String NaTeam1 = intent.getStringExtra("Neamteam1");
        String NaTeam2 = intent.getStringExtra("Neamteam2");
        Idteam1 = intent.getIntExtra("Idteam1",0);
        Idteam2 = intent.getIntExtra("Idteam2",0);

        mposition=intent.getIntExtra("position",0);
        RequestOptions requestOptions = new RequestOptions();
        try {
            Glide.with(this)
                    .load(UrlTeam1)
                    .apply(requestOptions)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(ImgTeam1);
        }catch (Exception e){}
        try {
            Glide.with(this)
                    .load(UrlTeam2)
                    .apply(requestOptions)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(ImgTeam2);
        }catch (Exception e){}

        NameTeam1.setText(NaTeam1);
        NameTeam2.setText(NaTeam2);
        LoadJson(Idteam1);
        LoadJson(Idteam2);

    }

    private void Initialize() {

        ImgTeam1=findViewById(R.id.ImgTeam1);
        ImgTeam2=findViewById(R.id.ImgTeam2);
        NameTeam1=findViewById(R.id.NameTeam1);
        NameTeam2=findViewById(R.id.NameTeam2);

        ImgTeam1Player1=findViewById(R.id.ImgTeam1Player1);
        ImgTeam1Player2=findViewById(R.id.ImgTeam1Player2);
        ImgTeam1Player3=findViewById(R.id.ImgTeam1Player3);
        ImgTeam1Player4=findViewById(R.id.ImgTeam1Player4);
        ImgTeam1Player5=findViewById(R.id.ImgTeam1Player5);
        NameTeam1Player1=findViewById(R.id.NameTeam1Player1);
        NameTeam1Player2=findViewById(R.id.NameTeam1Player2);
        NameTeam1Player3=findViewById(R.id.NameTeam1Player3);
        NameTeam1Player4=findViewById(R.id.NameTeam1Player4);
        NameTeam1Player5=findViewById(R.id.NameTeam1Player5);

        ImgTeam2Player1=findViewById(R.id.ImgTeam2Player1);
        ImgTeam2Player2=findViewById(R.id.ImgTeam2Player2);
        ImgTeam2Player3=findViewById(R.id.ImgTeam2Player3);
        ImgTeam2Player4=findViewById(R.id.ImgTeam2Player4);
        ImgTeam2Player5=findViewById(R.id.ImgTeam2Player5);
        NameTeam2Player1=findViewById(R.id.NameTeam2Player1);
        NameTeam2Player2=findViewById(R.id.NameTeam2Player2);
        NameTeam2Player3=findViewById(R.id.NameTeam2Player3);
        NameTeam2Player4=findViewById(R.id.NameTeam2Player4);
        NameTeam2Player5=findViewById(R.id.NameTeam2Player5);

    }

    private void LoadJson(int Id) {
        ApiInterface apiInterface = ApiClient.getApiClient(BASE_URL).create(ApiInterface.class);
        Call<TeamData> call;
        call=apiInterface.getTeamData(Id,token);
        call.enqueue(new Callback<TeamData>() {
            @Override
            public void onResponse(Call<TeamData> call, Response<TeamData> response) {
                Log.i("status", "if" );
                teamData= response.body();
                setData();


            }

            @Override
            public void onFailure(Call<TeamData> call, Throwable t) {
                Log.i("status", "off" );
            }
        });
    }

    private void setData() {
        if(i==0) {
            RequestOptions requestOptions = new RequestOptions();
            try {
                Glide.with(this)
                        .load(teamData.getPlayers().get(0).getImageUrl())
                        .apply(requestOptions)
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        })
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(ImgTeam1Player1);
                NameTeam1Player1.setText(teamData.getPlayers().get(0).getName());

            }catch (Exception e){}
            try {
                Glide.with(this)
                        .load(teamData.getPlayers().get(1).getImageUrl())
                        .apply(requestOptions)
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        })
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(ImgTeam1Player2);
                NameTeam1Player2.setText(teamData.getPlayers().get(1).getName());

            }catch (Exception e){}
            try {
                Glide.with(this)
                        .load(teamData.getPlayers().get(2).getImageUrl())
                        .apply(requestOptions)
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        })
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(ImgTeam1Player3);
                NameTeam1Player3.setText(teamData.getPlayers().get(2).getName());
            }catch (Exception e){}
            try {
                Glide.with(this)
                        .load(teamData.getPlayers().get(3).getImageUrl())
                        .apply(requestOptions)
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        })
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(ImgTeam1Player4);
                NameTeam1Player4.setText(teamData.getPlayers().get(3).getName());
            }catch (Exception e){}
            try {
                Glide.with(this)
                        .load(teamData.getPlayers().get(4).getImageUrl())
                        .apply(requestOptions)
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        })
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(ImgTeam1Player5);
                NameTeam1Player5.setText(teamData.getPlayers().get(4).getName());
            }catch (Exception e){}
            i++;
        }
        else {
            RequestOptions requestOptions = new RequestOptions();
            try {
                Glide.with(this)
                        .load(teamData.getPlayers().get(0).getImageUrl())
                        .apply(requestOptions)
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        })
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(ImgTeam2Player1);
                NameTeam2Player1.setText(teamData.getPlayers().get(0).getName());

            }catch (Exception e){}
            try {
                Glide.with(this)
                        .load(teamData.getPlayers().get(1).getImageUrl())
                        .apply(requestOptions)
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        })
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(ImgTeam2Player2);
                NameTeam2Player2.setText(teamData.getPlayers().get(1).getName());
            }catch (Exception e){}
            try {
                Glide.with(this)
                        .load(teamData.getPlayers().get(2).getImageUrl())
                        .apply(requestOptions)
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        })
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(ImgTeam2Player3);
                NameTeam2Player3.setText(teamData.getPlayers().get(2).getName());
            } catch (Exception e){}
            try {
                Glide.with(this)
                        .load(teamData.getPlayers().get(3).getImageUrl())
                        .apply(requestOptions)
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        })
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(ImgTeam2Player4);
                NameTeam2Player4.setText(teamData.getPlayers().get(3).getName());
            } catch (Exception e){}
            try {
                Glide.with(this)
                        .load(teamData.getPlayers().get(4).getImageUrl())
                        .apply(requestOptions)
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        })
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(ImgTeam2Player5);
                NameTeam2Player5.setText(teamData.getPlayers().get(4).getName());
            } catch (Exception e){}

            i--;
        }

    }
}