package com.autismagraduation.pharmacy

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class EnterActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences
    private lateinit var prefsEditor: SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter)

        //Create Shared Preferences
        prefs = getSharedPreferences("test", MODE_PRIVATE);
        prefsEditor = prefs.edit();

        val navController = findNavController(R.id.fragmentContainerView)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigation.setupWithNavController(navController)

        bottomNavigation.menu.findItem(R.id.logout)
            .setOnMenuItemClickListener { menuItem ->

                // remove token from shared prefs
                prefsEditor.remove("token")
                prefsEditor.apply()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                true
            }

    }

}