package com.saishaddai.bwq


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import com.saishaddai.bwq.adapter.CardsAdapter
import com.saishaddai.bwq.commons.FileUtils
import com.saishaddai.bwq.model.Card
import com.saishaddai.bwq.model.DECK_SIZE
import com.saishaddai.bwq.observer.CardActivityObserver
import kotlinx.android.synthetic.main.activity_cards.*
import org.jetbrains.anko.design.snackbar
import java.util.*

const val CARD_TYPE_ARG = "type"

class CardsActivity : AppCompatActivity() {

    private var type = ""

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        intent?.let {
            type = it.getStringExtra(CARD_TYPE_ARG)
        }

        val listOfCards: ArrayList<Card> = getAllCards(type)

        cardsPager.adapter = CardsAdapter(supportFragmentManager, listOfCards)
        lifecycle.addObserver(CardActivityObserver())

//        if(type == "Java") {
//            val listOfCards = getAllCards(type)
//            cardsPager.adapter = CardsAdapter(supportFragmentManager, listOfCards)
//        } else {
//            val listOfCards = getEmptyListOfCards()
//            cardsPager.adapter = CardsAdapter(supportFragmentManager, listOfCards)
//        }
    }

    private fun getAllCards(type: String): ArrayList<Card> {

        val result = ArrayList<Card>()
        val fileName = getFileForCards(type)
        if(fileName == "") {
            snackbar(cardsPager, "Nothing to show")
        }

//        println(assets.toString() + fileName)
        //val newFile = File(assets?.open(fileName))
        //println("walla" +  newFile)

        val contents = FileUtils.getFileContents(assets, fileName)
        if(contents == "") {
            snackbar(cardsPager, "Nothing to show")
        }

//        Log.e("walla", contents)


        val cardsArray = Gson().fromJson(contents, Array<Card>::class.java)
        for(cardItem in cardsArray) {
            result.add(cardItem)
        }

        val cardsArrayReduced = reduceListSize(result)


        //if(result.size > 0) {
            val finalCard = Card("", "", "", "")
            cardsArrayReduced.add(finalCard)

        //}


//        val contents  = File("file:///android_asset/" + fileName).readText(Charsets.UTF_8)
//        println("***" + contents)
//        assets
//        val reader: BufferedReader
//        try {
//            reader = BufferedReader(InputStreamReader(assets?.open(fileName)))
//
//            // do reading, usually loop until end of file reading
//            var mLine = ""
//            while ((mLine = reader.readLine()) != null) {
//
//
//            }
//        } catch (IOException e) {
//            //log the exception
//        } finally {
//            try {
//                reader?.close()
//            } catch(e: IOException) {
//
//            }
//        }
//        return result
        return cardsArrayReduced
    }

    private fun reduceListSize(arrayList: ArrayList<Card>): ArrayList<Card> {
        if(arrayList.size < DECK_SIZE)
            return arrayList

        val result = ArrayList<Card>()
        val indexArray : MutableSet<Int> = getIndexesForReducedArray(arrayList.size)
        for(i in indexArray) {
            result.add(arrayList[i])
        }

        return result
    }

    private fun getIndexesForReducedArray(size: Int): MutableSet<Int> {
        val indexesArray = mutableSetOf<Int>()
        val random = Random()
        while(indexesArray.size !=  DECK_SIZE) {
            indexesArray.add(random.nextInt(size))
        }
        return indexesArray
    }

    private fun getFileForCards(type: String): String {
        when (type) {
            "Java" -> return "java_cards.json"
            "Android" -> return "android_cards.json"
            "Kotlin" -> return "kotlin_cards.json"
            "Data Structures" -> return "data_structures_cards.json"
            "Algorithms" -> return "algorithms_cards.json"
            "Android Libraries" -> return "android_libraries_cards.json"
        }
        return ""
    }

//    private fun getEmptyListOfCards(): ArrayList<ViewModel.Card> {
//        val x = "\"[\"Android\",\"Algorithms\"]\""
//        val listOfCards = arrayListOf<ViewModel.Card>()
//        val finalCard = ViewModel.Card("B", "", "")
//        listOfCards.add(finalCard)
//        return listOfCards
//    }



//    override fun onBackPressed() {
//        super.onBackPressed()
//    }
}
