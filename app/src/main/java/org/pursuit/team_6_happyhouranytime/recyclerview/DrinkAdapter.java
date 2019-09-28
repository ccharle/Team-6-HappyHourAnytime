package org.pursuit.team_6_happyhouranytime.recyclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.pursuit.team_6_happyhouranytime.R;
import org.pursuit.team_6_happyhouranytime.model.Response;

import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkViewHolder> {

    private List<Response> cocktailList;

    public DrinkAdapter(List<Response> cocktailList) {
        this.cocktailList = cocktailList;
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
      drinkViewHolder.onBind(cocktailList.get(i));
    }

    @Override
    public int getItemCount() {
        return cocktailList.size();
    }

    public void setData(List<Response> newDrinkList) {
        this.cocktailList = newDrinkList;
        notifyDataSetChanged();
    }
}
