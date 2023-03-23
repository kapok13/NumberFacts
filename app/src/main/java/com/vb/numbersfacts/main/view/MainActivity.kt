package com.vb.numbersfacts.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.vb.numbersfacts.R
import com.vb.numbersfacts.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { MainActivityBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.mainToolbar)
        binding.mainToolbar.setupWithNavController(
            findNavController(R.id.main_nav_host_fragment),
            AppBarConfiguration(findNavController(R.id.main_nav_host_fragment).graph)
        )
    }
}
