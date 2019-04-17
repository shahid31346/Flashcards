package com.saishaddai.bwq.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.saishaddai.bwq.model.Deck


class DecksAdapter(private val decks: ArrayList<Deck>) : BaseAdapter() {

    override fun getItem(position: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder : ViewHolder = convertView?.tag as ViewHolder

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun getCount(): Int {
        return decks.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}

