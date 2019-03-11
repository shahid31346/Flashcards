package com.saishaddai.bwq

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.saishaddai.bwq.asynctask.PopulateDatabase
import com.saishaddai.bwq.fragment.DecksFragment
import com.saishaddai.bwq.fragment.SettingsFragment
import com.saishaddai.bwq.fragment.StatsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val tag = MainActivity::class.java.simpleName as String

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(android.R.style.ThemeOverlay_Material_Dark)
//        setTheme(android.R.style.ThemeOverlay_Material)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_decks
        Log.d(tag, "Navigation settled")

        setSupportActionBar(mainToolbar)
        supportActionBar?.setTitle(R.string.title_decks)
        supportActionBar?.setLogo(R.drawable.ic_dashboard_black_24dp)
        Log.d(tag, "Toolbar settled")


        PopulateDatabase(this@MainActivity).execute()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_stats -> {
                val fragment = StatsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit()
                mainToolbar.setTitle(R.string.title_stats)
                mainToolbar.setLogo(R.drawable.ic_stats)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_decks -> {
                val fragment = DecksFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit()
                mainToolbar.setTitle(R.string.title_decks)
                mainToolbar.setLogo(R.drawable.ic_dashboard_black_24dp)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                val fragment = SettingsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit()
                mainToolbar.setTitle(R.string.title_settings)
                mainToolbar.setLogo(R.drawable.ic_settings)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


}
