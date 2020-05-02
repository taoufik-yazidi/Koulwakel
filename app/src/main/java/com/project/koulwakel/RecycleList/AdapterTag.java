package com.project.koulwakel.RecycleList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.project.koulwakel.R;
import com.project.koulwakel.entity.Tag;

import java.util.List;

public class AdapterTag  extends  RecyclerView.Adapter<AdapterTag.MyViewHolder> {


    private Context mContext ;
    private List<Tag> mData ;

    public AdapterTag(Context mContext, List<Tag> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v ;
        v= LayoutInflater.from(mContext).inflate(R.layout.card_recycler_tag,viewGroup,false);
        AdapterTag.MyViewHolder myViewHolder =new AdapterTag.MyViewHolder(v);
        return myViewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
         myViewHolder.tagName.setText(mData.get(i).getLabel());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

      TextView tagName ;
      CardView cardViewTag ;


        public MyViewHolder(View itemView) {
            super(itemView);
          tagName = (TextView)itemView.findViewById(R.id.tag_name);
          cardViewTag=(CardView)itemView.findViewById(R.id.card_Tag_id);

        }
    }
}
