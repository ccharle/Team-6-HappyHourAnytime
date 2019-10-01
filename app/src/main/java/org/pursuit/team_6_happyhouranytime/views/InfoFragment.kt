package org.pursuit.team_6_happyhouranytime.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cocktail_info_layout.*
import org.pursuit.team_6_happyhouranytime.R
import org.pursuit.team_6_happyhouranytime.model.Model


private const val ARG_PARAM1 = "param1"


class InfoFragment : Fragment() {

    private var infoList: ArrayList<Model.Drinks>? = null
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            infoList = it.getParcelableArrayList(ARG_PARAM1)
            Toast.makeText(activity,"Upload",Toast.LENGTH_LONG).show()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.cocktail_info_layout, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Picasso.get().load(infoList?.get(0)?.strDrinkThumb).into(imgvw_randominfo)
        txtvw_info.text = infoList?.get(0)?.strDrink
    }


    override fun onDetach() {
        super.onDetach()
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: ArrayList<Model.Drinks>?): InfoFragment =
                InfoFragment().apply {
                    arguments = Bundle().apply {
                        putParcelableArrayList(ARG_PARAM1, param1)
                    }
                }
    }
}
