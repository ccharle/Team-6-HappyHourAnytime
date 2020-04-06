package org.pursuit.team_6_happyhouranytime.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import org.pursuit.team_6_happyhouranytime.model.CocktailModel

class  CocktailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    val cocktailName: String = TODO()
    val cocktailModel: MutableLiveData<List<CocktailModel>> = TODO()


}