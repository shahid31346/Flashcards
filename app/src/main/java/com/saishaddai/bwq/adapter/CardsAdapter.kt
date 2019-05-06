package com.saishaddai.bwq.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.util.Log
import com.saishaddai.bwq.fragment.CardFragment
import com.saishaddai.bwq.model.Card


class CardsAdapter(fragmentManager: FragmentManager, private val cards: ArrayList<Card>) :
        FragmentStatePagerAdapter(fragmentManager) {


    override fun getCount(): Int {
        return cards.size
    }

    override fun getItem(position: Int): Fragment {
        val cardFragment = CardFragment()
        val bundle = Bundle()
        val cardItem = cards[position]
        bundle.putParcelable("card", cardItem)
        Log.d(TAG, "getting card for " + cardItem.title)
        cardFragment.arguments = bundle
        return cardFragment
    }

    companion object {
        private val TAG = CardsAdapter::class.java.simpleName
    }

}