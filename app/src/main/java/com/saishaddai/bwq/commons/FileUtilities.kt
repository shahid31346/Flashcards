package com.saishaddai.bwq.commons

import android.content.res.AssetManager
import android.util.Log
import java.io.BufferedReader
import java.io.IOException

private const val ERROR_FOUND = -9

class FileUtilities {

    companion object {
        private val TAG: String = FileUtilities::class.java.simpleName

        fun getFileContents(assets: AssetManager, fileName: String): String {
            val result = StringBuilder()
            var reader: BufferedReader?  = null
            val possibleError = try {
                reader = BufferedReader(java.io.InputStreamReader(assets.open(fileName)))
                do {
                    val mLine = reader.readLine()
                    if(mLine != null)
                        result.append(mLine)
                } while (mLine != null)
            } catch (e: IOException) {
                ERROR_FOUND
            } finally {
                reader?.close()
            }

            if (possibleError == ERROR_FOUND)
                throw IOException()

            Log.e(TAG, result.toString())
            return result.toString()
        }
    }
}