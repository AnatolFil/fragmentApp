package com.example.fragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavMenu = findViewById(R.id.bottom_navigation_view)

        bottomNavMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment_1 -> {replaceFragment(MyFirstFragment())}
                R.id.fragment_2 -> {replaceFragment(MySecondFragment())}
            }

            true
        }

        bottomNavMenu.selectedItemId = R.id.fragment_1
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }
}