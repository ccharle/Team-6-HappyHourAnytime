package org.pursuit.team_6_happyhouranytime.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.team_6_happyhouranytime.R;
import org.pursuit.team_6_happyhouranytime.models.Drinks;
import org.pursuit.team_6_happyhouranytime.models.DrinksResponse;
import org.pursuit.team_6_happyhouranytime.network.BartenderService;
import org.pursuit.team_6_happyhouranytime.network.ServiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomDrinksFragment extends Fragment {

    private static final String TAG = "random";

    private CoordinatorLayout rootLayout;
    private TextView randomDrinkSelectedTextview;
    private TextView ingredientsTextView;
    private TextView randomInstuctions;
    private ImageView randomDrinkSelectedImageView;
    private FloatingActionButton floatingActionButton;
    List<String> drinkIngredients = new ArrayList<>();

    private List<Drinks> drinkList;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public RandomDrinksFragment() {
    }

    public static RandomDrinksFragment newInstance(String param1, String param2) {
        RandomDrinksFragment fragment = new RandomDrinksFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.random_drinks, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews(view);
        getRandomDrinks();
        viewBehaviours();
    }

    public void setViews(View v) {
        rootLayout = v.findViewById(R.id.random_drinks_rootlayout);
        randomDrinkSelectedTextview = v.findViewById(R.id.name_of_random_drink_textview);
        ingredientsTextView = v.findViewById(R.id.random_drink_ingredients_textview);
        randomDrinkSelectedImageView = v.findViewById(R.id.random_selected_drink_imageView);
        randomInstuctions = v.findViewById(R.id.instructions);
        floatingActionButton = v.findViewById(R.id.fab);


    }

    public void getRandomDrinks() {
        BartenderService client = ServiceGenerator.createService(BartenderService.class);
        Call<DrinksResponse> drinksResponseCall = client.getRandomDrinks();
        drinksResponseCall.enqueue(new Callback<DrinksResponse>() {
            @Override
            public void onResponse(Call<DrinksResponse> call, Response<DrinksResponse> response) {
                Log.d(TAG, "OnResponse" + response.body());
                drinkList = new ArrayList<>();
                if (response.body() != null) {
                    drinkList.addAll(response.body().getDrinks());
                }


                for (int i = 0; i < drinkList.size(); i++) {
                    drinkIngredients.add(drinkList.get(i).getStrIngredient1());
                    drinkIngredients.add(drinkList.get(i).getStrIngredient2());
                    drinkIngredients.add(drinkList.get(i).getStrIngredient3());
                    drinkIngredients.add(drinkList.get(i).getStrIngredient4());
                    drinkIngredients.add(drinkList.get(i).getStrIngredient5());
                    drinkIngredients.add(drinkList.get(i).getStrIngredient6());
                    drinkIngredients.add(drinkList.get(i).getStrIngredient7());
                    drinkIngredients.add(drinkList.get(i).getStrIngredient8());
                    drinkIngredients.add(drinkList.get(i).getStrIngredient9());
                    drinkIngredients.add(drinkList.get(i).getStrIngredient10());
                    drinkIngredients.add(drinkList.get(i).getStrIngredient11());
                    drinkIngredients.add(drinkList.get(i).getStrIngredient12());
                    drinkIngredients.add(drinkList.get(i).getStrIngredient13());
                    drinkIngredients.add(drinkList.get(i).getStrIngredient14());
                    drinkIngredients.add(drinkList.get(i).getStrIngredient15());

                    drinkIngredients.removeAll(Arrays.asList("", null));
                }
                for (int i = 0; i < drinkIngredients.size(); i++) {
                    ingredientsTextView.append(drinkIngredients.get(i));
                    ingredientsTextView.append("\n");

                }
                randomDrinkSelectedTextview.setText(drinkList.get(0).getStrDrink());

                String drinkInstruction = drinkList.get(0).getStrInstructions();

                randomInstuctions.setText(drinkInstruction);

                String drinkImage = drinkList.get(0).getStrDrinkThumb();
                Picasso.get()
                        .load(drinkImage)
                        .into(randomDrinkSelectedImageView);
            }

            @Override
            public void onFailure(Call<DrinksResponse> call, Throwable t) {
                Snackbar snackbar = Snackbar.make(rootLayout, "Check Connection", Snackbar.LENGTH_SHORT);
                snackbar.show();
                Log.d(TAG, t.getMessage());
            }
        });


    }

    private void viewBehaviours() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredientsTextView.setText(null);
                drinkIngredients.removeAll(drinkIngredients);
                getRandomDrinks();
            }
        });
    }


}

