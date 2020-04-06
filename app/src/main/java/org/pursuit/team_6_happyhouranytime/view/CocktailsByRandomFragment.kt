package org.pursuit.team_6_happyhouranytime.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import org.pursuit.team_6_happyhouranytime.R
import org.pursuit.team_6_happyhouranytime.view.viewmodel.MainViewModel

class CocktailsByRandomFragment : Fragment() {
    private val mainViewModel: MainViewModel by viewModels(factoryProducer = { SavedStateViewModelFactory(requireActivity().application,this) })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.random_cocktail_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}