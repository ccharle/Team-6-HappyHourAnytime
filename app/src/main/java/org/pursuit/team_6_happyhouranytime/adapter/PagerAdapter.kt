package org.pursuit.team_6_happyhouranytime.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import org.pursuit.team_6_happyhouranytime.model.Model
import org.pursuit.team_6_happyhouranytime.views.InfoFragment
import org.pursuit.team_6_happyhouranytime.views.RandomFragment

class PagerAdapter(fragmentManger: FragmentManager, private val array: ArrayList<Model.Drinks>?) : FragmentPagerAdapter(fragmentManger) {
    override fun getItem(position: Int): Fragment {
        return when (position) {

            0 -> RandomFragment()
            1 -> InfoFragment.newInstance(array)
            else -> RandomFragment()
        }

    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Cocktails"
            1 -> "Ingredients"
            else -> ""

        }
    }




}