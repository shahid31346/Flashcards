package com.saishaddai.bwq.fragment

import android.content.Context
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import com.saishaddai.bwq.MainActivity
import com.saishaddai.bwq.R

//import android.R


//import android.R
//import android.app.Activity


class SettingsFragment : Fragment() {
//    lateinit var context : Context

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        val convertView: View = inflater.inflate(R.layout.fragment_settings, container, false)


        convertView.findViewById<Switch>(R.id.reload_button).setOnCheckedChangeListener { _, isChecked ->
            println("checked: " + isChecked)
        }
        return convertView
    }

//    private val themeSwitchListener = CompoundButton.OnCheckedChangeListener {
//        (buttonView,  isChecked) {
//            if (isChecked) {
//                PreferenceHelper.saveBooleanToPreferences(
//                    Constants.PREF_SYNC_OVER_WIFI_ONLY,
//                    true, getApplicationContext()
//                )
//            } else {
//                PreferenceHelper.saveBooleanToPreferences(
//                    Constants.PREF_SYNC_OVER_WIFI_ONLY,
//                    false, getApplicationContext()
//                )
//            }
//        }
//    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        (context as MainActivity).supportActionBar?.setTitle(R.string.title_settings)
        context.supportActionBar?.setLogo(R.drawable.ic_stats)
//        @this.context = context
//        (context as MainActivity).title = getString(R.string.title_settings)
    }

}