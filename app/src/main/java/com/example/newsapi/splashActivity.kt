package com.example.newsapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapi.databinding.ActivityNewsBinding
import com.example.newsapi.databinding.ActivitySplashBinding
import com.example.newsapi.fragments.BreakingNewsFragment
import com.example.newsapi.fragments.SavedNewsFragment
import com.example.newsapi.fragments.SearchNewsFragment

class splashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.open.setOnClickListener {
            startActivity(Intent(this@splashActivity,NewsActivity::class.java))
        }


    }
}