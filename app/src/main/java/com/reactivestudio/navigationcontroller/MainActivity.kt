package com.reactivestudio.navigationcontroller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val navController : NavController = findNavController(R.id.navHostFragment)
        appBarConfiguration = AppBarConfiguration.Builder(R.id.sampleListFragment).build()
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(this, R.id.navHostFragment).navigateUp()
    }
}
