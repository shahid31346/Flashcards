package com.saishaddai.bwq.adapter

import android.app.AlertDialog
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.saishaddai.bwq.R
import com.saishaddai.bwq.model.Deck
import org.jetbrains.anko.find


class DecksAdapter(private val decks: List<Deck>) : RecyclerView.Adapter<DecksAdapter.ViewHolder>() {

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.deck_cell_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return decks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val deck = decks[position]
        Log.d(TAG, "setting UI for: " + deck.name)
        holder.shortTextView.text = deck.short
        holder.nameTextView.text = deck.name
        holder.cardsCountTextView.text = context.getString(R.string.decks_number_of_cards, deck.cards.toString())
        holder.lastTimeTextView.text = context.getString(R.string.decks_date_placeholder)
        holder.infoImageView.setOnClickListener {
            Log.d(TAG, "" + deck.description)
            AlertDialog.Builder(context).setTitle(deck.name).setMessage(deck.description).show()
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shortTextView = itemView.find<TextView>(R.id.shortTextView)
        val nameTextView = itemView.find<TextView>(R.id.nameTextView)
        val cardsCountTextView = itemView.find<TextView>(R.id.cardsCountTextView)
        val lastTimeTextView = itemView.find<TextView>(R.id.lastTimeTextView)
        val infoImageView = itemView.find<ImageView>(R.id.infoImageView)
    }

    companion object {
        private val TAG = DecksAdapter::class.java.simpleName
    }

}

