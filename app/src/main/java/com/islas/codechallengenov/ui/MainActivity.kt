package com.islas.codechallengenov.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.islas.codechallengenov.R

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.mainFragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
    }
}
