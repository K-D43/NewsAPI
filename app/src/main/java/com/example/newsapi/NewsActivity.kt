package com.example.newsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapi.databinding.ActivityNewsBinding
import com.example.newsapi.fragments.BreakingNewsFragment
import com.example.newsapi.fragments.SavedNewsFragment
import com.example.newsapi.fragments.SearchNewsFragment

class NewsActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFragment(BreakingNewsFragment())

        binding.bottomNavigationView.setOnItemSelectedListener { it->
            when(it.itemId){
                R.id.breakingNewsFragment->{
                    setupFragment(BreakingNewsFragment())
                }
                R.id.savedNewsFragment->{
                    setupFragment(SavedNewsFragment())
                }
                R.id.searchNewsFragment->{
                    setupFragment(SearchNewsFragment())
                }
                else->false
            }
            true
        }


    }
    fun setupFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.newsNavHostFragment,fragment)
            .commit()
    }
}