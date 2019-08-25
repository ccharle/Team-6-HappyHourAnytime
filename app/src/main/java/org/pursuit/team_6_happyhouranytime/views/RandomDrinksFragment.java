package org.pursuit.team_6_happyhouranytime.views;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.team_6_happyhouranytime.R;
import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.models.CocktailResponse;
import org.pursuit.team_6_happyhouranytime.network.ApiClient;
import org.pursuit.team_6_happyhouranytime.presentation.CocktailsContract;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomDrinksFragment extends Fragment {

    private static final String TAG = "random";


    private CocktailsContract fragCocktailsContract;

    @BindView(R.id.cocktail_name_textview)
    TextView cocktailNameTextView;
    TextView instructionsTextView;
    @BindView(R.id.random_cocktail_imageView)
    ImageView cocktailImageView;
    @BindView(R.id.random_drinks_rootlayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;
    private List<String> cockTailIngredients = new ArrayList<>();
    private ApiClient apiClient;
    private OnTabSelected onTabSelected;
    private List<Cocktail> drinkList;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public RandomDrinksFragment() {
    }

    public static RandomDrinksFragment newInstance(String param1, String param2) {
        RandomDrinksFragment randomDrinksFragment = new RandomDrinksFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        randomDrinksFragment.setArguments(args);
        return randomDrinksFragment;
    }

    @Override
   public void onAttach(Context context) {
       super.onAttach(context);
       if (context instanceof OnTabSelected) {
           onTabSelected = (OnTabSelected) context;
       } else {
           throw new RuntimeException(context.toString() + "Runtime Exception");
       }
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
        View childView = inflater.inflate(R.layout.random_drinks, container, false);
        ButterKnife.bind(this, childView);
        viewBehaviours();
        return childView;


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        getRandomCocktails();

    }

    private void getRandomCocktails() {

        apiClient = ApiClient.getInstance();
        apiClient.getRandom().enqueue(new Callback<CocktailResponse>() {
            @Override
            public void onResponse(Call<CocktailResponse> call, Response<CocktailResponse> response) {
                if (response.body() != null) {
                    drinkList = new ArrayList<>();
                    drinkList.addAll(response.body().getDrinks());
                    cocktailNameTextView.setText(drinkList.get(0).getStrDrink());
                    Picasso.get().load(drinkList.get(0).getStrDrinkThumb()).into(cocktailImageView);
                }

            }

            @Override
            public void onFailure(Call<CocktailResponse> call, Throwable t) {
                Log.d(TAG, "OnFailure" + t.getMessage());

            }
        });
    }


    private void viewBehaviours() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRandomCocktails();
            }
        });
    }
}




