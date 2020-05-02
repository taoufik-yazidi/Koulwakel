package com.project.koulwakel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.koulwakel.RecycleList.AdapterTag;
import com.project.koulwakel.RecycleList.IngredientRecycle;
import com.project.koulwakel.entity.Tag;

import java.util.ArrayList;
import java.util.List;


public class FragmentFilterRecherche extends Fragment {

    List<Tag>tags ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recherche_filter ,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tags = new ArrayList<>();
        tags.add(new Tag(Long.valueOf("1"),"toto"));
        tags.add(new Tag(Long.valueOf("1"),"toto"));
        tags.add(new Tag(Long.valueOf("1"),"toto"));


        RecyclerView recyclerViewTag = (RecyclerView) view.findViewById(R.id.recycler_tag_id);
        AdapterTag adapterTag = new AdapterTag(getContext() , tags);
        recyclerViewTag.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerViewTag.setAdapter(adapterTag);







    }
}
