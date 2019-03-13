package com.saishaddai.bwq.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.saishaddai.bwq.fragment.CardFragment
import com.saishaddai.bwq.model.ViewModel


class CardsAdapter(fragmentManager: FragmentManager, private val cards: ArrayList<ViewModel.Card>) :
        FragmentStatePagerAdapter(fragmentManager) {


    override fun getCount(): Int {
        return cards.size
    }

    override fun getItem(position: Int): Fragment {
        val cardFragment = CardFragment()
        var bundle = Bundle()
//            bundle.putString("key", "" + position)
        val cardItem = cards[position]
        bundle.putParcelable("card", cardItem)
//        if(cardItem.type == "A") {
//            cardFragment
//        }
//        cardFragment.title = ""
//        cardFragment.text = ""
        cardFragment.arguments = bundle
        return cardFragment
    }

}