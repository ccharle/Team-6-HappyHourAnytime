package org.pursuit.team_6_happyhouranytime.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import org.pursuit.team_6_happyhouranytime.views.InfoFragment
import org.pursuit.team_6_happyhouranytime.views.RandomFragment

class PagerAdapter(fragmentManger: FragmentManager) : FragmentPagerAdapter(fragmentManger){
private val randmUri : String = "https://i.imgur.com/Xd27r3s.png"


    override fun getItem(position: Int): Fragment {
        return when (position) {

            0 -> RandomFragment()
            1 -> InfoFragment.newInstance(randmUri)

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
//    private fun onSwitchFragment(): Fragment{
//        if ()
//
//
//    }
}