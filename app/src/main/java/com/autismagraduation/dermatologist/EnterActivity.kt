package com.autismagraduation.dermatologist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.autismagraduation.dermatologist.ui.enterapp.Login
import com.google.android.material.bottomnavigation.BottomNavigationView

class EnterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter)

        val navController = findNavController(R.id.fragmentContainerView)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigation.setupWithNavController(navController)


        bottomNavigation.setOnItemSelectedListener {

            when(it.itemId) {
                R.id.logout -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }

        }

    }
}