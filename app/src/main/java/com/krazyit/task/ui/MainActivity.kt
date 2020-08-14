package com.krazyit.task.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.krazyit.task.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavigation();
    }

    private fun initNavigation() {
        val hostFragment = (supportFragmentManager
            .findFragmentById(R.id.hostFragment) as NavHostFragment?)!!
        NavigationUI.setupWithNavController(navView, hostFragment.navController)
    }
}
