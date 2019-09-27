package com.project.koulwakel.RecycleList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.project.koulwakel.R;
import com.project.koulwakel.entity.Ingredient;
import com.project.koulwakel.entity.Recipe;

import java.util.List;

public class AdapterRecette extends RecyclerView.Adapter<AdapterRecette.MyViewHolder> {



    private Context mContext ;
    private List<Recipe> mData ;

    public AdapterRecette(Context mContext, List<Recipe> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v ;
        v= LayoutInflater.from(mContext).inflate(R.layout.item_recycle_recette,viewGroup,false);
        MyViewHolder myViewHolder =new MyViewHolder(v);

        return myViewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        //myViewHolder.imgRecette.setImageResource(mData.get(i).get);
        myViewHolder.difficulty.setText(mData.get(i).getDifficulty());
        myViewHolder.titleRecette.setText(mData.get(i).getTitle());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleRecette;
        ImageView imgRecette;
        CardView cardView ;
        TextView difficulty ;

        public MyViewHolder(View itemView) {
            super(itemView);

            titleRecette = (TextView)itemView.findViewById(R.id.title_recette);
            imgRecette =(ImageView)itemView.findViewById(R.id.image_recette);
            cardView= (CardView)itemView.findViewById(R.id.card_recette_id);
            difficulty =(TextView)itemView.findViewById(R.id.difficulty);

        }
    }
}
