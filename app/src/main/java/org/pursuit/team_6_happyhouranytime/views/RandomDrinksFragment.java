package org.pursuit.team_6_happyhouranytime.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import org.pursuit.team_6_happyhouranytime.R;
import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.network.ApiClient;
import org.pursuit.team_6_happyhouranytime.presentation.MainContract;
import org.pursuit.team_6_happyhouranytime.presenter.FragmentPresenter;
import org.pursuit.team_6_happyhouranytime.presenter.NetworkInteractor;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RandomDrinksFragment extends Fragment implements MainContract.View {
    private MainContract.FragPresenter fragPresenter;
    private NetworkInteractor networkInteractor;

    private static final String TAG = "random";

    @BindView(R.id.cocktail_name_textview)
    TextView cocktailNameTextView;
    TextView instructionsTextView;
    @BindView(R.id.random_cocktail_imageView)
    ImageView cocktailImageView;
    @BindView(R.id.random_drinks_rootlayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        networkRequest();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View childView = inflater.inflate(R.layout.random_drinks, container, false);
        fragPresenter = new FragmentPresenter(this, networkInteractor);
        ButterKnife.bind(this, childView);
        viewBehaviour();
        return childView;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


    @Override
    public void refreshData() {

    }

    @Override
    public void displayCocktailName(String cocktailName) {
        cocktailNameTextView.setText(cocktailName);
    }

    @Override
    public void displayCocktailImage(String imgUrl) {

        Picasso.get().load(imgUrl).into(cocktailImageView);

    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        fragPresenter.showError();

    }

    public void networkRequest() {
        final ApiClient apiClient = ApiClient.getInstance();
        networkInteractor = new NetworkInteractor(apiClient, getActivity());
        FragmentPresenter fragmentPresenter = new FragmentPresenter(this, networkInteractor);
        fragmentPresenter.requestData();
    }


    public void viewBehaviour() {
        floatingActionButton.setOnClickListener(v -> {
            networkRequest();
            Toast.makeText(RandomDrinksFragment.this.getActivity(), "Toasty", Toast.LENGTH_SHORT).show();

        });
    }

}




