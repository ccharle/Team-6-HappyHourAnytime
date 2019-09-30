package org.pursuit.team_6_happyhouranytime;


import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

import org.pursuit.team_6_happyhouranytime.presentation.MainContract;
import org.pursuit.team_6_happyhouranytime.presenter.Presenter;
import org.pursuit.team_6_happyhouranytime.views.RandomFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import kotlinx.android.synthetic.main.activity_main.*


 class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createFragment()
    }

    private fun createFragment() {
        val randomFragment = RandomFragment()
        supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, randomFragment)
                .addToBackStack(null)
                .commit()


    }

}
