package com.saishaddai.bwq

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.google.gson.Gson
import com.saishaddai.bwq.BuildConfig.DECKS_SOURCE
import com.saishaddai.bwq.adapter.DecksAdapter
import com.saishaddai.bwq.commons.FileUtilities
import com.saishaddai.bwq.model.Deck
import com.saishaddai.bwq.repository.InfoRetrieverFiles
import com.saishaddai.bwq.repository.InfoStoreRoom
import com.saishaddai.bwq.repository.InitialInfoRepository
import kotlinx.android.synthetic.main.activity_main_rv.*
import kotlinx.android.synthetic.main.fragment_decks.*
import kotlinx.android.synthetic.main.fragment_decks.main_toolbar
import kotlinx.android.synthetic.main.layout_loader.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var decksAvailable = mutableListOf("something" to "something")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        //setContentView(R.layout.activity_main_t)
        setContentView(R.layout.activity_main_rv)
        setSupportActionBar(main_toolbar)
        //navigationDrawerSetup()

        doAsync {
            loader_container.visibility = View.VISIBLE
            progress_bar.progress = 0


            val infoRetriever = InfoRetrieverFiles(assets)
            val infoStore = InfoStoreRoom()
            loader_message.text = getString(R.string.loader_initial_information)
            val initialInfoRepository = InitialInfoRepository(infoRetriever, infoStore)
            initialInfoRepository.initInfo()
            Log.d(TAG, "initialInfoRepository done")

            progress_bar.progress = 30


            //given all the decks, paint all the cards available
//            val decksAvailable = infoRetriever.getDecks()
//            progress_bar.progress = 0




            val contents = FileUtilities.getFileContents(assets, DECKS_SOURCE)
            val decks = Gson().fromJson(contents, Array<Deck>::class.java).sortedBy { it.priority }
            val listOfAvailableDecks = assets.list("")

            progress_bar.progress = 50
            for (deck in decks) {
                if (listOfAvailableDecks.contains(deck.source))
                    decksAvailable.add(deck.name to "true")
                else
                    decksAvailable.add(deck.name to "false")
            }



            progress_bar.progress = 100

            uiThread {
                if (progress_bar.progress == 100) {
                    loader_container.visibility = View.GONE
                    //decksRV.layoutManager  = GridLayoutManager(applicationContext, 2)
                    decksRV.layoutManager  = LinearLayoutManager(applicationContext)
                    decksRV.setHasFixedSize(true)
                    decksRV.adapter = DecksAdapter(decks)
                    progress_bar.progress = 0
                }
            }
        }




    }


//    private fun navigationDrawerSetup() {
//        val toggle = ActionBarDrawerToggle(
//            this, drawer_layout, main_toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
//        )
//        drawer_layout.addDrawerListener(toggle)
//        toggle.syncState()
//
//        nav_view.setNavigationItemSelectedListener(this)
//    }


//    override fun onBackPressed() {
//        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
//            drawer_layout.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
//    }

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

        //drawer_layout.closeDrawer(GravityCompat.START)
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

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

}
