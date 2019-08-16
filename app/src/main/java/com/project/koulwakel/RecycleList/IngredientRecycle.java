package com.project.koulwakel.RecycleList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.koulwakel.FridgeFragment;
import com.project.koulwakel.R;
import com.project.koulwakel.entity.IngeridentRecycle;
import com.project.koulwakel.entity.Ingredient;

import java.util.List;

public class IngredientRecycle extends RecyclerView.Adapter<IngredientRecycle.MyViewHolder> {

    private Context mContext ;
    private List<IngeridentRecycle> mData ;

    public IngredientRecycle(Context mContext, List<IngeridentRecycle> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
     /*   View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_view_ingredient,,false);
        return new MyViewHolder(view);*/
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view_ingredient , viewGroup ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.ingredient_title.setText(mData.get(i).getTitleIngredient());
        myViewHolder.img_ingredient.setImageResource(mData.get(i).getImgIngredient());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ingredient_title;
        ImageView img_ingredient;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            ingredient_title = (TextView) itemView.findViewById(R.id.ingredient_title_id) ;
            img_ingredient = (ImageView) itemView.findViewById(R.id.ingredient_image_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);

        }
    }
}
