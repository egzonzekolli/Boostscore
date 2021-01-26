package com.example.my123;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.my123.Games.Game;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String LOG_TAG = RecyclerViewAdapter.class.getSimpleName();
    private List<Game> mItems1;
    ItemListener mListener;
    Context context;
    public static int position;

    public RecyclerViewAdapter(Activity context, List<Game> program, ItemListener listener) {

        this.context = context;
        mItems1 = program;
        mListener = listener;
    }

    public void setOnItemClickListener(ItemListener listener) {
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.listitems, parent, false);
        context = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(mItems1.get(position));
    }

    @Override
    public int getItemCount() {
        if (mItems1 != null) {
            return mItems1.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView cardView;
        //public Game pName;
        TextView name1,name2,VsTime;
        ImageView imageView1,imageView2;
        View textContainer;
        private Game pName;

        public ViewHolder(View itemView) {

            super(itemView);
            itemView.setOnClickListener(this);
//            cardView = (CardView)itemView.findViewById(R.id.cvItem);
            name1 = (TextView) itemView.findViewById(R.id.Team1);
            name2 = (TextView) itemView.findViewById(R.id.Team2);
            VsTime = (TextView) itemView.findViewById(R.id.VsTime);
            imageView1 = (ImageView) itemView.findViewById(R.id.imgTeam1);
            imageView2 = (ImageView) itemView.findViewById(R.id.imgTeam2);


            textContainer = itemView.findViewById(R.id.text_container);
        }

        public void setData(Game pName) {
            this.pName = pName;
            RequestOptions requestOptions = new RequestOptions();
            if(pName!=null){
            try {
                if (pName.getOpponents().size()==1)
                {
                    Glide.with(context)
                            .load(pName.getOpponents().get(0).getOpponent().getImageUrl())
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
                            .into(imageView1);

                    Glide.with(context)
                            .load(pName.getOpponents().get(1).getOpponent().getImageUrl())
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
                            .into(imageView2);

                }
                if (pName.getOpponents().size()==2) {
                    Glide.with(context)
                            .load(pName.getOpponents().get(0).getOpponent().getImageUrl())
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
                            .into(imageView1);

                    Glide.with(context)
                            .load(pName.getOpponents().get(1).getOpponent().getImageUrl())
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
                            .into(imageView2);
                    name1.setText(pName.getOpponents().get(0).getOpponent().getName());
                    name2.setText(pName.getOpponents().get(1).getOpponent().getName());
                }
                if (pName.getStatus().equals("finished")) {
                    VsTime.setText(pName.getResults().get(0).getScore()+" - "+pName.getResults().get(1).getScore());
                    VsTime.setTextColor(Color.BLACK);
                }
                else if (pName.getStatus().equals("running")) {
                    VsTime.setText(pName.getResults().get(0).getScore()+" - "+pName.getResults().get(1).getScore());
                    VsTime.setTextColor(Color.RED);
                }
                else {
                    VsTime.setText("VS");
                    VsTime.setTextColor(Color.BLACK);
                }
                name1.setText(pName.getOpponents().get(0).getOpponent().getName());
                name2.setText(pName.getOpponents().get(1).getOpponent().getName());

            }
            catch (Exception e)
            {}}
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClick(pName, getAdapterPosition());
            }
            try {
                Intent intent = new Intent(context, GameDetails.class);

                Log.i("status", position+"" );
                Log.i("status", pName.getOpponents().get(0).getOpponent().getName() + " VS " + pName.getOpponents().get(1).getOpponent().getName()+"" );
                intent.putExtra("Neamteam1", pName.getOpponents().get(0).getOpponent().getName());
                intent.putExtra("Neamteam2", pName.getOpponents().get(1).getOpponent().getName());
                intent.putExtra("Imgteam1", pName.getOpponents().get(0).getOpponent().getImageUrl());
                intent.putExtra("Imgteam2", pName.getOpponents().get(1).getOpponent().getImageUrl());
                intent.putExtra("Idteam1", pName.getOpponents().get(0).getOpponent().getId());
                intent.putExtra("Idteam2", pName.getOpponents().get(1).getOpponent().getId());
                intent.putExtra("position", position);
                context.startActivity(intent);
                Toast.makeText(context,pName.getOpponents().get(0).getOpponent().getName(),Toast.LENGTH_SHORT).show();
            }catch (Exception e){}

        }

    }

    public interface ItemListener {
        void onItemClick(Game pName, int position);
    }
}
