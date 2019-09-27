//package com.project.koulwakel;
//
//import android.app.AlertDialog;
//import android.app.Dialog;
//import android.content.Context;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.DialogFragment;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//public class FragmentAddQuantityIngredient extends DialogFragment {
//
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        Context context = getActivity();
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        View view = getActivity().getLayoutInflater().inflate(R.layout.add_quantity_ingredient_add, null);
//        AlertDialog dialog = builder.create();
//        builder.setView(view);
//        dialog.setContentView(R.layout.add_quantity_ingredient_add);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        return dialog;
//    }
//}
