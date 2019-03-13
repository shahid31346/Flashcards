package com.saishaddai.bwq.fragment

import android.content.Intent
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.saishaddai.bwq.CardsActivity
import com.saishaddai.bwq.R

class DecksFragment : Fragment() {

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        val convertView = inflater.inflate(R.layout.fragment_decks, container, false)
        val javaImageView = convertView.findViewById<ImageView>(R.id.javaImageView)
        val javaCard = convertView.findViewById<CardView>(R.id.javaCard)



        javaCard.setOnClickListener {
            activity?.let { callingActivity -> startActivity(Intent(callingActivity, CardsActivity::class.java)) }
        }

        activity?.let {
            callingActivity -> Glide.with(callingActivity)
            .load(R.drawable.ic_bwq_logo)
            .apply(RequestOptions.circleCropTransform())
            .into(javaImageView)
        }

        return convertView
    }

}