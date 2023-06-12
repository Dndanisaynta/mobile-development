package com.captsone.pantura.view.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import com.captsone.pantura.R
import com.captsone.pantura.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navHostController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerBase) as NavHostFragment
        navHostController = navHostFragment.navController
        binding.bottomAppBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    navHostController.navigate(R.id.homeFragment)
                    true
                }
                R.id.addFragment -> {
                    navHostController.navigate(R.id.addFragment)
                    true
                }
                R.id.profileFragment -> {
                    navHostController.navigate(R.id.profileFragment)
                    true
                }
                else -> {
                    false
                }
            }
        }

    }
}