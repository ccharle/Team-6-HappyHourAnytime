package org.pursuit.team_6_happyhouranytime.recyclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.team_6_happyhouranytime.R;
import org.pursuit.team_6_happyhouranytime.models.Cocktail;

class DrinkViewHolder extends RecyclerView.ViewHolder {
    private final String ID_KEY = "identification";

    private TextView drinkNameView;

    public DrinkViewHolder(@NonNull View itemView) {
        super(itemView);
        drinkNameView = itemView.findViewById(R.id.drink_name_view);
    }

    public void onBind(final Cocktail drink) {
        drinkNameView.setText(drink.getStrDrink());
    }

}
