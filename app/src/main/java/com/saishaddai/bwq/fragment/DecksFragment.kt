package com.saishaddai.bwq.fragment

import android.content.Intent
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saishaddai.bwq.CardsActivity
import com.saishaddai.bwq.R
import kotlinx.android.synthetic.main.fragment_decks.*

class DecksFragment : Fragment() {

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        val convertView = inflater.inflate(R.layout.fragment_decks, container, false)
//        val javaImageView = convertView.findViewById<ImageView>(R.id.javaImageView)

//        java_card.setOnClickListener {
//            activity?.let { callingActivity ->
//                val intent = Intent(callingActivity, CardsActivity::class.java)
//                intent.putExtra("type", "Java")
//                startActivity(intent) }
//        }

//        activity?.let {
//            callingActivity -> Glide.with(callingActivity)
//            .load(R.drawable.ic_bwq_logo)
//            .apply(RequestOptions.circleCropTransform())
//            .into(javaImageView)
//        }

        return convertView
    }

}