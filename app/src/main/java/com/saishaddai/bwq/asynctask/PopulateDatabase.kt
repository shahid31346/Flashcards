package com.saishaddai.bwq.asynctask

import android.app.Dialog
import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.RelativeLayout
import android.widget.ProgressBar



//should change to Anko some day

class PopulateDatabase(private val context: Context) : AsyncTask<Void, Void, String>() {

    private val tag = PopulateDatabase::class.java.simpleName as String

    override fun onPreExecute() {
        var progressBar = ProgressBar(context, null, android.R.attr.progressBarStyleLarge)
//        val params = RelativeLayout.LayoutParams(100, 100)
//        params.addRule(RelativeLayout.CENTER_IN_PARENT)
//        layout.addView(progressBar, params)
//        progressBar.setVisibility(View.VISIBLE)
//
        Log.d(tag, "open a dialog to block the UI")
    }

    override fun doInBackground(vararg p0: Void?): String {
        Log.d(tag, "do in background")
        return ""
    }

    override fun onPostExecute(result: String?) {
        Log.d(tag, "close a dialog to block the UI")
    }

}