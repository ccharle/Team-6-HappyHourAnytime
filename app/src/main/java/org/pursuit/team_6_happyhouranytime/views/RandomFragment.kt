package org.pursuit.team_6_happyhouranytime.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.random_drinks.*
import org.pursuit.team_6_happyhouranytime.R
import org.pursuit.team_6_happyhouranytime.model.Model
import org.pursuit.team_6_happyhouranytime.network.CocktailService
import org.pursuit.team_6_happyhouranytime.presentation.MainContract
import org.pursuit.team_6_happyhouranytime.presenter.Presenter

class RandomFragment : Fragment(), MainContract.View {

    lateinit var instanceOfPresenter: Presenter


    private val cocktailService by lazy {
        CocktailService.create()


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instanceOfPresenter = Presenter(cocktailService, this)
        instanceOfPresenter.getRandomDrinks()


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.random_drinks, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bttn_fab.setOnClickListener { instanceOfPresenter.getRandomDrinks() }

    }

    override fun showDrink(imgUri: String?) {
        Picasso.get().load(imgUri).into(imgvw_rndm_cktail)


    }
}