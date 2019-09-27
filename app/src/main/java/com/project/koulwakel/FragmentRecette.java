package com.project.koulwakel;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.project.koulwakel.RecycleList.AdapterRecette;
import com.project.koulwakel.RecycleList.IngredientRecycle;
import com.project.koulwakel.entity.Recette;
import com.project.koulwakel.entity.Recipe;
import com.project.koulwakel.viewpager.AdapterRecetteJour;

import java.util.ArrayList;
import java.util.List;

public class FragmentRecette extends Fragment {

  ViewPager viewPager;
  AdapterRecetteJour adapter;
  List<Recette> models;
  Integer[] colors = null;
  ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recette ,container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
      NestedScrollView scrollView = (NestedScrollView)view.findViewById(R.id.scroll_view_id);
       final RelativeLayout relativeLayout = (RelativeLayout)view.findViewById(R.id.relativeLayout_recette_du_jour);
      RecyclerView recyclerViewRecette = (RecyclerView)view.findViewById(R.id.recycle_recette_id);
      models = new ArrayList<>();
      models.add(new Recette(R.drawable.back1, "Brochure", "Brochure is an informative paper document (often also used for advertising) that can be folded into a template"));
      models.add(new Recette(R.drawable.back1, "Brochure", "Brochure is an informative paper document (often also used for advertising) that can be folded into a template"));

      models.add(new Recette(R.drawable.back1, "Brochure", "Brochure is an informative paper document (often also used for advertising) that can be folded into a template"));
      adapter = new AdapterRecetteJour(models, getContext());
      viewPager = view.findViewById(R.id.viewPager);
      viewPager.setAdapter(adapter);
      viewPager.setPadding(150, 0, 150, 0);
      Integer[] colors_temp = {
//              getResources().getColor(R.color.color1),
//              getResources().getColor(R.color.color2),
//              getResources().getColor(R.color.color3),
//              getResources().getColor(R.color.color4),
//              getResources().getColor(R.color.color5),
//              getResources().getColor(R.color.color6),
//              getResources().getColor(R.color.color7),



      };
      colors = colors_temp;

      viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
      });

        List<Recipe>recipes = new ArrayList<>();
          recipes.add(new Recipe("toto","esay"));
          recipes.add(new Recipe("toto","esay"));
          recipes.add(new Recipe("toto","esay"));

      AdapterRecette adapterRecette = new AdapterRecette(getContext() , recipes);
      recyclerViewRecette.setLayoutManager(new GridLayoutManager(getContext(),1));
      recyclerViewRecette.setAdapter(adapterRecette);

    }
}
