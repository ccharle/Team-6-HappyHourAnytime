package org.pursuit.team_6_happyhouranytime.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import org.pursuit.team_6_happyhouranytime.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RandomDrinksFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RandomDrinksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RandomDrinksFragment extends Fragment {

    private static final String TAG = "random";

    private TextView randomDrinkSelectedTextview;
    private TextView randomDrinkSelectedIngredientsTextView;
    private TextView randomInstuctions;
    private ImageView randomDrinkSelectedImageView;

    private List<Drinks> drinkList;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public RandomDrinksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RandomDrinksFragment.
     */
    // TODO: Rename and change types and number of parameters
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
        getRetrofitCall();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void setViews(View v) {
        randomDrinkSelectedTextview = v.findViewById(R.id.name_of_random_drink_textview);
        randomDrinkSelectedIngredientsTextView = v.findViewById(R.id.random_drink_ingredients_textview);
        randomDrinkSelectedImageView = v.findViewById(R.id.random_selected_drink_imageView);
        randomInstuctions = v.findViewById(R.id.instructions);


    }

    public void getRetrofitCall() {
        RetrofitSingleton.getInstance()
                .getBartenderService()
                .getRandomDrinks()
                .enqueue(new Callback<DrinksResponse>() {
                    @Override
                    public void onResponse(Call<DrinksResponse> call, Response<DrinksResponse> response) {
                        Log.d(TAG, "OnResponse" + response.body());
                        drinkList = new ArrayList<>();
                        if (response.body() != null) {
                            drinkList.addAll(response.body().getDrinks());
                        }
                        randomDrinkSelectedTextview.setText(drinkList.get(0).getStrDrink());

                        String firstIngredient = drinkList.get(0).getStrIngredient1();
                        String secondIngredient = drinkList.get(0).getStrIngredient2();
                        String thirdIngredient = drinkList.get(0).getStrIngredient3();

                        String drinkInstruction = drinkList.get(0).getStrInstructions();

                        randomDrinkSelectedIngredientsTextView.setText(firstIngredient + "\n " + secondIngredient + "\n" + thirdIngredient);
                        randomInstuctions.setText(drinkInstruction);

                        String drinkImage = drinkList.get(0).getStrDrinkThumb();
                        Picasso.get()
                                .load(drinkImage)
                                .into(randomDrinkSelectedImageView);
                    }

                    @Override
                    public void onFailure(Call<DrinksResponse> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                });
    }


}

