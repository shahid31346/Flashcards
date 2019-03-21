package com.saishaddai.bwq

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_decks.*
import kotlinx.android.synthetic.main.layout_loader.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val tag = MainActivity::class.java.simpleName as String
    private val showContent = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)
        navigationDrawerSetup()


        doAsync {
            loader_container.visibility = View.VISIBLE
            progress_bar.progress = 20
            Log.d(tag, "progress bar set" + progress_bar.progress)
            Thread.sleep(2000)

            progress_bar.progress = 40
            Log.d(tag, "progress bar set" + progress_bar.progress)
            Thread.sleep(2000)

            progress_bar.progress = 60
            Log.d(tag, "progress bar set" + progress_bar.progress)
            Thread.sleep(2000)

            progress_bar.progress = 80
            Log.d(tag, "progress bar set" + progress_bar.progress)
            Thread.sleep(2000)

            progress_bar.progress = 100
            Log.d(tag, "progress bar set" + progress_bar.progress)
            Thread.sleep(2000)

            uiThread {
                if (progress_bar.progress == 100) {
                    loader_container.visibility = View.GONE
                    progress_bar.progress = 0
                }
            }


        }

        decksSetup()

    }


    private fun decksSetup() {
        android_card.setOnClickListener {
            if (showContent)
                startActivity<CardsActivity>("type" to "Android")
            else
                snackbar(it, R.string.warning_no_content)
        }
        //        android_card.setOnClickListener { startActivity<Main2Activity>("type" to "Android") }
        java_card.setOnClickListener { startActivity<CardsActivity>("type" to "Java") }
        kotlin_card.setOnClickListener { startActivity<CardsActivity>("type" to "Kotlin") }

        data_structures_card.setOnClickListener { startActivity<CardsActivity>("type" to "Data Structures") }
        algorithms_card.setOnClickListener { startActivity<CardsActivity>("type" to "Algorithms") }
        kotlin_libraries_card.setOnClickListener { startActivity<CardsActivity>("type" to "Kotlin Libraries") }
    }

    private fun navigationDrawerSetup() {
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, main_toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        super.onCreateOptionsMenu(menu)
//        //menuInflater?.inflate(R.menu.navigation, menu)
//        return true
//    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
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

//    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//        when (item.itemId) {
//            R.id.navigation_stats -> {
//                val fragment = StatsFragment()
//                supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit()
//                mainToolbar.setTitle(R.string.title_stats)
//                mainToolbar.setLogo(R.drawable.ic_stats)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_decks -> {
//                val fragment = DecksFragment()
//                supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit()
//                mainToolbar.setTitle(R.string.title_decks)
//                mainToolbar.setLogo(R.drawable.ic_dashboard_black_24dp)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_settings -> {
//                val fragment = SettingsFragment()
//                supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit()
//                mainToolbar.setTitle(R.string.title_settings)
//                mainToolbar.setLogo(R.drawable.ic_settings)
//                return@OnNavigationItemSelectedListener true
//            }
//        }
//        false
//    }


}
