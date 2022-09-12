package com.jmyebenes.curriculum.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.jmyebenes.curriculum.R
import com.jmyebenes.curriculum.core.extensions.gone
import com.jmyebenes.curriculum.core.extensions.visible
import com.jmyebenes.curriculum.core.extensions.visibleOrGone
import com.jmyebenes.curriculum.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navView: BottomNavigationView = binding.navView

        navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_about,
                R.id.navigation_work,
                R.id.navigation_studies,
                R.id.navigation_contact
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.workDetailFragment -> hideBottomNav()
                R.id.projectDetailFragment -> hideBottomNav()
                else -> showBottomNav()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    fun setToolbarTitle(title: String) {
        binding.toolbar.title = title
    }

    fun showLoader(show: Boolean) {
        binding.loader.root.visibleOrGone(show)
    }

    fun showError(errorMessage: String) {
        Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_SHORT).show()
    }

    private fun showBottomNav() {
        binding.navView.visible()
    }

    private fun hideBottomNav() {
        binding.navView.gone()
    }
}