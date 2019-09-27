package com.project.koulwakel.RecycleList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

//import com.project.koulwakel.FragmentAddQuantityIngredient;
import com.project.koulwakel.HomeActivity;
import com.project.koulwakel.R;
import com.project.koulwakel.entity.IngeridentRecycle;
import com.project.koulwakel.entity.Ingredient;

import java.util.List;

public class AdapterIngredient extends  RecyclerView.Adapter<AdapterIngredient.MyViewHolder> {

    private Context mContext ;
    private List<Ingredient> mData ;
    //private Dialog dialogQuantity ;
   // private Button finshBoutton ;

    public AdapterIngredient(Context mContext, List<Ingredient> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.card_view_ingredient , viewGroup ,false);
//
//        return new AdapterIngredient.MyViewHolder(view);
        View v ;
        v=LayoutInflater.from(mContext).inflate(R.layout.card_all_ingredient_recycle,viewGroup,false);
        final MyViewHolder myViewHolder= new MyViewHolder(v);

        return myViewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.ingredient_title.setText(mData.get(i).getName());
        myViewHolder.unitQuantity.setText(mData.get(i).getUnit_of_measure());
        myViewHolder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                      myViewHolder.quantity.setText(""+seekBar.getProgress()+"");
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ingredient_title;
        ImageView img_ingredient;
        CardView cardView ;
        SeekBar seekBar ;
        TextView quantity ;
        TextView unitQuantity;


        public MyViewHolder(View itemView) {
            super(itemView);

            ingredient_title = (TextView) itemView.findViewById(R.id.name_ingredient) ;
            img_ingredient = (ImageView) itemView.findViewById(R.id.ingredient_image_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_all_ingredient_id);
            seekBar =(SeekBar)itemView.findViewById(R.id.seekBar_quantit_id);
            quantity =(TextView)itemView.findViewById(R.id.text_quantity);
            unitQuantity =(TextView)itemView.findViewById(R.id.unit_quantity);
        }
    }
}
