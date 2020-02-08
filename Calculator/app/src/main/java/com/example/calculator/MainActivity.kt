package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.tab_sum -> SumFragment()
                R.id.tab_sub -> SubFragment()
                R.id.tab_div -> DivFragment()
                R.id.tab_mult -> MultFragment()
                R.id.tab_about -> AboutFragment()
                else -> null
            }

            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, it)
                    .commit()
            }

            true
        }

        navView.selectedItemId = R.id.tab_sum
    }
}
