package com.saishaddai.bwq


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import com.saishaddai.bwq.adapter.CardsAdapter
import com.saishaddai.bwq.commons.FileUtilities
import com.saishaddai.bwq.model.Card
import com.saishaddai.bwq.model.Constants.Companion.DECK_SIZE
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
    }

    private fun getAllCards(type: String): ArrayList<Card> {
        val result = ArrayList<Card>()
        val fileName = getFileForCards(type)
        val nothingToShowText = getString(R.string.no_cards_found_error)
        if(fileName == "") {
            snackbar(cardsPager, nothingToShowText)
        }

        val contents = FileUtilities.getFileContents(assets, fileName)
        if(contents == "")
            snackbar(cardsPager, nothingToShowText)


        val cardsArray = Gson().fromJson(contents, Array<Card>::class.java)
        for(cardItem in cardsArray)
            result.add(cardItem)

        val cardsArrayReduced = reduceListSize(result)
        Log.d(TAG, "original size: " + result.size + ", reduced: " +  cardsArrayReduced.size)

        val finalCard = Card("", "", "", "")
        cardsArrayReduced.add(finalCard)

        return cardsArrayReduced
    }


    private fun reduceListSize(arrayList: ArrayList<Card>, size: Int): ArrayList<Card> {
        val result = ArrayList<Card>()
        val indexArray : MutableSet<Int> = getIndexesForReducedArray(size)
        for(i in indexArray)
            result.add(arrayList[i])

        return result
    }

    private fun reduceListSize(arrayList: ArrayList<Card>): ArrayList<Card> {
        if(arrayList.size < DECK_SIZE)
            return arrayList

        val result = ArrayList<Card>()
        val indexArray : MutableSet<Int> = getIndexesForReducedArray(arrayList.size)
        for(i in indexArray)
            result.add(arrayList[i])

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
            "Design Patterns" -> return "design_patterns_cards.json"
            "Object Oriented" -> return "object_oriented_cards.json"
        }
        return ""
    }

    companion object {
        private val TAG : String = CardsActivity::class.java.simpleName
    }
}
