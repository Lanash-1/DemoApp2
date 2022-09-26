package com.example.demoapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val personFragment = PersonFragment()
        val homeFragment = HomeFragment()
        val settingsFragment = SettingsFragment()
        
        setCurrentFragment(personFragment, "person")

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    setCurrentFragment(homeFragment, "home")
                }
                R.id.person -> setCurrentFragment(personFragment, "person")
                R.id.settings -> setCurrentFragment(settingsFragment, "settings")
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment, name: String) {
        supportFragmentManager.commit{
//            addToBackStack(name)
            replace(R.id.fragmentLayout, fragment)
        }
    }




}