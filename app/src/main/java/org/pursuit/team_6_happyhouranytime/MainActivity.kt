package org.pursuit.team_6_happyhouranytime;


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.pursuit.team_6_happyhouranytime.view.viewmodel.MainViewModel

private const val TAG = "OnResponse"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testCall()

    }

    private fun testCall(){
       val mainViewModel = MainViewModel()
        mainViewModel.getRandomCocktail()
    }
}






