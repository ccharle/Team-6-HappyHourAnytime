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
import org.pursuit.team_6_happyhouranytime.presentation.MainContract
import org.pursuit.team_6_happyhouranytime.presenter.Presenter


private const val ARG_PARAM1 = "param1"


class InfoFragment : Fragment(), MainContract.View {
    override fun getList(drinkList: List<Model.Drinks>) {


    }

    override fun showDrink(imgUri: String?) {
        Picasso.get().load(imgUri).into(imgvw_randominfo)


    }


    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.cocktail_info_layout, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }


    override fun onDetach() {
        super.onDetach()
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String?): InfoFragment =
                InfoFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)

                    }
                }
    }
}
