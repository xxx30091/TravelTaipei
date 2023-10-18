package com.example.traveltaipei

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import com.example.traveltaipei.databinding.ActivityMainBinding
import com.example.traveltaipei.utils.CurrentFragmentType

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        setupNavController()
    }

    private fun setupNavController() {
        findNavController(R.id.navHostFragment).addOnDestinationChangedListener { controller: NavController, _: NavDestination, _: Bundle? ->
            viewModel.currentFragmentType.value = when (controller.currentDestination?.id) {
                R.id.attractionsFragment -> CurrentFragmentType.ATTRACTIONS
                R.id.detailFragment -> CurrentFragmentType.DETAIL
                else -> viewModel.currentFragmentType.value
            }
        }
    }
}