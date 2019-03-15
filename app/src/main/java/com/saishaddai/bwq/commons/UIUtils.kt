package com.saishaddai.bwq.commons

import java.util.concurrent.TimeUnit


class UIUtils {

    fun getMillisDecorated(millis : Long) : String {
        if(TimeUnit.MILLISECONDS.toHours(millis) >= 100)
            return "+99:99:99"

        return String.format("%02d:%02d:%02d",
            TimeUnit.MILLISECONDS.toHours(millis),
            TimeUnit.MILLISECONDS.toMinutes(millis) -
                    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
            TimeUnit.MILLISECONDS.toSeconds(millis) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)))


    }
}
