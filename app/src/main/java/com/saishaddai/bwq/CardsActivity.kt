package com.saishaddai.bwq

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.saishaddai.bwq.adapter.CardsAdapter
import com.saishaddai.bwq.model.ViewModel
import kotlinx.android.synthetic.main.activity_cards.*


class CardsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        val listOfCards = arrayListOf<ViewModel.Card>()
        val card1 = ViewModel.Card("A", "Fragments onAttach method", "Since API 23, on attach(Activity) is deprecated. It should be used onAttach(Context)")
        val card2 = ViewModel.Card("A", "Java/Kotlin interoperability", "To use the activity's context, you call it in Java as MainActivity.this. In Kotlin it is this@MainActivity")
        val finalCard = ViewModel.Card("B", "", "FINISH")
        listOfCards.add(card1)
        listOfCards.add(card2)
        listOfCards.add(finalCard)
//        println("list.isEmpty() is ${list.isEmpty()}") // true
//
//        list.addAll(listOf(1, 2, 3))
//        println(list) // [1, 2, 3]
        cardsPager.adapter = CardsAdapter(supportFragmentManager, listOfCards)
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//    }
}
