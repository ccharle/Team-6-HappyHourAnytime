package org.pursuit.team_6_happyhouranytime;


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.pursuit.team_6_happyhouranytime.adapter.PagerAdapter
import org.pursuit.team_6_happyhouranytime.model.Model
import org.pursuit.team_6_happyhouranytime.views.RandomFragment


class MainActivity : AppCompatActivity(), RandomFragment.RandomFragmentListener {
    private var infoList1: ArrayList<Model.Drinks>? = null
    override fun getListResponse(infoList: List<Model.Drinks>) {
        if (infoList[0].idDrink != null) {
            infoList1?.addAll(infoList)

        } else {
            Toast.makeText(this,"null", Toast.LENGTH_LONG).show()

        }


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vwpagr_main.adapter = PagerAdapter(supportFragmentManager, infoList1)
        tablayout_info.setupWithViewPager(vwpagr_main)


    }


}



