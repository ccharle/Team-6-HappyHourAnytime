package org.pursuit.team_6_happyhouranytime;


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.pursuit.team_6_happyhouranytime.adapter.PagerAdapter
import org.pursuit.team_6_happyhouranytime.model.Model
import org.pursuit.team_6_happyhouranytime.network.CocktailService
import org.pursuit.team_6_happyhouranytime.presentation.MainContract
import org.pursuit.team_6_happyhouranytime.presenter.Presenter
import org.pursuit.team_6_happyhouranytime.views.RandomFragment


class MainActivity : AppCompatActivity(), RandomFragment.RandomFragmentListener, MainContract.View {
    lateinit var instanceOfPresenter: Presenter
    private val cocktailService by lazy {
        CocktailService.create()


    }

    override fun getList(drinkList: List<Model.Drinks>) {

    }

    override fun showDrink(imgUri: String?) {
    }

    override fun getListResponse(imgUri: String) {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instanceOfPresenter = Presenter(cocktailService, this)
        vwpagr_main.adapter = PagerAdapter(supportFragmentManager,cocktailService)
        tablayout_info.setupWithViewPager(vwpagr_main)


    }


}



