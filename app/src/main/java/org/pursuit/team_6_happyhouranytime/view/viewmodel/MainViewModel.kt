package org.pursuit.team_6_happyhouranytime.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import org.apache.maven.model.Repository
import org.pursuit.team_6_happyhouranytime.model.CocktailModel
import org.pursuit.team_6_happyhouranytime.repository.CocktailRepository
import org.pursuit.team_6_happyhouranytime.repository.Resource

class MainViewModel : ViewModel() {
    val cocktailName: String = TODO()
    val cocktailModel: MutableLiveData<Resource<CocktailModel>> = MutableLiveData()
    lateinit var randomCocktail: MutableLiveData<Resource<CocktailModel>>
    fun getRandomCocktail() {
        randomCocktail = CocktailRepository.getRandomCocktail()
    }
}