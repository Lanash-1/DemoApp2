package com.example.demoapp2

import android.annotation.SuppressLint
import android.content.ClipData
import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.view.menu.MenuView
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val personFragment = PersonFragment()
        val homeFragment = HomeFragment()
        val settingsFragment = SettingsFragment()
        
        setCurrentFragment(personFragment, "person")


        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    setCurrentFragment(homeFragment, "home")
                }
                R.id.person -> setCurrentFragment(personFragment, "person")
                R.id.settings -> {
                    setCurrentFragment(settingsFragment, "settings")
                }
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment, name: String) {
        supportFragmentManager.commit{
            addToBackStack(name)
            setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out)
            replace(R.id.fragmentLayout, fragment)
        }
    }




}