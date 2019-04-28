package org.pursuit.team_6_happyhouranytime.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.team_6_happyhouranytime.R;
import org.pursuit.team_6_happyhouranytime.models.Drinks;

import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkViewHolder> {

    private List<Drinks> drinksList;

    public DrinkAdapter(List<Drinks> drinksList) {
        this.drinksList = drinksList;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.itemview_drinks_by_name, viewGroup, false);
        return new DrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder drinkViewHolder, int i) {
      drinkViewHolder.onBind(drinksList.get(i));
    }

    @Override
    public int getItemCount() {
        return drinksList.size();
    }

    public void setData(List<Drinks> newDrinkList) {
        this.drinksList = newDrinkList;
        notifyDataSetChanged();
    }
}
