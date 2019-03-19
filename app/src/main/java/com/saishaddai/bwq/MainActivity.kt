package com.saishaddai.bwq

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.View
import com.saishaddai.bwq.asynctask.PopulateDatabase
import com.saishaddai.bwq.fragment.DecksFragment
import com.saishaddai.bwq.fragment.SettingsFragment
import com.saishaddai.bwq.fragment.StatsFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.startActivity
import android.support.v4.app.NavUtils
import android.view.MenuItem
import kotlinx.android.synthetic.main.fragment_decks.*


class MainActivity : AppCompatActivity() {

    private val tag = MainActivity::class.java.simpleName as String

    override fun onCreate(savedInstanceState: Bundle?) {
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
////            setTheme(android.R.style.ThemeOverlay_Material_Dark)
//        setTheme(android.R.style.ThemeOverlay_Material)
//        }

        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(R.layout.fragment_decks)


//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
//        navigation.selectedItemId = R.id.navigation_decks
        Log.d(tag, "Navigation settled")

        //.setOnClickListener(openCardsButtonListener)

        setSupportActionBar(mainToolbar)
        supportActionBar?.setTitle(R.string.app_title)
        //supportActionBar?.setLogo(R.drawable.ic_dashboard_black_24dp)

        android_card.setOnClickListener{ startActivity<CardsActivity>("type" to "Android") }
        java_card.setOnClickListener { startActivity<CardsActivity>("type" to "Java") }
        kotlin_card.setOnClickListener{ startActivity<CardsActivity>("type" to "Kotlin") }

        data_structures_card.setOnClickListener{ startActivity<CardsActivity>("type" to "Data Structures") }
        algorithms_card.setOnClickListener { startActivity<CardsActivity>("type" to "Algorithms") }
        kotlin_libraries_card.setOnClickListener{ startActivity<CardsActivity>("type" to "Kotlin Libraries") }


        PopulateDatabase(this@MainActivity).execute()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        //menuInflater?.inflate(R.menu.navigation, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.java_cards -> {
//                startActivity<CardsActivity>("type" to "Java")
//                return true
//            }
//            R.id.kotlin_cards -> {
//                startActivity<CardsActivity>("type" to "Kotlin")
//                return true
//            }
//
//        }
        return true
    }

//    private val openCardsButtonListener = View.OnClickListener {
//        startActivity<CardsActivity>()
//    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
//            R.id.navigation_stats -> {
//                val fragment = StatsFragment()
//                supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit()
//                mainToolbar.setTitle(R.string.title_stats)
//                mainToolbar.setLogo(R.drawable.ic_stats)
//                return@OnNavigationItemSelectedListener true
//            }
            R.id.navigation_decks -> {
                val fragment = DecksFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit()
                mainToolbar.setTitle(R.string.title_decks)
                mainToolbar.setLogo(R.drawable.ic_dashboard_black_24dp)
                return@OnNavigationItemSelectedListener true
            }
//            R.id.navigation_settings -> {
//                val fragment = SettingsFragment()
//                supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit()
//                mainToolbar.setTitle(R.string.title_settings)
//                mainToolbar.setLogo(R.drawable.ic_settings)
//                return@OnNavigationItemSelectedListener true
//            }
        }
        false
    }


}
