package com.saishaddai.bwq.commons

import org.junit.Assert
import org.junit.Test

class UIUtilsTest {

    @Test
    fun testGetMillisDecorated() {
        val uiUtils = UIUtils()
        var millisDecorated = uiUtils.getMillisDecorated(0)
        Assert.assertEquals("00:00:00", millisDecorated)

        millisDecorated = uiUtils.getMillisDecorated(1000)
        Assert.assertEquals("00:00:01", millisDecorated)

        var millis : Long = 1000 * 60 * 60
        millisDecorated = uiUtils.getMillisDecorated(millis)
        Assert.assertEquals("01:00:00", millisDecorated)


        millis = (1000 * 60 * 60) + (1000 * 60) + 1000
        millisDecorated = uiUtils.getMillisDecorated(millis)
        Assert.assertEquals("01:01:01", millisDecorated)


        millis = 1552620652685
        millisDecorated = uiUtils.getMillisDecorated(millis)
        Assert.assertEquals("+99:99:99", millisDecorated)

    }
}