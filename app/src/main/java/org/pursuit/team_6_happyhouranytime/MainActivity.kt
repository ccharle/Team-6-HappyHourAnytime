package org.pursuit.team_6_happyhouranytime;


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.pursuit.team_6_happyhouranytime.adapter.PagerAdapter
import org.pursuit.team_6_happyhouranytime.model.Model
import org.pursuit.team_6_happyhouranytime.presentation.MainContract
import org.pursuit.team_6_happyhouranytime.views.RandomFragment


class MainActivity : AppCompatActivity(),RandomFragment.RandomFragmentListener ,MainContract.View{
    override fun getList(drinkList: List<Model.Drinks>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDrink(imgUri: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListResponse(imgUri: String) {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vwpagr_main.adapter = PagerAdapter(supportFragmentManager)
        tablayout_info.setupWithViewPager(vwpagr_main)


    }


}



