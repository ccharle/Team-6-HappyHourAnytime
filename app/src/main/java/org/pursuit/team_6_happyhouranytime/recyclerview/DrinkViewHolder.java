package org.pursuit.team_6_happyhouranytime.recyclerview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.team_6_happyhouranytime.NameOrIngredientActivityDisplay;
import org.pursuit.team_6_happyhouranytime.R;
import org.pursuit.team_6_happyhouranytime.models.Drinks;

class DrinkViewHolder extends RecyclerView.ViewHolder {

    private TextView drinkNameView;


    public DrinkViewHolder(@NonNull View itemView) {
        super(itemView);
        drinkNameView = itemView.findViewById(R.id.drink_name_view);
    }

    public void onBind(Drinks drink) {
        drinkNameView.setText(drink.getStrDrink());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NameOrIngredientActivityDisplay.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}